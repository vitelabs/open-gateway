package org.vite.gateway.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.squirrelframework.foundation.fsm.StateMachine;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;
import org.vite.gateway.blockchain.model.Transaction;
import org.vite.gateway.blockchain.model.TransferResult;
import org.vite.gateway.blockchain.protocol.BlockchainFacade;
import org.vite.gateway.database.DBFacade;
import org.vite.gateway.database.po.generated.CrossChainTransfer;
import org.vite.gateway.database.po.generated.Transfer;
import org.vite.gateway.model.enums.CrossChainTransferState;
import org.vite.gateway.model.enums.TransactionType;
import org.vite.gateway.model.enums.TransferState;
import org.vite.gateway.model.enums.TransferType;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@States({
        @State(name = "UNKNOWN"),
        @State(name = "SOURCE_TRANSACTION_FOUND", entryCallMethod = "pollConfirmation"),
        @State(name = "SOURCE_TRANSACTION_CONFIRMED", entryCallMethod = "prepareSending"),
        @State(name = "SOURCE_TRANSACTION_FAILED"),
        @State(name = "DEST_TRANSACTION_SENDING"),
        @State(name = "DEST_TRANSACTION_SENT", entryCallMethod = "pollConfirmation"),
        @State(name = "DEST_TRANSACTION_CONFIRMED"),
        @State(name = "DEST_TRANSACTION_FAILED")
})
@Transitions({
        // recover state from persistent data
        @Transit(from = "UNKNOWN", to = "SOURCE_TRANSACTION_FOUND", on = "RECOVER_FROM_SOURCE_TRANSACTION_FOUND"),
        @Transit(from = "UNKNOWN", to = "SOURCE_TRANSACTION_CONFIRMED", on = "RECOVER_FROM_SOURCE_TRANSACTION_CONFIRMED"),
        @Transit(from = "UNKNOWN", to = "DEST_TRANSACTION_SENT", on = "RECOVER_FROM_DEST_TRANSACTION_SENT"),
        // source transaction is confirmed
        @Transit(from = "SOURCE_TRANSACTION_FOUND", to = "SOURCE_TRANSACTION_CONFIRMED", on = "TRANSACTION_CONFIRMED"),
        // send dest transaction
        @Transit(from = "SOURCE_TRANSACTION_CONFIRMED", to = "DEST_TRANSACTION_SENDING", on = "TASK_LOCKED", callMethod = "sendToken"),
        // dest transaction sent
        @Transit(from = "DEST_TRANSACTION_SENDING", to = "DEST_TRANSACTION_SENT", on = "TRANSFER_SUCCESS"),
        // dest transaction is confirmed
        @Transit(from = "DEST_TRANSACTION_SENT", to = "DEST_TRANSACTION_CONFIRMED", on = "TRANSACTION_CONFIRMED"),
        // sending failed
        @Transit(from = "DEST_TRANSACTION_SENDING", to = "DEST_TRANSACTION_FAILED", on = "TRANSFER_ERROR")
})
public class TransferTask extends AbstractStateMachine<TransferTask, CrossChainTransferState, String, Transaction> implements StateMachine<TransferTask, CrossChainTransferState, String, Transaction> {
    private final String taskId = UUID.randomUUID().toString();
    private static final StateMachineBuilder<TransferTask, CrossChainTransferState, String, Transaction> builder = StateMachineBuilderFactory.create(TransferTask.class, CrossChainTransferState.class, String.class, Transaction.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferTask.class);
    private CrossChainTransfer crossChainTransfer;
    private Transfer transfer;
    private DBFacade database;
    private BlockchainFacade sourceBlockchain;
    private BlockchainFacade destBlockchain;
    private Timer timer = new Timer();

    private TransferTask() {
        this.addDeclarativeListener(this);
    }

    public static TransferTask create(DBFacade database, BlockchainFacade sourceBlockchain, BlockchainFacade destBlockchain) {
        LOGGER.debug("Create new task");
        TransferTask instance = builder.newStateMachine(CrossChainTransferState.UNKNOWN);

        instance.database = database;
        instance.sourceBlockchain = sourceBlockchain;
        instance.destBlockchain = destBlockchain;

        return instance;
    }

    public void start(CrossChainTransfer crossChainTransfer) {
        if (crossChainTransfer == null) {
            return;
        }
        LOGGER.info("Start Transfer Task with {}", crossChainTransfer);
        this.crossChainTransfer = crossChainTransfer;
        // prepare resume event
        String event = "RECOVER_FROM_" + crossChainTransfer.getState();
        fire(event);
    }

