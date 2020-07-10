package org.vite.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vite.gateway.model.api.*;
import org.vite.gateway.service.GatewayService;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/gateway")
public class GatewayController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @Autowired
    private GatewayService gatewayService;

    @RequestMapping("meta-info")
    public APIResult<MetaInfo> metaInfo(String tokenId) {
       LOGGER.debug("/meta-info -> tokenId: " + tokenId);

        MetaInfo data = gatewayService.metaInfo(tokenId);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Unknown token Id: " + tokenId);
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/deposit-info")
    public APIResult<DepositInfo> depositInfo(String tokenId, String walletAddress) {
        LOGGER.debug("/deposit-info -> tokenId: " + tokenId + ", walletAddress: " + walletAddress);

        DepositInfo data = gatewayService.depositInfo(tokenId, walletAddress);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Fail to get deposit address.");
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/withdraw-info")
    public APIResult withdrawInfo(String tokenId, String walletAddress) {
        LOGGER.debug("/withdraw-info -> tokenId: " + tokenId + ", walletAddress: " + walletAddress);

        WithdrawInfo data = gatewayService.withdrawInfo(tokenId, walletAddress);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Fail to get withdraw info.");
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/withdraw-address/verification")
    public APIResult verificationAddress(String tokenId, String withdrawAddress, String label) {
        LOGGER.debug("/withdraw-address/verification -> tokenId: " + tokenId + ", withdrawAddress: " + withdrawAddress + ", label: " + label);

        AddressVerification data = gatewayService.verificationAddress(tokenId, withdrawAddress, label);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Address verificationAddress failed.");
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/withdraw-fee")
    public APIResult withdrawFee(String tokenId, String amount, String walletAddress, boolean containsFee) {
        LOGGER.debug("/withdraw-fee -> tokenId: " + tokenId + ", amount: " + amount + ", walletAddress: " + walletAddress + ", containsFee: " + containsFee);

        WithdrawFee data = gatewayService.withdrawFee(tokenId, amount, walletAddress, containsFee);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Fail to get withdraw fees.");
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/deposit-records")
    public APIResult depositRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        LOGGER.debug("/deposit-records -> tokenId: " + tokenId + ", walletAddress: " + walletAddress + ", pageNum: " + pageNum + ", pageSize: " + pageSize);

        DepositRecords data = gatewayService.depositRecords(tokenId, walletAddress, pageNum, pageSize);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Fail to get deposit records.");
        }

        return APIResult.buildSuccess(data);
    }

    @RequestMapping("/withdraw-records")
    public APIResult withdrawRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        LOGGER.debug("/withdraw-records -> tokenId: " + tokenId + ", walletAddress: " + walletAddress + ", pageNum: " + pageNum + ", pageSize: " + pageSize);

        WithdrawRecords data = gatewayService.withdrawRecords(tokenId, walletAddress, pageNum, pageSize);

        if (data == null) {
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, "Fail to get withdraw records.");
        }

        return APIResult.buildSuccess(data);
    }

}
