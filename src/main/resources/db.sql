create table if not exists users (userid int primary key auto_increment, email varchar(100), name varchar(40));

create table if not exists questions (qid int primary key auto_increment, question varchar(99) , image varchar(99) , correctanswer int );

create table if not exists exam (testid int primary key auto_increment, start date, endDAte date, uid int, scores int );

create table if not exists answers (id int primary key auto_increment, qid int, text varchar(99) , image varchar(99) );

create table if not exists response (id int primary key auto_increment, uid int, ansid int);