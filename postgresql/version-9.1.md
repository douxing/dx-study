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

## chapter 20 database roles
在8.1之前的版本中, users和groups是区分的。现在的版本中，已经把这两个概念归入roles这个概念了。  
### 20.1 database roles
创建role: （name符合SQL标识符的规定。可用双引号引起。）  
```sql
CREATE ROLE name;
```
移除role：
```sql
DROP ROLE name;
```
两个命令包括了上述两个sql命令：
```bash
createuser name
dropuser name
```
从pg_roles system catalog中查看:
```sql
SELECT rolname FROM pg_roles; -- psql \du 也可以达到同样效果
```
一个刚被初始化好的系统，总是包含一个预定义的role，"superuser"，默认情况下，它的名字和初始化它的操作系统用户名相同。一般把它改名为 **postgres**。  
psql -U 可以指定连接时的role。createuser 和 psql 都是用当前操作系统用户名作为其默认的role name。因此，最佳实践是： roles和操作系统users之间维护一个对应关系。  

### 20.2 role attributes
数据库 role 可以使用一系列的 attributes 来定义其权限。  
* login privilege
```sql
CREATE ROLE name LOGIN;
CREATE USER name; -- 和 CREATE ROLE 相同，除了 CREATE USER 默认LOGIN权限
```
* superuser status
```sql
CREATE ROLE name SUPERUSER; -- 1. 只有superuser可以创建superuser，2. superuser拥有除了login之外的所有权限
```
* database creation
```sql
CREATE ROLE name CREATEDB; -- 创建数据库的权限
```
* database creation
```sql
CREATE ROLE name CREATEROLE; -- 创建role的权限，除了superuser role之外
```
* initiating replication
```sql
CREATE ROLE name REPLICATION LOGIN; -- 流复制还需要有login权限
```
* password
```sql
CREATE ROLE name PASSWORD 'string'; -- 设置role的密码
```
**使用 ALTER ROLE 来修改role的权限**

end of file