    private void pollConfirmation(CrossChainTransferState from, CrossChainTransferState to, String event, Transaction context) {
        LOGGER.debug("Start polling confirmation in {}", to);
        String hash;
        BlockchainFacade blockchainFacade;

        if (to == CrossChainTransferState.SOURCE_TRANSACTION_FOUND) {
            // poll source blockchain
            hash = crossChainTransfer.getHashSource();
            if (hash == null) {
                return;
            }
            blockchainFacade = sourceBlockchain;
        } else {
            // poll dest blockchain
            hash = crossChainTransfer.getHashDest();
            if (hash == null) {
                return;
            }
            blockchainFacade = destBlockchain;
        }

        TimerTask timerTask = new TimerTask() {
            private long lastConfirmations = 0;

            @Override
            public void run() {
                LOGGER.debug("Polling transaction task is running: {}", hash);
                Transaction transaction = blockchainFacade.getTransaction(hash);
                if (transaction == null) {
                    LOGGER.info("Transaction not found: {}", hash);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }

                boolean confirmed = blockchainFacade.isConfirm(transaction);
                LOGGER.debug("Check transaction confirmation: {} -> {}", confirmed, transaction);

                if (confirmed) {
                    fire("TRANSACTION_CONFIRMED", transaction);
                    // stop polling task
                    this.cancel();
                } else if (lastConfirmations != transaction.getConfirmations()) {
                    lastConfirmations = transaction.getConfirmations();
                    // update confirmations
                    if (to == CrossChainTransferState.SOURCE_TRANSACTION_FOUND) {
                        // update source blockchain
                        crossChainTransfer.setConfirmationsSource(lastConfirmations);
                    } else {
                        // update dest blockchain
                        crossChainTransfer.setConfirmationsDest(lastConfirmations);
                    }
                    database.updateCrossChainTransfer(crossChainTransfer);
                }
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, 5000);
    }

    private void prepareSending(CrossChainTransferState from, CrossChainTransferState to, String event, Transaction context) {
        long crossChainTransferId = crossChainTransfer.getId();
        transfer = database.getTransfer(crossChainTransferId);
        if (transfer == null) {
            // there's not a record in database yet, insert one
            transfer = new Transfer();
            Date now = new Date();
            transfer.setTransferType(TransferType.FUND);
            transfer.setTaskId(taskId);
            transfer.setRefId(crossChainTransferId);
            transfer.setBlockchain(crossChainTransfer.getBlockchainDest());
            transfer.setTokenId(crossChainTransfer.getTokenIdDest());
            transfer.setAmount(crossChainTransfer.getAmount());
            transfer.setToAddress(crossChainTransfer.getToAddressDest());
            transfer.setState(TransferState.UNKNOWN);
            transfer.setCtime(now);
            transfer.setUtime(now);

            if (database.insertTransfer(transfer)) {
                // fetch again to double check
                transfer = database.getTransfer(crossChainTransferId);
                if (transfer != null && transfer.getTaskId().equals(taskId)) {
                    Transaction sendTx = new Transaction();
                    sendTx.setTransactionType(TransactionType.EXPENSE);
                    sendTx.setToAddress(crossChainTransfer.getToAddressDest());
                    sendTx.setBlockchain(crossChainTransfer.getBlockchainDest());
                    sendTx.setToken(crossChainTransfer.getTokenIdDest());
                    sendTx.setAmount("" + crossChainTransfer.getAmount());

                    fire("TASK_LOCKED", sendTx);
                } else {
                    // double check failed, fail this task
                    LOGGER.error("Transfer task {} double check failed, task record is {}", taskId, transfer);
                    fire("TRANSFER_ERROR");
                }
            } else {
                LOGGER.error("Fail to insert transfer task record {}", transfer);
                fire("TRANSFER_ERROR");
            }
        } else {
            // there's already a task running
            LOGGER.error("There's already a transfer task with refid: {}", crossChainTransferId);
        }

    }

    private void sendToken(CrossChainTransferState from, CrossChainTransferState to, String event, Transaction context) {
        // do sending
        TransferResult transferResult = destBlockchain.sendTransaction(context);

        if (transferResult.isSuccess()) {
            // successfully sent
            // update transfer record
            String hash = transferResult.getTransaction().getHash();
            crossChainTransfer.setHashDest(hash);

            database.updateCrossChainTransfer(crossChainTransfer);

            // update transfer task record
            transfer.setState(TransferState.SUCCESS);
            transfer.setHash(hash);

            database.updateTransfer(transfer);

            // FSM transit
            fire("TRANSFER_SUCCESS");
        } else {
            // fail to send coin
            // update task record
            transfer.setState(TransferState.FAILED);
            transfer.setMessage(transferResult.getMessage());

            database.updateTransfer(transfer);

            // FSM transit
            fire("TRANSFER_ERROR");
        }
    }


    @OnTransitionComplete
    public void updateRecord(CrossChainTransferState from, CrossChainTransferState to, String event, Transaction context) {
        LOGGER.info("Transfer Task {} -> {}: {}", from, to, crossChainTransfer);
        // update deposit record in database
        crossChainTransfer.setState(getCurrentState());

        database.updateCrossChainTransfer(crossChainTransfer);
    }


    @Override
    public String toString() {
        return "Task [" + getCurrentState() +
                "] | " + crossChainTransfer;
    }
}
