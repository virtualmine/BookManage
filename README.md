# BookManage
添加数据库操作：
    使用mysql 5.7;
    数据库账号密码默认root;root;(不同的需要修改)；
    
    数据库操作语句：
        create database BookMange
        
        use BookManage;
        
        create table Users(
        	UserName varchar(20),
            UserPwd varchar(20)
        );
        create table Books(
        	BookName varchar(20),
            BookType varchar(20),
            Author varchar(20),
            Price numeric(4,2),
            Remark text
        );
        create table BorrowedBooks(
        	Borrower varchar(20),
            BookName varchar(20),
            BookType varchar(20),
            Author varchar(20),
            Price numeric(4,2),
            Remark text
        );

    