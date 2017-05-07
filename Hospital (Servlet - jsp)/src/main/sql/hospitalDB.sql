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
drop table if exists `operation`;
drop table if exists `medicament`;
drop table if exists `procedures`;
drop table if exists `diagnosis`;
drop table if exists `hospitalCard`;
drop table if exists `patient`;


create table if not exists `admin`(
`adminId` int not null auto_increment,
`login` varchar(30) not null,
`password` varchar(30) not null,
`role` varchar(40) not null,
primary key(adminId)
);
insert into `admin` values(default,'admin','admin','Admin');


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
`email` varchar(40) not null,
`password` varchar(40) not null,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`specialty` varchar(40) not null,
`dateOfBirth` date not null,
`experience` int not null,
`role` varchar(40) not null,
`departmentId` int(40) not null,
primary key(doctorId),
foreign key (departmentId) references `department`(departmentId)
	on delete restrict on update cascade
);
insert into `doctor` values(default,'EgorDVL@mail.ru','admin', 'Yehor', 'Zhyzhko', '+380507070342' , 'Terapevt','1994-04-20',4,'doctor',1);
insert into `doctor` values(default,'Lolol@mail.ru','admin1', 'Dima', 'Trololo', '+380502322244' , 'Surgerist','1990-11-25',6,'doctor',2);
insert into `doctor` values(default,'ERerER@mail.ru','admin2', 'Jon', 'Travolta', '+380502353412' , 'Traumatolog','1994-07-03',2,'doctor',3);


create table if not exists `nurse`(
`nurseId` int not null auto_increment,
`email` varchar(40) not null,
`password` varchar(40) not null,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`specialty` varchar(40) not null,
`dateOfBirth` date not null,
`experience` int not null,
`role` varchar(40) not null,
`departmentId` int(40) not null,
primary key(nurseId),
foreign key (departmentId) references `department`(departmentId)
	on delete restrict on update cascade
);
insert into `nurse` values(default,'Luba@mail.ru','nurse1', 'Luba', 'Petrovna', '+380994325577' , 'Nurse','1997-08-22',3,'nurse',1);
insert into `nurse` values(default,'Lola@mail.ru','nurse2', 'Lola', 'Vlodimirovna', '+380501111111' , 'Nurse','1992-12-26',5,'nurse',2);
insert into `nurse` values(default,'Sveta@mail.ru','nurse3', 'Sveta', 'Lihach', '+380502222222' , 'Nurse','1994-07-08',4,'nurse',3);

create table if not exists `patient`(
`patientId` int not null auto_increment,
`email` varchar(40),
`login` varchar(40) not null,
`password` varchar(40) not null,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`dateOfBirth` date not null,
`address` varchar(40) not null,
`role` varchar(40) not null,
primary key(patientId)
);
insert into `patient` values(default,'ZhyzhkoEgor@gmail.com','ZhyzhkoEgor','12345', 'Vasua','Pupkin','+380501231223','1997-06-23','st Naukova h.12 f.104','patient');
insert into `patient` values(default,'','Patient1','11111','Vladimir','Loloshev','+380504444444','1991-12-24','st Lenina h.122 f.304','patient');
insert into `patient` values(default,'Patient2@gmail.com','Patient2','22222','Lida','Lukashenko','+380509872365','1984-02-04','st Asharova h.14 f.74','patient');

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


create table if not exists `operation`(
`operationId` int not null auto_increment,
`name` varchar(100) not null,
`date` date not null,
`complexity` varchar(40) not null,
primary key(operationId)
);
insert into `operation` values(default,'appendicitis delete' , '2017-01-25', 'eazy');
insert into `operation` values(default,'transplant bud','2017-02-10', 'hard');
insert into `operation` values(default,'glands delete','2017-01-15', 'normal');


create table if not exists `medicament`(
`medicamentId` int not null auto_increment,
`name` varchar(50) not null,
`type` varchar(40) not null,
`use` varchar(40) not null,
`date_start` date not null,
`date_end` date not null,
primary key(medicamentId)
);
insert into `medicament` values(default,'combi gryp','pills', '3 times' , '2017-01-10' , '2017-01-15');
insert into `medicament` values(default,'vitamin E','injection', '1 times','2017-01-14' , '2017-01-23');
insert into `medicament` values(default,'trololo','powder', '5 times' , '2017-01-12' , '2017-01-15');

create table if not exists `procedures`(
`proceduresId` int not null auto_increment,
`name` varchar(40) not null,
`use` varchar(40) not null,
`date_start` date not null,
`date_end` date not null,
primary key(proceduresId)
);
insert into `procedures` values(default,'masage','1 times','2017-01-10' , '2017-01-15');
insert into `procedures` values(default,'salt bath','2 times','2017-01-06' , '2017-01-10');
insert into `procedures` values(default,'heating glands','3 times','2017-01-22' , '2017-02-02');

create table if not exists `appointment`(
`appointmentId` int not null auto_increment,
`name` varchar(40) not null,
`date` date not null,
`operationId` int,
`medicamentId` int,
`proceduresId` int,
primary key(appointmentId),
foreign key (operationId) references `operation`(operationId)
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
insert into `healing` values(default,'2017-01-20', '2017-02-10', 1, 1,1);
insert into `healing` values(default,'2017-01-22', '2017-02-12', 2, 2,2);
insert into `healing` values(default,'2017-01-25', '2017-02-15', 3, 3,3);

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
select * from operation;
select * from patient;
select * from procedures;