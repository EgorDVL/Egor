create database if not exists hospitalDB
character set utf8;

use hospitalDB;


drop table if exists `admin`;
drop table if exists `nurse`;
drop table if exists `attendingDoctor`;
drop table if exists `doctor`;
drop table if exists `department`;
drop table if exists `healing`;
drop table if exists `appointment`;
drop table if exists `operations`;
drop table if exists `medicament`;
drop table if exists `procedures`;
drop table if exists `diagnosis`;
drop table if exists `hospitalCard`;
drop table if exists `patient`;
drop table if exists `user`;
drop table if exists `role`;
drop table if exists `journal`;

create table if not exists `role`(
`roleId` int not null auto_increment,
`roleName` varchar(40) not null,
 primary key(roleId)
);
insert into `role` values(default,'ADMIN');
insert into `role` values(default,'DOCTOR');
insert into `role` values(default,'NURSE');
insert into `role` values(default,'PATIENT');

create table if not exists `user`(
`userId` int not null auto_increment,
`email` varchar(50) not null unique,
`password` varchar(50) not null,
`roleId` int not null,
primary key(userId),
 foreign key (roleId) references `role`(roleId)
	on delete restrict on update cascade
);
insert into `user` values(default,'admin@gmail.com','admin',1);

insert into `user` values(default,'Doctor@mail.ru','doctor',2);
insert into `user` values(default,'Doctor1@mail.ru','doctor1',2);
insert into `user` values(default,'Doctor2@mail.ru','doctor2',2);

insert into `user` values(default,'Nurse@mail.ru','nurse',3);
insert into `user` values(default,'Nurse1@mail.ru','nurse1',3);
insert into `user` values(default,'Nurse2@mail.ru','nurse2',3);

insert into `user` values(default,'Patient@mail.ru','patient',4);
insert into `user` values(default,'Patient1@mail.ru','patient1',4);
insert into `user` values(default,'Patient2@mail.ru','patient2',4);


create table if not exists `admin`(
`adminId` int not null auto_increment,
`name` varchar(40) not null,
`userId` int not null,
primary key(adminId),
foreign key (userId) references `user`(userId)
	on delete restrict on update cascade
);
insert into `admin` values(default,'Vasua',1);


create table if not exists `department`(
`departmentId` int not null auto_increment,
`name` varchar(40) not null,
primary key(departmentId)
);
insert into `department` values(default,'therapy');
insert into `department` values(default,'surgery');
insert into `department` values(default,'traumatology');
insert into `department` values(default,'stomatology');
insert into `department` values(default,'pediatrics');
insert into `department` values(default,'ophthalmology');
insert into `department` values(default,'neurology');
insert into `department` values(default,'cardiology');
insert into `department` values(default,'gynecology');
insert into `department` values(default,'venereology');
insert into `department` values(default,'obstetrics');

create table if not exists `doctor`(
`doctorId` int not null auto_increment,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`specialty` varchar(40) not null,
`dateOfBirth` date not null,
`experience` int not null,
`photo` varchar(100),
`departmentId` int(40) not null,
`userId` int not null,
primary key(doctorId),
foreign key (departmentId) references `department`(departmentId)
	on delete restrict on update cascade,
foreign key (userId) references `user`(userId)
	on delete restrict on update cascade
);
insert into `doctor` values(default,'Yehor', 'Zhyzhko', '380507070342' , 'Terapevt','1994-04-20',4,'image/doctor1.jpg',1,2);
insert into `doctor` values(default,'Dima', 'Trololo', '380502322244' , 'Surgerist','1990-11-25',6,'image/doctor2.jpg',2,3);
insert into `doctor` values(default,'Jon', 'Travolta', '380502353412' , 'Traumatolog','1994-07-03',2,'image/doctor3.jpg',3,4);


create table if not exists `nurse`(
`nurseId` int not null auto_increment,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`specialty` varchar(40) not null,
`dateOfBirth` date not null,
`experience` int not null,
`photo` varchar(100),
`departmentId` int(40) not null,
`userId` int not null,
primary key(nurseId),
foreign key (departmentId) references `department`(departmentId)
	on delete restrict on update cascade,
foreign key (userId) references `user`(userId)
	on delete restrict on update cascade
);
insert into `nurse` values(default,'Luba', 'Petrovna', '380994325577' , 'Nurse','1997-08-22',3,'image/nurse1.jpg',1,5);
insert into `nurse` values(default,'Lola', 'Vlodimirovna', '380501111111' , 'Nurse','1992-12-26',5,'image/nurse2.jpg',2,6);
insert into `nurse` values(default,'Sveta', 'Lihach', '380502222222' , 'Nurse','1994-07-08',4,'image/nurse3.jpg',3,7);

create table if not exists `patient`(
`patientId` int not null auto_increment,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`dateOfBirth` date not null,
`address` varchar(40) not null,
`photo` varchar(100),
`status` varchar(30) not null,
`userId` int not null,
primary key(patientId),
foreign key (userId) references `user`(userId)
	on delete restrict on update cascade
);
insert into `patient` values(default,'Vasua','Pupkin','380501231223','1997-06-23','st Naukova h.12 f.104','image/patient2.jpg','treated',8);
insert into `patient` values(default,'Vladimir','Loloshev','380504444444','1991-12-24','st Lenina h.122 f.304','image/patient5.jpg','treated',9);
insert into `patient` values(default,'Lida','Lukashenko','380509872365','1984-02-04','st Asharova h.14 f.74','image/patient3.jpg','discharge',10);

