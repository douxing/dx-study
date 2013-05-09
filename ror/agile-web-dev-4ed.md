## chapter 25

### 25.2
`<%= %>`会把里面的代码to_s，然后再转义成显示的代码，h 函数已经默认使用了。  
注意raw和sanitize的区别使用,Raw直接全部显示，而sanitize会使得:  
* `<form> and <script> tags are escaped`
* `on= attributes and links starting javascript: are removed`

也就是说： **raw的话，可以自己内部使用，sanitize可以提供给客户自己写html标签。**

### 25.3
注意 ~> 的使用：如~>3.1.4，那3.1.x，凡是x>=4的版本都可以，如果~>3.0，那任何3开头的版本都可以。  
也就是说使用 ~> 的匹配是前几项完全匹配，最后一项高于指定版本。

关于bundle install 和 bundle update:  
* bundle install will use the Gemfile.lock as a starting point, and it will install only
the versions of the various gems as specified in this file. 
* bundle update will (unsurprisingly) update one or more named gems and will
update the Gemfile.lock accordingly.  
所以，如果要修改某个gem，那在gemfile里面修改，然后‘bundle update 修改的gem列表‘。  
**不要直接使用bundle update，尤其是将要发布之时。**

