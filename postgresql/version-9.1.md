#### 写在最前面
本人阅读源自：[官方文档中文翻译](http://wiki.postgresql.org/wiki/9.1%E6%96%87%E6%A1%A3%E7%BF%BB%E8%AF%91%E9%A1%B9%E7%9B%AE)

## chapter 1
### 1.1 安装
远程机器需要设置 PGHOST 和 PGPORT。
### 1.2 体系基本概念
服务器进程： postgres 和 客户端进程（用户自定义）  
PostgreSQL为每个请求 fork 一个新进程。然后，客户端和新服务器端进程就不再经过最初的postgres 进程而直接通信。

### 1.3 创建一个数据库
三个命令：  
* createdb mydb
* createdb  // 使用默认数据库名，和你当前用户名同名的数据库
* dropdb mydb  // 对于这条命令而言，数据库名不是缺省的用户名。这样你就必须声明它。  

### 1.4 访问数据库
1. psql mydb // 如果你没有提供数据库名字，那么它缺省就是你的用户账号名字。同 createdb  
命令提示符 mydb=> ,若如果是 **mydb=#** ,意味着你是一个超级数据库用户。  
2. mydb=> SELECT version();  
3. mydb=> SELECT current_date;  
4. mydb=> SELECT 2 + 2;  
psql 程序有一些不属于 SQL 命令的内部命令。 它们以反斜杠开头，"\"。  
5. mydb=> \h // 帮助语法
6. mydb=> \q // 退出psql


