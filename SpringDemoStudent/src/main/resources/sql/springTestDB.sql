create database if not exists springTestDB
character set utf8;

use springTestDB;

drop table if exists `UserRole`;
drop table if exists `User`;
drop table if exists `Role`;
drop table if exists `Groupp`;

create table if not exists `Role`(
`id` int not null auto_increment,
`role` varchar(40) not null,
 primary key(Id)
);
insert into `Role` values(default,'admin');
insert into `Role` values(default,'user');


create table if not exists `Groupp`(
`id` int not null auto_increment,
`name` varchar(40) not null,
`countStudents` int,
primary key(id)
);
insert into `Groupp` values(default,'Inf-11-1',10);
insert into `Groupp` values(default,'Inf-11-2',13);
insert into `Groupp` values(default,'Inf-11-3',13);


create table if not exists `User`(
`id` int not null auto_increment,
`email` varchar(50) not null unique,
`password` varchar(100) not null,
`name` varchar(50) not null,
`surname` varchar(50) not null,
`groupId` int ,
primary key(Id),
foreign key (groupId) references `Groupp`(Id)
	on delete restrict on update cascade
);
insert into `User` values(default,'admin@gmail.com','admin','Yehor','Zhyzhko',1);
insert into `User` values(default,'user@gmail.com','user','Vasua','Pupkin',2);
insert into `User` values(default,'egor@gmail.com','egor','Lol','Lollovich',2);

create table if not exists `UserRole` (
`userId` int not null,
`roleId` int not null,
primary key(userId, roleId),
foreign key (userId) references `User`(Id)
	on delete cascade on update cascade,
    foreign key (roleId) references `Role`(Id)
	on delete cascade on update cascade
);
insert into `UserRole` values(1,1);
insert into `UserRole` values(2,2);
insert into `UserRole` values(3,2);

select * from User;
select * from UserRole;
select * from Groupp;