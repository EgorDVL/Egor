create database if not exists diplBD
character set utf8;

use diplBD;

drop table if exists roles;
drop table if exists adminQuery;
drop table if exists profiless;
drop table if exists users;
drop table if exists direction;
drop table if exists test;
drop table if exists questions;
drop table if exists answers;
drop table if exists Answerillustration;
drop table if exists commentTest;
drop table if exists questioninterview;
drop table if exists answerInterview;
drop table if exists commentInterview;

# Таблица ролей
create table if not exists roles(
 `idRoles` int not null AUTO_INCREMENT,
 `role` varchar(20) not null unique,
 primary key (idRoles)
);
insert into roles values(default,'admin');
insert into roles values(default,'regUser');
insert into roles values(default,'noRegUser');

# Таблица adminQuery
create table if not exists adminQuery(
`idAdminQuery` int not null AUTO_INCREMENT,
`query` blob not null,
`date` varchar(20) not null,
`userid` int not null,
`username` varchar(20) not null,
primary key (idAdminQuery)
);
insert into adminQuery values(default,'hello','11.04.16',1,'Vasua');

# Таблица profile
create table if not exists profiless(
`idProfiless` int not null AUTO_INCREMENT,
`e-mail` varchar(30) not null,
`rezults` varchar(20) not null,
`queryid` int not null,
`testid` int not null,
primary key (idProfiless)
);
insert into profiless values(default,'EgorDVL@mail.ru','passed',1,1);


# Таблица user
create table if not exists users(
`idUsers` int not null AUTO_INCREMENT,
`name` varchar(20) not null ,
`surname` varchar(30) not null,
`login` varchar(20)not null unique,
`password` varchar(20)not null,
`roleId` int not null,
primary key(idUsers),
foreign key (roleId) references roles(idRoles)
	on delete restrict on update cascade
);
insert into users values(default,'Vasua','Pupkin','login1','password1',1);


# Таблица направление
create table if not exists direction(
`idDirection` int not null AUTO_INCREMENT,
`nameDirection` varchar(30) not null,
primary key (idDirection)
);
insert into direction values(default,'Java');


# Таблица test
create table if not exists test(
`idTest` int not null AUTO_INCREMENT,
`nameTest` varchar(30) not null,
`directionId` int not null,
primary key (idTest),
foreign key (directionId) references direction(idDirection)
	on delete restrict on update cascade
);
insert into test values (default,'elementary',1);


# Таблица Вопросы тест
create table if not exists questions(
`idQuestions` int not null AUTO_INCREMENT,
`questionName` varchar(100) not null,
`question` blob not null,
`testId` int not null,
primary key (idQuestions),
foreign key (testId) references test(idTest)
	on delete restrict on update cascade
);
insert into questions values (default,'Каким будет результат выполнения данного кода?', 
'public class A{
public static void main(String[] args){
for(int i = 0; ++i > 0;){
system.out.println(i)}}}',
1);

#Таблица ответы тест
create table if not exists answers(
`idAnswers` int not null AUTO_INCREMENT,
`Answer` blob not null,
`questionid` int not null,
`correctAnswer` int not null,
primary key (idAnswers),
foreign key (questionId) references questions(idQuestions)
	on delete restrict on update cascade
);
insert into answers values(default,'Программа зациклится',1,0);
insert into answers values(default,'Напечатает все числа от 1 до 2^32 -1',1,1);
insert into answers values(default,'Ошибка компиляции',1,0);
insert into answers values(default,'StackOverflowError',1,0);

# Таблица Пояснение
create table if not exists Answerillustration(
`idAnswerillustration` int not null AUTO_INCREMENT,
`illustration` blob not null,
`questionId` int not null,
primary key (idAnswerillustration),
foreign key (questionId) references questions(idQuestions)
	on delete restrict on update cascade
);
insert into Answerillustration values 
(default,
'Значение типа int занимает 32 бита (4 байта). Всего возможно 232 различных значений,
 из них половина положительных и половина отрицательных, причём отрицательными считаются числа, у которых старший бит равен единице:
00000000 00000000 00000000 000000002 = 010
00000000 00000000 00000000 000000012 = 110
. . .
01111111 11111111 11111111 111111112 = 214748364710 = 231–1
10000000 00000000 00000000 000000002 = –214748364810 = –231
. . .
11111111 11111111 11111111 111111112 = –110
Поэтому во время выполнения цикла после положительного числа 2147483647 получается отрицательное число –2147483648, 
которое не удовлетворяет условию продолжения цикла и он заканчивает свою работу.',
1);


# Таблица коментарии Теста 
create table if not exists commentTest(
`idCommentTest` int not null AUTO_INCREMENT,
`comment` blob,
`questionId` int not null,
primary key (idCommentTest),
foreign key (questionId) references questions(idQuestions)
	on delete restrict on update cascade
);
insert into commentTest values (default,'Im Passed this test',1);



# Таблица Вопросы на собеседование 
create table if not exists questioninterview(
`idQuestioninterview` int not null AUTO_INCREMENT,
`questionNameinterview` blob not null,
`questioninterview` blob not null,
`directionId` int not null,
primary key (idQuestioninterview),
foreign key (directionId) references direction(idDirection)
	on delete restrict on update cascade
);
insert into questioninterview values 
(default,
'Можно ли унаследовать от класса B абстрактный класс? 
Если да, то что нужно сделать с методом print(): его обязательно надо переопределить,
его можно не переопределять, можно ли его определить как abstract?',
'abstract class A{ 
    public abstract void print(); 
} 
class B extends A{ 
    public void print(){ 
        System.out.println("B"); 
    } 
} '
,
1);

# Таблица ответ Interview
create table if not exists answerInterview(
`idAnswerInterview` int not null AUTO_INCREMENT,
`answer` blob not null,
`questioninterviewId` int not null,
primary key (idAnswerInterview),
foreign key (questioninterviewId) references questioninterview(idQuestioninterview)
	on delete restrict on update cascade
);
insert into answerInterview values(default,
'От класса B можно унаследовать абстрактный класс(к примеру, класс C),
при этом метод print() можно не переопределять, так как его реализация есть в классе B.',
1);

# Таблица комментарии interview
create table if not exists commentInterview(
`idCommentInterview` int not null AUTO_INCREMENT,
`comment` blob,
`questioninterviewId` int not null,
primary key (idCommentInterview),
foreign key (questioninterviewId) references questioninterview(idQuestioninterview)
	on delete restrict on update cascade
);
insert into commentInterview values(default,'trololo',1);