create database if not exists dataCollectionServiceDB
character set utf8;

use dataCollectionServiceDB;

drop table if exists FieldResponse;
drop table if exists Field;
drop table if exists Required;
drop table if exists Response;
drop table if exists Status;
drop table if exists TypeValue;
drop table if exists Ttype;


create table if not exists `Status`(
`id` int not null auto_increment primary key,
`value` boolean not null
);
insert into Status values(default,true);
insert into Status values(default,false);

create table if not exists `Required`(
`id` int not null auto_increment primary key,
`value` boolean not null
);
insert into `Required` values(default,true);
insert into `Required` values(default,false);

create table if not exists `Ttype`(
`id` int not null auto_increment primary key,
`typeName` varchar(50)
);
insert into `Ttype` values(default,'COMBO_BOX');
insert into `Ttype` values(default,'COMBO_BOX');
insert into `Ttype` values(default,'SIMPLE_LINE');

create table if not exists `TypeValue`(
`id`int not null auto_increment primary key,
`value` varchar(100),
`typeId` int,
foreign key (typeId) references `Ttype`(id)
	on delete cascade on update cascade
);
insert into `TypeValue` values(default,'Option 1',1);
insert into `TypeValue` values(default,'Option 2',1);
insert into `TypeValue` values(default,'Option 1',2);
insert into `TypeValue` values(default,'',3);

create table if not exists `Field`(
`id` int not null auto_increment primary key,
`lable` varchar(50) not null,
`typeId` int not null,
`requiredId` int not null,
`statusId` int not null,
foreign key (typeId) references `Ttype`(id)
	on delete cascade on update cascade,
	foreign key (requiredId) references `Required`(id)
	on delete cascade on update cascade,
	foreign key (statusId) references `Status`(id)
	on delete cascade on update cascade
);
insert into `Field` values(default,'Full name',3,1,1);
insert into `Field` values(default,'Email',3,1,1);
insert into `Field` values(default,'Combobox',1,1,2);

create table if not exists `Response`(
`id` int not null auto_increment primary key
);
insert into `Response` values(default);
insert into `Response` values(default);
insert into `Response` values(default);

create table if not exists `FieldResponse`(
`id` int not null auto_increment primary key,
`responseId` int not null,
`fieldId` int not null,
value varchar(100),
	foreign key (fieldId) references `Field`(id)
	on delete cascade on update cascade,
	foreign key (responseId) references `Response`(id)
	on delete cascade on update cascade
);
insert into `FieldResponse` values(default,1,1,'Vasua');
insert into `FieldResponse` values(default,1,2,'Vasua@mail.ru');
insert into `FieldResponse` values(default,1,3,'Option 1');

select * from `Status`;
select * from `Required`;
select * from `TypeValue`;
select * from `Ttype`;
select * from `FieldResponse`;
select * from `Field`;
select * from `Response`;