# hexutil

路径: `ogithub.com/ethereum/go-ethereum/common/hexutil`

阅读代码时要注意这是个raw类型还是已经被编码为hex的类型，比如:
`raw := 0x1024`
编码后为`encoded := "0x0004"`(小端)。

包括两个文件:

`hexutil.go`： 处理byte切片和整形，他们都必须以0x开头。

其中byte切片的长度必须是偶数，如果长度为空，那以"0x"表示。
整形必须以最短的形式表示，也就是说不能有leading zeros，但是整数0可以以"0x0"表示。


`json.go`: 

感觉基本也没做什么事情，所谓UnmarshalJSON/UnmarshalFixedJSON也只是确认下`buf[0] == '"'`以及`buf[len(buf)-1] == '"'`然后就把引号剥离交给对应的UnmarshalText/UnmarshalFixedText来做。然后UnmarshalText/UnmarshalFixedText也是通过checkText把前面的0x去掉，检查数据有效性，最后交给hex.Decode来解码。
