package org.vite.gateway.database;

import org.vite.gateway.database.po.generated.CrossChainTransfer;
import org.vite.gateway.database.po.generated.DepositAddress;
import org.vite.gateway.database.po.generated.TokenInfo;
import org.vite.gateway.database.po.generated.Transfer;
import org.vite.gateway.model.enums.CrossChainTransferState;

import java.util.List;

public interface DBFacade {
    TokenInfo getTokenInfo(String mappingBlockchain, String mappingTokenId);

    void insertTokenInfo(TokenInfo tokenInfo);

    boolean updateTokenInfo(TokenInfo tokenInfo);

    DepositAddress getDepositAddressByMappingAddress(String originBlockchain, String mappingBlockchain, String mappingAddress);

    DepositAddress getDepositAddressByOriginAddress(String originBlockchain, String mappingBlockchain, String originAddress, String memo);

    void insertDepositAddress(DepositAddress depositAddress);

    List<CrossChainTransfer> getCrossChainTransfersBySourceAddress(String blockchainSource, String blockchainDest, String sourceAddress, int pageNum, int pageSize);

    long countCrossChainTransfersBySourceAddress(String blockchainSource, String blockchainDest, String sourceAddress);

    List<CrossChainTransfer> getCrossChainTransfersByDestAddress(String blockchainSource, String blockchainDest, String destAddress, int pageNum, int pageSize);

    long countCrossChainTransfersByDestAddress(String blockchainSource, String blockchainDest, String destAddress);

    List<CrossChainTransfer> getCrossChainTransfersInStates(String blockchainSource, String blockchainDest, List<CrossChainTransferState> states);

    boolean containsCrossChainTransfer(String blockchain, String hash);

    boolean insertCrossChainTransfer(CrossChainTransfer crossChainTransfer);

    boolean updateCrossChainTransfer(CrossChainTransfer crossChainTransfer);

    Transfer getTransfer(Long refId);

    boolean insertTransfer(Transfer transfer);

    boolean updateTransfer(Transfer transfer);
}
