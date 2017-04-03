create database if not exists phoneShopDB
character set utf8;

use phoneShopDB;

drop table if exists `orderedProduct`;
drop table if exists `order`;
drop table if exists `product`;
drop table if exists `category`;
drop table if exists `subcategoryAccessories`;
drop table if exists `manufacturer`;
drop table if exists `characteristic`;
drop table if exists `description`;
drop table if exists `user`;
drop table if exists `role`;


create table if not exists `role`(
`roleId` int not null auto_increment,
`roleName` varchar(40) not null,
 primary key(roleId)
);
insert into `role` values(default,'Admin');
insert into `role` values(default,'User');
insert into `role` values(default,'Guest');

create table if not exists `user` (
`userId` int not null auto_increment,
`email` varchar(40) not null unique,
`password` varchar(40) not null,
`name` varchar(40) not null,
`surname` varchar(40) not null,
`phone` varchar(40) not null,
`roleId` int not null,
 primary key(userId),
 foreign key (roleId) references `role`(roleId)
	on delete restrict on update cascade
);
insert into `user` values(default,'admin@gmail.com','admin' , 'EgorAdmin' , 'ZhyzhkoAdm' , '+380507070342' ,1);
insert into `user` values(default,'user@gmail.com','user' , 'EgorUser' , 'ZhyzhkoUser', '+380502321644',2);


create table if not exists `subcategoryAccessories`(
`subcatId` int not null auto_increment,
`nameSubCategoryAccessory` varchar (40) not null,
primary key (subcatId)
);
insert into `subcategoryAccessories` values(default,'covers');
insert into `subcategoryAccessories` values(default,'PROTECTIVE_SCREEN');
insert into `subcategoryAccessories` values(default,'PROTECTIVE_GLASSES');
insert into `subcategoryAccessories` values(default,'HEADSET');
insert into `subcategoryAccessories` values(default,'CHARGING_DEVICE');
insert into `subcategoryAccessories` values(default,'MONOPODS_FOR_SELFIE');
insert into `subcategoryAccessories` values(default,'BATTARIES');



create table if not exists `category`(
`categoryId` int not null auto_increment,
`nameCategory` varchar(40) not null,
`subcatId` int,
primary key(categoryId),
foreign key (subcatId) references `subcategoryAccessories`(subcatId)
	on delete restrict on update cascade
);
insert into `category` values(default,'PHONES', null);
insert into `category` values(default,'TABLETS', null);
insert into `category` values(default,'ACCESSORIES',1);
insert into `category` values(default,'ACCESSORIES',2);


create table if not exists `manufacturer`(
`manufacturerId` int not null auto_increment,
`nameManufacturer` varchar(40) not null,
primary key(manufacturerId) 
);
insert into `manufacturer` values(default,'apple');
insert into `manufacturer` values(default,'samsung');


create table if not exists `characteristic`(
`characteristicId` int not null auto_increment,
`color` varchar(20) not null,
`memory` int not null,
`screenSize` double not null,
`processor` varchar(40) not null,
`ram` double not null,
`frontCamera` double not null,
`mainCamera` double not null,
primary key(characteristicId)
);
insert into `characteristic` values(default,'black',16, 4.25 , 'apple A6' , 2.0 , 2.5 , 12.0);
insert into `characteristic` values(default,'red', 8, 5.25, 'intel 4', 2.5, 5.7, 13.0);


create table if not exists `description`(
`descriptionId` int not null auto_increment,
`description` varchar(300) not null,
primary key(descriptionId)
);
insert into `description` values(default,'most controversial phone Apple in the mobile phone market. Some praise, others criticize Apple for iPhone attempt to create a budget phone. iPhone 5c is available in a plastic case with a storage capacity of 16 GB.');
insert into `description` values(default,'most controversial phone Apple in the mobile phone market. Some praise, others criticize Apple for iPhone attempt to create a budget phone. iPhone 5c is available in a plastic case with a storage capacity of 8 GB.');
insert into `description` values(default,'the best score for iphone 5s');

create table if not exists `product`(
`productId` int not null auto_increment,
`name` varchar(40) not null,
`price` int not null,
`count` int not null,
`descriptionId` int,
`characteristicId` int,
`manufacturerId` int,
`categoryId`int,
primary key(productId),
foreign key (descriptionId) references `description`(descriptionId)
	on delete restrict on update cascade,
foreign key (characteristicId) references `characteristic`(characteristicId)
	on delete restrict on update cascade,
foreign key (manufacturerId) references `manufacturer`(manufacturerId)
	on delete restrict on update cascade,
foreign key (categoryId) references `category`(categoryId)
	on delete restrict on update cascade
);
insert into `product` values(default,'iphone 5s', 500,20, 1, 1, 1, 1);
insert into `product` values(default,'l 542' , 400,10, 2, 2, 2, 1);
insert into `product` values(default,'ipod mini', 1400,1, 1, 1, 1, 2);
insert into `product` values(default,'iphone 5s score', 10,50, 3, null, 1, 3);
insert into `product` values(default,'ipod mini_1', 1400,0, 1, 1, 1, 2);
insert into `product` values(default,'iphone 6s PROTECTIVE_SCREEN', 12,60, 3, null, 1, 4);
insert into `product` values(default,'iphone 4 PROTECTIVE_SCREEN', 2,20, 3, null, 1, 4);




create table if not exists `order`(
`orderId` int not null auto_increment,
`city` varchar (40) not null,
`addres` varchar (50) not null,
`paymentMethod` varchar(40) not null,
`deliveryMethod` varchar(40) not null,
`comments` varchar(150),
`userId` int not null,
primary key (orderId),
 foreign key (userId) references `user`(userId)
	on delete restrict on update cascade
);
insert into `order` values(default,'Kharkiv','Lenina str 56' , 'cash_payment', 'pickup', 'good phone', 2);
insert into `order` values(default,'Kiev','Naukova prospect 12' , 'transfer_to_account', 'pickup', 'not good phone', 2);


create table if not exists `orderedProduct`(
`orderedProductId` int not null auto_increment,
`orderId` int not null,
`productId` int not null,
primary key(orderedProductId),
foreign key (orderId) references `order`(orderId)
	on delete restrict on update cascade,
foreign key (productId) references `product`(productId)
	on delete restrict on update cascade
);
insert into `orderedProduct` values(default,1,1);
insert into `orderedProduct` values(default,2,2);


select * from orderedProduct;
select * from `order`;
select * from product;
select * from category;
select * from subcategoryAccessories;
select * from manufacturer;
select * from characteristic;
select * from description;
select * from user;
select * from role;
