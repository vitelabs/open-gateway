package org.vite.gateway.blockchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.vite.gateway.blockchain.protocol.BlockchainFacade;

import javax.annotation.PostConstruct;

@Component
public class BlockchainDelegate implements ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlockchainDelegate.class);
    private ApplicationContext applicationContext;

    @Autowired
    private Environment env;

    @Value("${gateway.originBlockchain}")
    private String originBlockchain;

    @Value("${gateway.mappingBlockchain}")
    private String mappingBlockchain;

    private BlockchainFacade originBlockchainFacade;

    private BlockchainFacade mappingBlockchainFacade;

    @PostConstruct
    private void init() {
        String beanNameOrigin = originBlockchain + "Facade";
        String beanNameMapping = mappingBlockchain + "Facade";
        LOGGER.info("Loading origin blockchain facade: {} -> {}", originBlockchain, beanNameOrigin);
        originBlockchainFacade = applicationContext.getBean(beanNameOrigin, BlockchainFacade.class);

        LOGGER.info("Loading mapping blockchain facade: {} -> {}", beanNameMapping, beanNameOrigin);
        mappingBlockchainFacade = applicationContext.getBean(beanNameMapping, BlockchainFacade.class);
    }

    public String getOriginBlockchain() {
        return originBlockchain;
    }

    public String getMappingBlockchain() {
        return mappingBlockchain;
    }

    public BlockchainFacade getOriginBlockchainFacade() {
        return originBlockchainFacade;
    }

    public BlockchainFacade getMappingBlockchainFacade() {
        return mappingBlockchainFacade;
    }

    public String getOriginTokenId() {
        return getProperty(originBlockchain, "tokenId");
    }

    public String getMappingTokenId() {
        return getProperty(mappingBlockchain, "tokenId");
    }

    public String getDepositAddress() {
        return getProperty(originBlockchain, "address");
    }

    public String getWithdrawAddress() {
        return getProperty(mappingBlockchain, "address");
    }

    public int getDecimals() {
        return getProperty(mappingBlockchain, "decimals", Integer.class);
    }

    public int getOriginConfirmations() {
        return getProperty(originBlockchain, "confirmations", Integer.class);
    }

    public int getMappingConfirmations() {
        return getProperty(mappingBlockchain, "confirmations", Integer.class);
    }

    public String getOriginExplorerUrl() {
        return getProperty(originBlockchain, "explorerUrl");
    }

    public String getMappingExplorerUrl() {
        return getProperty(mappingBlockchain, "explorerUrl");
    }

    public int getAddressType() {
        return getProperty(originBlockchain, "addressType", Integer.class);
    }

    private <T> T getProperty(String rootKey, String subKey, Class<T> clazz) {
        String key = rootKey.toLowerCase() + "." + subKey;
        return env.getProperty(key, clazz);
    }

    private String getProperty(String rootKey, String subKey) {
        return getProperty(rootKey, subKey, String.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
