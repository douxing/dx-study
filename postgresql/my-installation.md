### 写在前面
* 系统：ubuntu 12.04
* postgresql 版本 9.1

### 安装配置过程
使用apt-get安装postgresql，安装后到 / 目录下，使用sudo find -name postgre\* 可以看到安装的位置。  
使用link /usr/lib/postgresql/9.1/bin/postgres /usr/bin/postgres，把该命令加入常用命令列表  
使用 cat /etc/passwd 可以查看已经有一个用户名为postgres的用户被创建。  
这个postgres用户是作为超级用户的存在。根据[最佳实践 Tip](http://www.postgresql.org/docs/9.2/static/role-attributes.html)中的描述。我使用postgres用户暂时先创建1个新账户名叫dx。
```bash
dx@ubuntu:~$ sudo -u postgres createuser dx
Shall the new role be a superuser? (y/n) n
Shall the new role be allowed to create databases? (y/n) y
Shall the new role be allowed to create more new roles? (y/n) y
```
事实上，通过psql --help可以看到，当前使用的默认数据库和默认用户名都是dx。 
因为之前提到过，很多命令的默认用户都是dx（和安装数据库时的操作系统帐号名是相同的），所以以后都会使用dx作为默认的用户名，通过创建名为dx的用户，可以省去很多事情。  
接下来通过dx创建数据库：
```bash
dx@ubuntu:~$ createdb mydb # 创建一个测试数据库
```
这样，就可以通过 psql -d mydb 访问数据库了。


