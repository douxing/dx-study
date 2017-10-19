# RLP

RLP 代表 Recursive Length Prefix, 参考：

* https://github.com/ethereum/wiki/wiki/RLP
* https://github.com/ethereum/wiki/wiki/%5B%E4%B8%AD%E6%96%87%5D-RLP

## 理解

首先，它只编码高级数据结构，包括字符串和数组，底层原子数据类型它并不参与编码。
比如1024可能是被编码为'\x04\x00'，或者'\x1\x0\x2\x4'，但是在RLP眼中只管这是一个字符串而已。

其次，RLP编码函数只接受item, 它被定义为:
1. string(如byte数组)
2. items 列表(list)

单个字符编码貌似只到0x7f. 0x80是string的开始; 0xC0是list的开始。
数据长度如果在[0, 55]之间，那是加上对应类型的开始值。
例如这是个长度9的string, 那就编码为`0x89 ...`；
如果这是个长度9的list, 那就编码为`0xC9 ...`;
这样最大编码可以到0xB7(string)和0xF7(list)。
更大的数据，需要用到初始数值为[0xB8, 0xBF] (string), 或为[0xF8, 0xFF] (list),
减去初始值，得到一个长度[1, 8]，表示后面表示数据长度的位数(大端排列)。

如string数据长度为1024, 超过了55，那会如此编码:

`0xB9 0x04 0x00 ...`

因为1024 == 0x400, 这个数要用到两位，所以第一位是0x89(0x87 + 2), 后面两位大端放置，然后填入数据。

**按照我的理解, string和list的编码是通过起始至区分的. 其中list表示的长度也是全长, 而不是list中的item个数.**

另外编码遵从最短编码原则，能用一个字符编码的，不要以长度为1的string编码。





