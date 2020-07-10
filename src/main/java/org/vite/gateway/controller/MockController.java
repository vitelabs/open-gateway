package org.vite.gateway.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vite.gateway.model.api.APIResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/mock")
public class MockController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MockController.class);

    @RequestMapping("meta-info")
    public APIResult metaInfo(String tokenId) {
        System.out.println("tokenId: " + tokenId);
        return loadJsonFile("meta-info.json");
    }

    @RequestMapping("/deposit-info")
    public APIResult depositInfo(String tokenId, String walletAddress) {
        System.out.println("tokenId: " + tokenId + ", walletAddress: " + walletAddress);
        return loadJsonFile("deposit-info.json");
    }

    @RequestMapping("/withdraw-info")
    public APIResult withdrawInfo(String tokenId, String walletAddress) {
        System.out.println("tokenId: " + tokenId + ", walletAddress: " + walletAddress);
        return loadJsonFile("withdraw-info.json");
    }

    @RequestMapping("/withdraw-address/verificationAddress")
    public APIResult verification(String tokenId, String withdrawAddress, String label) {
        System.out.println("tokenId: " + tokenId + ", withdrawAddress: " + withdrawAddress + ", label: " + label);
        return loadJsonFile("withdraw-address-verificationAddress.json");
    }

    @RequestMapping("/withdraw-fee")
    public APIResult withdrawFee(String tokenId, String amount, String walletAddress, boolean containsFee) {
        System.out.println("tokenId: " + tokenId + ", amount: " + amount + ", walletAddress: " + walletAddress + ", containsFee: " + containsFee);
        return loadJsonFile("withdraw-fee.json");
    }

    @RequestMapping("/deposit-records")
    public APIResult depositRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        System.out.println("tokenId: " + tokenId + ", walletAddress: " + walletAddress + ", pageNum: " + pageNum + ", pageSize: " + pageSize);
        return loadJsonFile("deposit-records.json");
    }

    @RequestMapping("/withdraw-records")
    public APIResult withdrawRecords(String tokenId, String walletAddress, int pageNum, int pageSize) {
        System.out.println("tokenId: " + tokenId + ", walletAddress: " + walletAddress + ", pageNum: " + pageNum + ", pageSize: " + pageSize);
        return loadJsonFile("withdraw-records.json");
    }

    private static APIResult loadJsonFile(String filename) {
        try {
            byte[] data = Files.readAllBytes(
                    Paths.get(ClassLoader.getSystemResource("data/" + filename).toURI())
            );
            APIResult result = JSON.parseObject(data, APIResult.class);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return APIResult.buildInternalError(APIResult.SUB_CODE_ILLEGAL, e.getMessage());
        }
    }

}
