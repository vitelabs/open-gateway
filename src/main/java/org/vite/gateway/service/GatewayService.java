package org.vite.gateway.service;

import org.vite.gateway.model.api.*;

public interface GatewayService {
    MetaInfo metaInfo(String tokenId);

    DepositInfo depositInfo(String tokenId, String walletAddress);

    WithdrawInfo withdrawInfo(String tokenId, String walletAddress);

    AddressVerification verificationAddress(String tokenId, String withdrawAddress, String label);

    WithdrawFee withdrawFee(String tokenId, String amount, String walletAddress, boolean containsFee);

    DepositRecords depositRecords(String tokenId, String walletAddress, int pageNum, int pageSize);

    WithdrawRecords withdrawRecords(String tokenId, String walletAddress, int pageNum, int pageSize);

}
