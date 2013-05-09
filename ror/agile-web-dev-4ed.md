## chapter 25

### 25.2
`<%= %>`会把里面的代码to_s，然后再转义成显示的代码，h 函数已经默认使用了。  
注意raw和sanitize的区别使用,Raw直接全部显示，而sanitize会使得:  
* `<form> and <script> tags are escaped`
* `on= attributes and links starting javascript: are removed`

也就是说： **raw的话，可以自己内部使用，sanitize可以提供给客户自己写html标签。**

### 25.3

