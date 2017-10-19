# chain

每个block都有自己的配置。


## 硬分叉列表

- https://ethereum.stackexchange.com/questions/13014/please-confirm-what-the-hard-forks-of-ethereum-were-and-when-they-took-place

以太坊列表经历过几次硬分叉，被编码在代码中，其中主网为：
1. Homestead: 区块高度1150000
2. DAOFork: 貌似是一次被攻击，在其他网络中都没有这次分叉, 区块高度1920000
3. EIP150: 区块高度2463000
4. EIP155, EIP158: 区块高度2675000
5. 拜占庭: 4370000

另外有两个共识算法:
1. Ethash: Power of Work
2. Clique: Power of Authority

问题：
1. EIP158需要单独比较ChainId, why?
