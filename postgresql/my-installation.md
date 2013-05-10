### 写在前面
* 系统：ubuntu 12.04
* postgresql 版本 9.1

使用apt-get安装postgresql，安装后到 / 目录下，使用sudo find -name postgre\* 可以看到安装的位置。  
使用link /usr/lib/postgresql/9.1/bin/postgres /usr/bin/postgres，把该命令加入常用命令列表  
使用 cat /etc/passwd 可以查看已经有一个用户名为postgres的用户被创建。  
这个postgres用户是作为超级用户的存在。根据[最佳实践 Tip](http://www.postgresql.org/docs/9.2/static/role-attributes.html)中的描述。我使用postgres用户暂时先创建2个新账户。
```bash
```