create table if not exists `attendingDoctor`(
`attendingDoctorId` int not null auto_increment,
`doctorId` int not null,
`patientId` int not null,
primary key(attendingDoctorId),
foreign key (doctorId) references `doctor`(doctorId)
	on delete restrict on update cascade,
foreign key (patientId) references `patient`(patientId)
	on delete restrict on update cascade
);
insert into `attendingDoctor` values(default,1,1);
insert into `attendingDoctor` values(default,2,2);
insert into `attendingDoctor` values(default,3,3);


create table if not exists `operations`(
`operationsId` int not null auto_increment,
`name` varchar(100) not null,
`date` date not null,
`complexity` varchar(40) not null,
`status` varchar(30) not null,
primary key(operationsId)
);
insert into `operations` values(default,'appendicitis delete' , '2017-02-03', 'eazy','NOT_DONE');
insert into `operations` values(default,'transplant bud','2017-02-01', 'hard','DONE');
insert into `operations` values(default,'glands delete','2017-01-21', 'normal','DONE');


create table if not exists `medicament`(
`medicamentId` int not null auto_increment,
`name` varchar(50) not null,
`type` varchar(40) not null,
`use` varchar(40) not null,
`date_start` date not null,
`date_end` date not null,
`status` varchar(30) not null,
primary key(medicamentId)
);
insert into `medicament` values(default,'combi gryp','pills', '3 times' , '2017-01-19' , '2017-01-23','DONE');
insert into `medicament` values(default,'vitamin E','injection', '1 times','2017-01-20' , '2017-01-26','DONE');
insert into `medicament` values(default,'trololo','powder', '5 times' , '2017-02-02' , '2017-02-12','NOT_DONE');

create table if not exists `procedures`(
`proceduresId` int not null auto_increment,
`name` varchar(40) not null,
`use` varchar(40) not null,
`date_start` date not null,
`date_end` date not null,
`status` varchar(30) not null,
primary key(proceduresId)
);
insert into `procedures` values(default,'masage','1 times','2017-01-20' , '2017-01-24','DONE');
insert into `procedures` values(default,'salt bath','2 times','2017-02-01' , '2017-02-10','NOT_DONE');
insert into `procedures` values(default,'heating glands','3 times','2017-01-21' , '2017-02-02','DONE');

create table if not exists `appointment`(
`appointmentId` int not null auto_increment,
`name` varchar(40) not null,
`date` date not null,
`operationsId` int,
`medicamentId` int,
`proceduresId` int,
primary key(appointmentId),
foreign key (operationsId) references `operations`(operationsId)
	on delete restrict on update cascade,
foreign key (medicamentId) references `medicament`(medicamentId)
	on delete restrict on update cascade,
foreign key (proceduresId) references `procedures`(proceduresId)
	on delete restrict on update cascade
);
insert into `appointment` values(default,'appointment first','2017-01-10',1,1,1);
insert into `appointment` values(default,'appointment second','2017-01-12',2, null ,2);
insert into `appointment` values(default,'appointment third','2017-01-12',3, 3 ,null);


create table if not exists `diagnosis`(
`diagnosisId` int not null auto_increment,
`name` varchar(100) not null,
primary key(diagnosisId)
);
insert into `diagnosis` values(default,'bronhit');
insert into `diagnosis` values(default,'tanzilit');
insert into `diagnosis` values(default,'ciroz');


create table if not exists `hospitalCard` (
`hospitalCardId` int not null auto_increment,
`patientId` int not null,
primary key(hospitalCardId),
foreign key (patientId) references `patient`(patientId)
	on delete restrict on update cascade
);
insert into `hospitalCard` values(default,1);
insert into `hospitalCard` values(default,2);
insert into `hospitalCard` values(default,3);


create table if not exists`healing`(
`healingId` int not null auto_increment,
`symptoms` blob not null,
`date_healing_start` date not null,
`date_healing_end`date not null,
`appointmentId` int not null,
`diagnosisId` int not null,
`hospitalCardId` int not null,
primary key(healingId),
foreign key (appointmentId) references `appointment`(appointmentId)
	on delete restrict on update cascade,
foreign key (diagnosisId) references `diagnosis`(diagnosisId)
	on delete restrict on update cascade,
foreign key (hospitalCardId) references `hospitalCard`(hospitalCardId)
	on delete restrict on update cascade
);
insert into `healing` values(default,'sharp pain in the back','2017-01-20', '2017-02-10', 1, 1,1);
insert into `healing` values(default,'snuffle','2017-01-20', '2017-02-10', 1, 1,1);
insert into `healing` values(default,'shoots in the ear','2017-01-22', '2017-02-12', 2, 2,2);
insert into `healing` values(default,'broken leg','2017-01-25', '2017-02-15', 3, 3,3);


create table if not exists `journal`(
`journalId` int not null auto_increment,
`date` date not null,
`patientId` int not null,
`message` varchar(500) not null,
primary key(journalId)
);
insert into `journal` values(default,'2017-01-24',1,'Vasua pupkin create new healing');
insert into `journal` values(default,'2017-01-24',2,'Trololo lolo lolo');

select * from role;
select * from user;
select * from admin;
select * from appointment;
select * from attendingdoctor;
select * from department;
select * from diagnosis;
select * from doctor;
select * from healing;
select * from hospitalcard;
select * from medicament;
select * from nurse;
select * from operations;
select * from patient;
select * from procedures;
select * from journal;
