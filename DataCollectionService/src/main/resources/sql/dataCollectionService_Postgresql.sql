drop table if exists FieldResponse;
drop table if exists Field;
drop table if exists Status;
drop table if exists Required;
drop table if exists Ttype;
drop table if exists Response;
drop table if exists TypeValue;



create table if not exists Status(
id SERIAL primary key,
value varchar(50) not null
);
insert into Status values(default,'GOOD');
insert into Status values(default,'BAD');

create table if not exists Required(
id SERIAL primary key,
value varchar(50) not null
);
insert into Required values(default,'GOOD');
insert into Required values(default,'BAD');

create table if not exists TypeValue(
id SERIAL primary key,
value varchar(100)
);
insert into TypeValue values(default,'Option 1');
insert into TypeValue values(default,'Option 2');
insert into TypeValue values(default,'');

create table if not exists Ttype(
id SERIAL primary key,
typeName varchar(50),
typeValueId int,
foreign key (typeValueId) references TypeValue(id)
	on delete cascade on update cascade
);
insert into Ttype values(default,'COMBO_BOX',1);
insert into Ttype values(default,'COMBO_BOX',2);
insert into Ttype values(default,'SIMPLE_LINE',3);

create table if not exists Field(
id SERIAL primary key,
lable varchar(50) not null,
typeId int not null,
requiredId int not null,
statusId int not null,
foreign key (typeId) references Ttype(id)
	on delete cascade on update cascade,
	foreign key (requiredId) references Required(id)
	on delete cascade on update cascade,
	foreign key (statusId) references Status(id)
	on delete cascade on update cascade
);
insert into Field values(default,'Full name',3,1,1);
insert into Field values(default,'Email',3,1,1);
insert into Field values(default,'Combobox',1,1,2);

create table if not exists Response(
id SERIAL primary key
);
insert into Response values(default);
insert into Response values(default);
insert into Response values(default);

create table if not exists FieldResponse(
id SERIAL primary key,
responseId int not null,
fieldId int not null,
value varchar(100),
	foreign key (fieldId) references Field(id)
	on delete cascade on update cascade,
	foreign key (responseId) references Response(id)
	on delete cascade on update cascade
);
insert into FieldResponse values(default,1,1,'Vasua');
insert into FieldResponse values(default,1,2,'Vasua@mail.ru');
insert into FieldResponse values(default,1,3,'Option 1');

select * from Status;
select * from Required;
select * from TypeValue;
select * from Ttype;
select * from FieldResponse;
select * from Field;
select * from Response;