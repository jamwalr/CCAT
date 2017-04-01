create if not exists table user (userid int primary key auto_increment, email varchar, name varchar, scores int);

create if not exists table questions (qid int primary key auto_increment, question varchar, image varchar, correctanswer int );

create if not exists table test (testid int primary key auto_increment, start date, endDAte date, uid int, scores int );

create if not exists table answers (id int primary key auto_increment, qid int, text varchar, image varchar);

create if not exists table response (id int primary key auto_increment, uid int, ansid int);