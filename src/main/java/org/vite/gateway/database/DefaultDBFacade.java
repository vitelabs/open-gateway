package org.vite.gateway.database;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.vite.gateway.database.dao.mapper.generated.CrossChainTransferMapper;
import org.vite.gateway.database.dao.mapper.generated.DepositAddressMapper;
import org.vite.gateway.database.dao.mapper.generated.TokenInfoMapper;
import org.vite.gateway.database.dao.mapper.generated.TransferMapper;
import org.vite.gateway.database.po.generated.*;
import org.vite.gateway.model.enums.CrossChainTransferState;

import java.util.Date;
import java.util.List;

@Component()
public class DefaultDBFacade implements DBFacade {
    @Autowired
    private TokenInfoMapper tokenInfoMapper;

    @Autowired
    private DepositAddressMapper depositAddressMapper;

    @Autowired
    private CrossChainTransferMapper crossChainTransferMapper;

    @Autowired
    private TransferMapper transferMapper;

    @Override
    public TokenInfo getTokenInfo(String mappingBlockchain, String mappingTokenId) {
        TokenInfoCriteria criteria = new TokenInfoCriteria();
        criteria.createCriteria()
                .andMappingBlockchainEqualTo(mappingBlockchain)
                .andMappingTokenIdEqualTo(mappingTokenId);

        return firstOrNull(tokenInfoMapper.selectByExample(criteria));
    }

    @Override
    public void insertTokenInfo(TokenInfo tokenInfo) {
        tokenInfoMapper.insert(tokenInfo);
    }

    @Override
    public boolean updateTokenInfo(TokenInfo tokenInfo) {
        int rows = tokenInfoMapper.updateByPrimaryKey(tokenInfo);
        return rows == 1;
    }

    @Override
    public DepositAddress getDepositAddressByMappingAddress(String originBlockchain, String mappingBlockchain, String mappingAddress) {
        DepositAddressCriteria criteria = new DepositAddressCriteria();
        criteria.createCriteria()
                .andOriginBlockchainEqualTo(originBlockchain)
                .andMappingBlockchainEqualTo(mappingBlockchain)
                .andMappingAddressEqualTo(mappingAddress);

        return firstOrNull(depositAddressMapper.selectByExample(criteria));
    }

    @Override
    public DepositAddress getDepositAddressByOriginAddress(String originBlockchain, String mappingBlockchain, String originAddress, String memo) {
        DepositAddressCriteria criteria = new DepositAddressCriteria();
        DepositAddressCriteria.Criteria generated = criteria.createCriteria();
        generated.andOriginBlockchainEqualTo(originBlockchain)
                .andMappingBlockchainEqualTo(mappingBlockchain)
                .andOriginAddressEqualTo(originAddress);
        if (memo != null) {
            generated.andMemoEqualTo(memo);
        }

        return firstOrNull(depositAddressMapper.selectByExample(criteria));
    }

    @Override
    public void insertDepositAddress(DepositAddress depositAddress) {
        depositAddressMapper.insert(depositAddress);
    }


    @Override
    public List<CrossChainTransfer> getCrossChainTransfersBySourceAddress(String blockchainSource, String blockchainDest, String sourceAddress, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize).setOrderBy("id desc");
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchainSource)
                .andBlockchainDestEqualTo(blockchainDest)
                .andFromAddressSourceEqualTo(sourceAddress);


        return crossChainTransferMapper.selectByExample(criteria);
    }

    @Override
    public long countCrossChainTransfersBySourceAddress(String blockchainSource, String blockchainDest, String sourceAddress) {
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchainSource)
                .andBlockchainDestEqualTo(blockchainDest)
                .andFromAddressSourceEqualTo(sourceAddress);

        return crossChainTransferMapper.countByExample(criteria);
    }

    @Override
    public List<CrossChainTransfer> getCrossChainTransfersByDestAddress(String blockchainSource, String blockchainDest, String destAddress, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize).setOrderBy("id desc");
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchainSource)
                .andBlockchainDestEqualTo(blockchainDest)
                .andToAddressDestEqualTo(destAddress);

        return crossChainTransferMapper.selectByExample(criteria);
    }

    @Override
    public long countCrossChainTransfersByDestAddress(String blockchainSource, String blockchainDest, String destAddress) {
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchainSource)
                .andBlockchainDestEqualTo(blockchainDest)
                .andToAddressDestEqualTo(destAddress);

        return crossChainTransferMapper.countByExample(criteria);
    }

    @Override
    public List<CrossChainTransfer> getCrossChainTransfersInStates(String blockchainSource, String blockchainDest, List<CrossChainTransferState> states) {
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchainSource)
                .andBlockchainDestEqualTo(blockchainDest)
                .andStateIn(states);

        return crossChainTransferMapper.selectByExample(criteria);
    }

    @Override
    public boolean containsCrossChainTransfer(String blockchain, String hash) {
        if (hash == null) {
            return false;
        }
        CrossChainTransferCriteria criteria = new CrossChainTransferCriteria();
        criteria.createCriteria()
                .andBlockchainSourceEqualTo(blockchain)
                .andHashSourceEqualTo(hash);

        return crossChainTransferMapper.countByExample(criteria) == 1;
    }

    @Override
    public boolean insertCrossChainTransfer(CrossChainTransfer crossChainTransfer) {
        Date now = new Date();
        crossChainTransfer.setCtime(now);
        crossChainTransfer.setUtime(now);
        int rows = crossChainTransferMapper.insert(crossChainTransfer);
        return rows == 1;
    }

    @Override
    public boolean updateCrossChainTransfer(CrossChainTransfer crossChainTransfer) {
        crossChainTransfer.setUtime(new Date());
        int rows = crossChainTransferMapper.updateByPrimaryKey(crossChainTransfer);
        return rows == 1;
    }

    @Override
    public Transfer getTransfer(Long refId) {
        TransferCriteria criteria = new TransferCriteria();
        criteria.createCriteria()
                .andRefIdEqualTo(refId);

        return firstOrNull(transferMapper.selectByExample(criteria));
    }

    @Override
    public boolean insertTransfer(Transfer transfer) {
        Date now = new Date();
        transfer.setCtime(now);
        transfer.setUtime(now);
        int rows = transferMapper.insert(transfer);
        return rows == 1;
    }

    @Override
    public boolean updateTransfer(Transfer transfer) {
        transfer.setUtime(new Date());
        int rows = transferMapper.updateByPrimaryKey(transfer);
        return rows == 1;
    }

    private static <T> T firstOrNull(List<T> c) {
        if (CollectionUtils.isEmpty(c)) return null;
        return c.get(0);
    }
}
