drop table if exists cooperator;
drop table if exists department;

create table cooperator(
cooperator_id integer not null auto_increment primary key,
cooperator_name varchar(20) not null,
cooperator_surname varchar(20) not null,
cooperator_email varchar(45) not null unique,
cooperator_registration_data date,
id_dep integer references department(department_id)
on delete cascade
on update restrict
);

create table department(
department_id integer not null auto_increment primary key,
department_name varchar(30) not null unique
);

insert into department values(default, "Computer Security");
insert into department values(default, "Computer Science");

insert into cooperator values(default, "Andrew", "Costa", "a.costa@gmail.com", "2017-07-01", 1);
insert into cooperator values(default, "Nick", "Fury", "n.fury@gmail.com", "2017-07-02", 2);
insert into cooperator values(default, "Diego", "Costa", "d.costa@gmail.com", "2017-07-03", 1);
