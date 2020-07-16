package org.vite.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.vite.gateway.blockchain.BlockchainDelegate;
import org.vite.gateway.blockchain.model.AddressAndMemo;
import org.vite.gateway.blockchain.model.AddressValidation;
import org.vite.gateway.database.DBFacade;
import org.vite.gateway.database.po.generated.CrossChainTransfer;
import org.vite.gateway.database.po.generated.DepositAddress;
import org.vite.gateway.database.po.generated.TokenInfo;
import org.vite.gateway.model.api.*;
import org.vite.gateway.model.enums.CrossChainTransferState;
import org.vite.gateway.model.enums.DepositAddressState;
import org.vite.gateway.model.enums.DepositRecordState;
import org.vite.gateway.model.enums.WithdrawRecordState;
import org.vite.gateway.util.NumberUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultGatewayService implements GatewayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultGatewayService.class);

    @Autowired
    private DBFacade database;

    @Autowired
    private BlockchainDelegate blockchainDelegate;

    @Value("${gateway.depositLabel}")
    private String depositLabel;

    @Value("${gateway.depositNotice}")
    private String depositNotice;

    @Value("${gateway.withdrawLabel}")
    private String withdrawLabel;

    @Value("${gateway.withdrawNotice}")
    private String withdrawNotice;

    @Override
    public MetaInfo metaInfo(String tokenId) {
        String blockchain = blockchainDelegate.getMappingBlockchain();
        TokenInfo tokenInfo = database.getTokenInfo(blockchain, tokenId);
        if (tokenInfo == null) {
            return null;
        }
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.setType(blockchainDelegate.getAddressType());
        metaInfo.setDepositState(tokenInfo.getDepositState());
        metaInfo.setWithdrawState(tokenInfo.getWithdrawState());
        return metaInfo;
    }

    @Override
    public DepositInfo depositInfo(String tokenId, String walletAddress) {
        String originBlockchain = blockchainDelegate.getOriginBlockchain();
        String mappingBlockchain = blockchainDelegate.getMappingBlockchain();

        TokenInfo tokenInfo = database.getTokenInfo(mappingBlockchain, tokenId);
        if (tokenInfo == null) {
            return null;
        }

        Date now = new Date();

        DepositAddress depositAddress = database.getDepositAddressByMappingAddress(originBlockchain, mappingBlockchain, walletAddress);

        if (depositAddress == null) {
            // new user
            depositAddress = new DepositAddress();
            depositAddress.setOriginBlockchain(originBlockchain);
            depositAddress.setMappingBlockchain(mappingBlockchain);
            depositAddress.setMappingAddress(walletAddress);
            depositAddress.setState(DepositAddressState.VALID);
            depositAddress.setCtime(now);
            depositAddress.setUtime(now);
            // fetch new deposit address
            AddressAndMemo addressAndMemo = blockchainDelegate.getOriginBlockchainFacade().getNewAddress(walletAddress);
            depositAddress.setOriginAddress(addressAndMemo.getAddress());
            depositAddress.setMemo(addressAndMemo.getMemo());

            // insert record
            database.insertDepositAddress(depositAddress);
        }

        DepositInfo result = new DepositInfo();
        result.setDepositAddress(depositAddress.getOriginAddress());
        result.setLabel(depositAddress.getMemo());
        result.setMinimumDepositAmount("" + tokenInfo.getMinDepositAmount());
        result.setConfirmationCount(blockchainDelegate.getOriginConfirmations());
        result.setLabelName(depositLabel);
        result.setNoticeMsg(depositNotice);

        return result;
    }

    @Override
    public WithdrawInfo withdrawInfo(String tokenId, String walletAddress) {
        String blockchain = blockchainDelegate.getMappingBlockchain();
        String withdrawAddress = blockchainDelegate.getWithdrawAddress();

        TokenInfo tokenInfo = database.getTokenInfo(blockchain, tokenId);
        if (tokenInfo == null) {
            return null;
        }
        int decimals = blockchainDelegate.getDecimals();

        WithdrawInfo withdrawInfo = new WithdrawInfo();
        withdrawInfo.setMinimumWithdrawAmount(NumberUtil.toViteAmount(tokenInfo.getMinWithdrawAmount(), decimals));
        withdrawInfo.setMaximumWithdrawAmount(NumberUtil.toViteAmount(tokenInfo.getMaxWithdrawAmount(), decimals));
        withdrawInfo.setGatewayAddress(withdrawAddress);
        withdrawInfo.setLabelName(withdrawLabel);
        withdrawInfo.setNoticeMsg(withdrawNotice);

        return withdrawInfo;
    }

    @Override
    public AddressVerification verificationAddress(String tokenId, String withdrawAddress, String label) {
        AddressValidation validation = blockchainDelegate.getOriginBlockchainFacade().validateAddress(withdrawAddress);

        return new AddressVerification(validation.isValid(), validation.getMessage());
    }

    @Override
    public WithdrawFee withdrawFee(String tokenId, String amount, String walletAddress, boolean containsFee) {
        String blockchain = blockchainDelegate.getMappingBlockchain();
        TokenInfo tokenInfo = database.getTokenInfo(blockchain, tokenId);
        if (tokenInfo == null) {
            return null;
        }
        WithdrawFee result = new WithdrawFee();
        // TODO: dynamic fee
        result.setFee(NumberUtil.toViteAmount(tokenInfo.getWithdrawFee(), blockchainDelegate.getDecimals()));

        return result;
    }

    @Override
    public DepositRecords depositRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        int decimals = blockchainDelegate.getDecimals();

        // deposit transfer: origin blockchain -> mapping blockchain
        String blockchainSource = blockchainDelegate.getOriginBlockchain();
        String blockchainDest = blockchainDelegate.getMappingBlockchain();

        DepositRecords depositRecords = new DepositRecords();
        long count = database.countCrossChainTransfersByDestAddress(blockchainSource, blockchainDest, walletAddress);
        depositRecords.setTotalCount(count);
        if (count <= 0) {
            return depositRecords;
        }

        List<CrossChainTransfer> records = database.getCrossChainTransfersByDestAddress(blockchainSource, blockchainDest, walletAddress, pageNum, pageSize);
        if (records != null) {
            List<DepositRecords.DepositRecordItem> items = records.stream()
                    .map(record -> {
                        DepositRecords.DepositRecordItem item = new DepositRecords.DepositRecordItem();
                        item.setInTxHash(record.getHashSource());
                        // format amount and fee by decimals: 1.23 (4 decimals) -> 12300
                        item.setAmount(NumberUtil.toViteAmount(record.getAmount(), decimals));
                        item.setFee(NumberUtil.toViteAmount(record.getFeeSource(), decimals));
                        item.setInTxConfirmedCount(record.getConfirmationsSource().intValue());
                        item.setOutTxHash(record.getHashDest());
                        item.setState(mappingDepositRecordState(record.getState()).toString());
                        item.setInTxConfirmationCount(blockchainDelegate.getOriginConfirmations());
                        item.setDateTime("" + record.getTransactionTimeSource().getTime());
                        return item;
                    })
                    .collect(Collectors.toList());

            depositRecords.setDepositRecords(items);
            depositRecords.setInTxExplorerFormat(blockchainDelegate.getOriginExplorerUrl());
            depositRecords.setOutTxExplorerFormat(blockchainDelegate.getMappingExplorerUrl());
        }

        return depositRecords;
    }

    @Override
    public WithdrawRecords withdrawRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        int decimals = blockchainDelegate.getDecimals();

        // withdraw transfer: mapping blockchain -> origin blockchain
        String blockchainSource = blockchainDelegate.getMappingBlockchain();
        String blockchainDest = blockchainDelegate.getOriginBlockchain();

        WithdrawRecords withdrawRecords = new WithdrawRecords();
        long count = database.countCrossChainTransfersBySourceAddress(blockchainSource, blockchainDest, walletAddress);
        withdrawRecords.setTotalCount(count);
        if (count <= 0) {
            return withdrawRecords;
        }

        List<CrossChainTransfer> records = database.getCrossChainTransfersBySourceAddress(blockchainSource, blockchainDest, walletAddress, pageNum, pageSize);
        if (records != null) {
            List<WithdrawRecords.WithdrawRecordItem> items = records.stream()
                    .map(record -> {
                        WithdrawRecords.WithdrawRecordItem item = new WithdrawRecords.WithdrawRecordItem();
                        item.setInTxHash(record.getHashSource());
                        // format amount and fee by decimals: 1.23 (4 decimals) -> 12300
                        item.setAmount(NumberUtil.toViteAmount(record.getAmount(), decimals));
                        item.setFee(NumberUtil.toViteAmount(record.getFeeSource(), decimals));
                        item.setInTxConfirmedCount(record.getConfirmationsSource().intValue());
                        item.setOutTxHash(record.getHashDest());
                        item.setState(mappingWithdrawRecordState(record.getState()).toString());
                        item.setInTxConfirmationCount(blockchainDelegate.getMappingConfirmations());
                        item.setDateTime("" + record.getTransactionTimeSource().getTime());
                        return item;
                    })
                    .collect(Collectors.toList());

            withdrawRecords.setWithdrawRecords(items);
            withdrawRecords.setInTxExplorerFormat(blockchainDelegate.getMappingExplorerUrl());
            withdrawRecords.setOutTxExplorerFormat(blockchainDelegate.getOriginExplorerUrl());
        }

        return withdrawRecords;
    }

    private static DepositRecordState mappingDepositRecordState(CrossChainTransferState state) {
        if (state == CrossChainTransferState.SOURCE_TRANSACTION_FOUND) {
            return DepositRecordState.OPPOSITE_PROCESSING;
        } else if (state == CrossChainTransferState.SOURCE_TRANSACTION_CONFIRMED) {
            return DepositRecordState.OPPOSITE_CONFIRMED;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_SENDING
                || state == CrossChainTransferState.DEST_TRANSACTION_SENT) {
            return DepositRecordState.TOT_PROCESSING;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_CONFIRMED) {
            return DepositRecordState.TOT_CONFIRMED;
        } else if (state == CrossChainTransferState.SOURCE_TRANSACTION_FAILED) {
            return DepositRecordState.OPPOSITE_CONFIRMED_FAIL;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_FAILED) {
            return DepositRecordState.FAILED;
        } else {
            return DepositRecordState.UNKNOWN;
        }
    }

    private static WithdrawRecordState mappingWithdrawRecordState(CrossChainTransferState state) {
        if (state == CrossChainTransferState.SOURCE_TRANSACTION_FOUND) {
            return WithdrawRecordState.TOT_PROCESSING;
        } else if (state == CrossChainTransferState.SOURCE_TRANSACTION_CONFIRMED) {
            return WithdrawRecordState.TOT_CONFIRMED;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_SENDING
                || state == CrossChainTransferState.DEST_TRANSACTION_SENT) {
            return WithdrawRecordState.OPPOSITE_PROCESSING;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_CONFIRMED) {
            return WithdrawRecordState.OPPOSITE_CONFIRMED;
        } else if (state == CrossChainTransferState.SOURCE_TRANSACTION_FAILED) {
            return WithdrawRecordState.TOT_NOT_RECEIVED;
        } else if (state == CrossChainTransferState.DEST_TRANSACTION_FAILED) {
            return WithdrawRecordState.FAILED;
        } else {
            return WithdrawRecordState.UNKNOWN;
        }
    }
}
