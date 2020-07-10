# Open Gateway
跨链网关是将某一个区块链上的交易映射到另一个区块上的中心化服务。

## 基本概念
为描述方便，我们将这两个区块链中的一个看作原始数字资产平台，而另一个作为该资产映射成为的某种"代币"的发行平台。
将前者称为"原生链"(Origin Blockchain)，或"对手链"(Opposite Blockchain)；后者称为"映射链"(Mapping Blockchain)，或"代币链"(Token Blockchain)。
所映射的原始数字资产称为"原生代币"（Origin Token），映射后在"映射链"上的数字资产称为"TOT"(Token of Token)。

举个例子，发行在以太坊平台上的代币WBTC是1:1锚定比特币的一种ERC20代币，我们称比特币为"原生链"，以太坊为"映射链"，BTC为"原生代币",WBTC为"TOT"。

再举个例子，发行在Binance Chain上的BEP2代币[ETH-1C9](https://explorer.binance.org/asset/ETH-1C9)是一个TOT，其原生代币是：Ether。映射链为：Binance Chain，原生链为：Ethereum。

## 跨链传输
将数字资产的一笔交易，从一个区块链映射到另一个区块链的过程，称为"跨链传输"(Cross-chain Transfer)。
网关将监测源区块链上转入特定地址的交易，一旦该交易被确认，则自动在目标区块链上发出一笔等额的交易。

## 跨链充值
从原生链到映射链的跨链传输称为"跨链充值"(Cross-chain Deposit)；

## 跨链提现
从映射链到原生链的跨链传输称为"跨链提现"(Cross-chain Withdrawal)

# 网关接口文档
[ViteX网关接入教程](https://vite.wiki/zh/dex/operation/gate-integration.html)

[ViteX网关接口协议](https://vite.wiki/zh/dex/api/gate.html)
