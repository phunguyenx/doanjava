drop database if exists `testH`;
CREATE DATABASE  IF NOT EXISTS `testH`;
USE `testH`;

-- bảng tài khoản sử dụng
drop table if exists `user`;
create table `user`(
	`username` varchar(45) primary key,
	`password` varchar(45) NOT NULL,
	`role` int NOT NULL
    
);
-- bảng nhân viên
drop table if exists `employee`;
create table `employee`(
	`id_emp` varchar(10) NOT NULL ,
	`name_emp` varchar(45) NOT NULL,
	`idcard_emp` varchar(45) NOT NULL unique,
	`gender_emp` int NOT NULL,
	`birthDate_emp` date NOT NULL,
	`address_emp` varchar(45)  NOT NULL,
	`phone_emp` varchar(45) NOT NULL,
	`email_emp` varchar(45) NOT NULL,
	`eduLevel_emp` varchar(45) NOT NULL,
	`username` varchar(45) not null unique,
    foreign key (`username`) references `user`(`username`),
    PRIMARY KEY (`id_emp`)
);
-- bảng khách hàng
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `id_guest` varchar(10) NOT NULL,
  `name_guest` varchar(45) NOT NULL,
  `gender_guest` int NOT NULL,
  `idcard_guest` varchar(45) NOT NULL,
  `phone_guest` varchar(45) NOT NULL,
  `birthDate_guest` date NOT NULL,
  `username` varchar(45) ,
  foreign key (`username`) references `user`(`username`),
  PRIMARY KEY (`id_guest`)
);



-- bảng loại phòng
drop table if exists `typeRoom`;
create table `typeRoom`(
	`id_tRoom` varchar(10) primary key,
    `name_tRoom` varchar(45) not null,
    `price_tRoom` int not null
);
-- bảng phòng
drop table if exists `room`;
create table `room`(
	`roomNumber` varchar(10) primary key,
    `id_tRoom` varchar(10) ,
    foreign key (`id_tRoom`) references `typeRoom`(`id_tRoom`) 
);
-- bảng cơ sở vật chất
drop table if exists `furniture`;
create table `furniture`(
	`id_fur` varchar(10) primary key,
    `name_fur` varchar(45) not null,
    `price_fur` varchar(45) not null,
    `status_fur` int not null,
    `roomNumber` varchar(10) not null,
    foreign key (`roomNumber`) references `room`(`roomNumber`)
);

-- bảng loại dịch vụ
drop table if exists `typeService`;
create table `typeService`(
	`id_tSer` varchar(10) primary key,
    `name_tSer` varchar(45) not null
);
-- bảng dịch vụ
drop table if exists `service`;
create table `service`(
	`id_ser` varchar(10) primary key,
    `id_tSer` varchar(10) ,
    `name_ser` varchar(45) not null,
    `price_ser` int not null,
    foreign key (`id_tSer`) references `typeService`(`id_tSer`)
);
drop table if exists `room_reservation`;
CREATE TABLE `room_reservation` (
  `idroom_reservation` INT NOT NULL AUTO_INCREMENT,
  `status` INT NOT NULL,
  `startTime` DATE NOT NULL,
  `endTime` DATE NOT NULL,
  `roomNumber` varchar(10) not null,
  `id_guest` varchar(10),
  foreign key (`id_guest`) references `guest`(`id_guest`),
  foreign key (`roomNumber`) references `room`(`roomNumber`),
  PRIMARY KEY (`idroom_reservation`));
-- baang dat phong onl qua ung dung ( thonng bao ) 
drop table if exists `onlineReservation`;
create table `onlineReservation`(
	`idor` INT NOT NULL AUTO_INCREMENT,
    `time` datetime not null,
    `status` bit default 0 not null, -- da xem hoac chua xem
    `bookingStatus` bit, -- chap nhan hoac khong chap nhan 
    `idroom_reservation` int unique,
    foreign key (`idroom_reservation`) references `room_reservation`(`idroom_reservation`)
);
-- bang dat dich vu qua ung dung
drop table if exists `orderService`;
create table `orderService`(
	`idos` INT NOT NULL AUTO_INCREMENT,
    `time` datetime not null,
    `status` bit default 0 not null, -- da xem hoac chua xem
    `orderStatus` bit, -- chap nhan hoac khong chap nhan 
    `id_ser` varchar(10) not null,
    `quantityService` int not null,
    foreign key (`id_ser`) references `service`(`id_ser`)
);
-- bảng hóa đơn
drop table if exists `bill`;
create table `bill`(
	`id_bill` varchar(10) primary key,
    `id_emp` varchar(10),
    `time_checkin` datetime not null,
    `time_checkout` datetime,
    `idroom_reservation` int not null unique,
    foreign key (`idroom_reservation`) references `room_reservation`(`idroom_reservation`)
);
-- bảng hóa đơn dịch vụ
drop table if exists `bill_service`;
create table `bill_service`(
	`id_bill` varchar(10) not null,
    `id_ser` varchar(10) not null,
    `quantity` int not null,
    foreign key (`id_bill`) references `bill`(`id_bill`),
    foreign key (`id_ser`) references `service`(`id_ser`),
    primary key(`id_bill`,`id_ser`)
); 

-- bảng hóa đơn cơ sở vật chất
drop table if exists `bill_furniture`;
create table `bill_furniture`(
	`id_bill` varchar(10) not null,
    `id_fur` varchar(10) not null,
    foreign key (`id_bill`) references `bill`(`id_bill`),
    foreign key (`id_fur`) references `furniture`(`id_fur`),
    primary key(`id_bill`,`id_fur`)
);


  
  
INSERT INTO `testh`.`typeroom` (`id_tRoom`, `name_tRoom`, `price_tRoom`) VALUES ('TR001', 'Đơn', '500000');
INSERT INTO `testh`.`typeroom` (`id_tRoom`, `name_tRoom`, `price_tRoom`) VALUES ('TR002', 'Đôi', '800000');
INSERT INTO `testh`.`typeroom` (`id_tRoom`, `name_tRoom`, `price_tRoom`) VALUES ('TR003', 'Vip', '1500000');


INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('101H1', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('102H1', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('103H1', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('104H1', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('105H1', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('106H1', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('107H1', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('108H1', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('109H1', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('110H1', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('111H1', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('112H1', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('113H1', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('114H1', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('101H2', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('102H2', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('103H2', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('104H2', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('105H2', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('106H2', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('107H2', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('108H2', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('109H2', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('110H2', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('111H2', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('112H2', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('113H2', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('114H2', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('101H3', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('102H3', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('103H3', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('104H3', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('105H3', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('106H3', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('107H3', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('108H3', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('109H3', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('110H3', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('111H3', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('112H3', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('113H3', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('114H3', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('101H4', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('102H4', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('103H4', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('104H4', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('105H4', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('106H4', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('107H4', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('108H4', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('109H4', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('110H4', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('111H4', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('112H4', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('113H4', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('114H4', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('101H5', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('102H5', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('103H5', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('104H5', 'TR001');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('105H5', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('106H5', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('107H5', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('108H5', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('109H5', 'TR002');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('110H5', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('111H5', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('112H5', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('113H5', 'TR003');
INSERT INTO `testh`.`room` (`roomNumber`, `id_tRoom`) VALUES ('114H5', 'TR003');


INSERT INTO `testh`.`typeservice` (`id_tSer`, `name_tSer`) VALUES ('TS001', 'Đồ ăn');
INSERT INTO `testh`.`typeservice` (`id_tSer`, `name_tSer`) VALUES ('TS002', 'Nước uống');
INSERT INTO `testh`.`typeservice` (`id_tSer`, `name_tSer`) VALUES ('TS003', 'Giặt là');
INSERT INTO `testh`.`typeservice` (`id_tSer`, `name_tSer`) VALUES ('TS004', 'Spa');
INSERT INTO `testh`.`typeservice` (`id_tSer`, `name_tSer`) VALUES ('TS005', 'Thể thao');


INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV001', 'TS001', 'Snack khoai tây', '30000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV002', 'TS001', 'Bánh Kitkat', '50000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV003', 'TS001', 'Kẹo M&M Peanuts', '50000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV004', 'TS002', 'Coca', '40000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV005', 'TS002', 'Pepsi', '40000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV006', 'TS002', 'Rượu Vodka', '500000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV007', 'TS002', 'Bia Heineken', '40000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV008', 'TS003', '5KG', '50000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV009', 'TS003', '10KG', '90000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV010', 'TS003', '15KG', '130000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV011', 'TS004', 'Massage', '300000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV012', 'TS004', 'Xông hơi', '300000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV013', 'TS004', 'Tắm bùn', '300000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV014', 'TS005', 'Tennis', '300000');
INSERT INTO `testh`.`service` (`id_ser`, `id_tSer`, `name_ser`, `price_ser`) VALUES ('SV015', 'TS005', 'Sân golf', '300000');

INSERT INTO `testh`.`user` (`username`, `password`, `role`) 
VALUES 
('phu', '123', '2'),
('viet', '123', '2'),
('nam', '123', '2'),
('truong', '123', '2'),
('an', '123', '2'),
('tai', '123', '2'),
('qanh', '123', '2'),
('nanh', '123', '2'),
('cuong', '123', '2'),
('dat', '123', '2'),
('du', '123', '2'),
('duc', '123', '2'),
('sy', '123', '2'),
('dan', '123', '2'),
('khoi', '123', '2');
-- khách hàng có tài khoản
INSERT INTO `testh`.`guest` (`id_guest`, `name_guest`, `gender_guest`, `idcard_guest`, `phone_guest`, `birthDate_guest`, `username`) 
VALUES 
('KH00001', 'Nguyễn Đình Phú', '1', '001203045079', '0123760723', '2002-10-02', 'phu'),
('KH00002', 'Trịnh Hoàng Việt', '1', '001203011467', '0124217003', '2001-10-14', 'viet'),
('KH00003', 'Nguyễn Phùng Nam', '1', '001203012345', '0125382888', '2000-10-22', 'nam'),
('KH00004', 'Hoàng Xuân Trường', '1', '001203088774', '0125382847', '2001-10-22', 'truong'),
('KH00005', 'Đỗ Tùng An', '1', '001203067891', '0126686203', '1999-10-02', 'an'),
('KH00006', 'Đào Thảo My', '0', '001203067891', '0127686203', '1997-11-30', 'tai'),
('KH00007', 'Ksor H Leo', '0', '001203067891', '0222686203', '1994-12-28', 'qanh'),
('KH00008', 'Đào Ngọc Anh', '1', '001203067891', '0221686203', '2003-10-28', 'nanh'),
('KH00009', 'Nguyễn Gia Cường', '1', '001203011467', '0223217003', '2001-10-28', 'cuong'),
('KH00010', 'Phạm Thành Đạt', '1', '001203012345', '0224382888', '2002-10-28', 'dat'),
('KH00011', 'Nguyễn Minh Thư', '0', '001203067891', '0225686203', '2000-8-8', 'du'),
('KH00012', 'Nguyễn Mạnh Đức', '1', '001203067891', '0226686203', '2001-1-28', 'duc'),
('KH00013', 'Nguyễn Thạc Sỹ', '1', '001203067891', '0345686203', '2001-4-28', 'sy'),
('KH00014', 'Nguyễn Kim Đan', '0', '012303067891', '0334568620', '2001-4-28', 'dan'),
('KH00015', 'Chầu Ngọc Linh', '0', '001203067891', '0456686203', '1996-6-28', 'khoi');

-- khách hàng không đăng kí tài khoản
INSERT INTO `testh`.`guest` (`id_guest`, `name_guest`, `gender_guest`, `idcard_guest`, `phone_guest`, `birthDate_guest`) VALUES 
('KH00016', 'Nguyễn Văn Nam', '1', '02132312323', '0326512351', '2003-4-1'),
('KH00017', 'Nguyễn Li Sa', '0', '021378232131', '021212351', '2003-1-1'),
('KH00018', 'Bùi Văn Phong', '1', '047829342011', '0457236161', '2003-12-5'),
('KH00019', 'Hoàng Thị Thu Thủy', '0', '0432687123', '0231576512', '2003-4-6'),
('KH00020', 'Đào Tiến Văn', '1', '0243673223', '03773737733', '2003-4-1'),
('KH00021', 'Nguyễn Văn Nam', '1', '03287648723', '0347637288', '2003-6-22'),
('KH00022', 'Trịnh Thăng Bình', '1', '02357217381', '0398243048', '2003-1-1'),
('KH00023', 'Nguyễn Trấn Thành', '1', '02736872133', '0983271831', '2003-2-22'),
('KH00024', 'Hariwon', '0', '02263672371', '0837429292', '2003-1-5'),
('KH00025', 'Nguyễn Phương lY', '0', '02873912318', '0823832782', '2003-6-1'),
('KH00026', 'Nguyễn Hoàng Long', '1', '07328764811', '0032847326', '2003-12-4');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES ('FU00001', 'Giường đơn', '500000', '1', '101H1'),
('FU00002', 'Giường đơn', '500000', '1', '102H1'),
('FU00003', 'Giường đơn', '500000', '1', '103H1'),
('FU00004', 'Giường đơn', '500000', '1', '104H1'),
('FU00005', 'Giường đơn', '500000', '1', '101H2'),
('FU00006', 'Giường đơn', '500000', '1', '102H2'),
('FU00007', 'Giường đơn', '500000', '1', '103H2'),
('FU00008', 'Giường đơn', '500000', '1', '104H2'),
('FU00009', 'Giường đơn', '500000', '1', '101H3'),
('FU00010', 'Giường đơn', '500000', '1', '102H3'),
('FU00011', 'Giường đơn', '500000', '1', '103H3'),
('FU00012', 'Giường đơn', '500000', '1', '104H3'),
('FU00013', 'Giường đơn', '500000', '1', '101H4'),
('FU00014', 'Giường đơn', '500000', '1', '102H4'),
('FU00015', 'Giường đơn', '500000', '1', '103H4'),
('FU00016', 'Giường đơn', '500000', '1', '104H4'),
('FU00017', 'Giường đơn', '500000', '1', '101H5'),
('FU00018', 'Giường đơn', '500000', '1', '102H5'),
('FU00019', 'Giường đơn', '500000', '1', '103H5'),
('FU00020', 'Giường đơn', '500000', '1', '104H5');

INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00021', 'Bàn làm việc', '250000', '1', '101H1'),
('FU00022', 'Bàn làm việc', '250000', '1', '102H1'),
('FU00023', 'Bàn làm việc', '250000', '1', '103H1'),
('FU00024', 'Bàn làm việc', '250000', '1', '104H1'),
('FU00025', 'Bàn làm việc', '250000', '1', '101H2'),
('FU00026', 'Bàn làm việc', '250000', '1', '102H2'),
('FU00027', 'Bàn làm việc', '250000', '1', '103H2'),
('FU00028', 'Bàn làm việc', '250000', '1', '104H2'),
('FU00029', 'Bàn làm việc', '250000', '1', '101H3'),
('FU00030', 'Bàn làm việc', '250000', '1', '102H3'),
('FU00031', 'Bàn làm việc', '250000', '1', '103H3'),
('FU00032', 'Bàn làm việc', '250000', '1', '104H3'),
('FU00033', 'Bàn làm việc', '250000', '1', '101H4'),
('FU00034', 'Bàn làm việc', '250000', '1', '102H4'),
('FU00035', 'Bàn làm việc', '250000', '1', '103H4'),
('FU00036', 'Bàn làm việc', '250000', '1', '104H4'),
('FU00037', 'Bàn làm việc', '250000', '1', '101H5'),
('FU00038', 'Bàn làm việc', '250000', '1', '102H5'),
('FU00039', 'Bàn làm việc', '250000', '1', '103H5'),
('FU00040', 'Bàn làm việc', '250000', '1', '104H5');

INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00041', 'Ghế', '100000', '1', '101H1'),
('FU00042', 'Ghế', '100000', '1', '102H1'),
('FU00043', 'Ghế', '100000', '1', '103H1'),
('FU00044', 'Ghế', '100000', '1', '104H1'),
('FU00045', 'Ghế', '100000', '1', '101H2'),
('FU00046', 'Ghế', '100000', '1', '102H2'),
('FU00047', 'Ghế', '100000', '1', '103H2'),
('FU00048', 'Ghế', '100000', '1', '104H2'),
('FU00049', 'Ghế', '100000', '1', '101H3'),
('FU00050', 'Ghế', '100000', '1', '102H3'),
('FU00051', 'Ghế', '100000', '1', '103H3'),
('FU00052', 'Ghế', '100000', '1', '104H3'),
('FU00053', 'Ghế', '100000', '1', '101H4'),
('FU00054', 'Ghế', '100000', '1', '102H4'),
('FU00055', 'Ghế', '100000', '1', '103H4'),
('FU00056', 'Ghế', '100000', '1', '104H4'),
('FU00057', 'Ghế', '100000', '1', '101H5'),
('FU00058', 'Ghế', '100000', '1', '102H5'),
('FU00059', 'Ghế', '100000', '1', '103H5'),
('FU00060', 'Ghế', '100000', '1', '104H5');

INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00061', 'Ti vi', '5000000', '1', '101H1'),
('FU00062', 'Ti vi', '5000000', '1', '102H1'),
('FU00063', 'Ti vi', '5000000', '1', '103H1'),
('FU00064', 'Ti vi', '5000000', '1', '104H1'),
('FU00065', 'Ti vi', '5000000', '1', '101H2'),
('FU00066', 'Ti vi', '5000000', '1', '102H2'),
('FU00067', 'Ti vi', '5000000', '1', '103H2'),
('FU00068', 'Ti vi', '5000000', '1', '104H2'),
('FU00069', 'Ti vi', '5000000', '1', '101H3'),
('FU00070', 'Ti vi', '5000000', '1', '102H3'),
('FU00071', 'Ti vi', '5000000', '1', '103H3'),
('FU00072', 'Ti vi', '5000000', '1', '104H3'),
('FU00073', 'Ti vi', '5000000', '1', '101H4'),
('FU00074', 'Ti vi', '5000000', '1', '102H4'),
('FU00075', 'Ti vi', '5000000', '1', '103H4'),
('FU00076', 'Ti vi', '5000000', '1', '104H4'),
('FU00077', 'Ti vi', '5000000', '1', '101H5'),
('FU00078', 'Ti vi', '5000000', '1', '102H5'),
('FU00079', 'Ti vi', '5000000', '1', '103H5'),
('FU00080', 'Ti vi', '5000000', '1', '104H5');

INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00081', 'Tủ quần áo', '2000000', '1', '101H1'),
('FU00082', 'Tủ quần áo', '2000000', '1', '102H1'),
('FU00083', 'Tủ quần áo', '2000000', '1', '103H1'),
('FU00084', 'Tủ quần áo', '2000000', '1', '104H1'),
('FU00085', 'Tủ quần áo', '2000000', '1', '101H2'),
('FU00086', 'Tủ quần áo', '2000000', '1', '102H2'),
('FU00087', 'Tủ quần áo', '2000000', '1', '103H2'),
('FU00088', 'Tủ quần áo', '2000000', '1', '104H2'),
('FU00089', 'Tủ quần áo', '2000000', '1', '101H3'),
('FU00090', 'Tủ quần áo', '2000000', '1', '102H3'),
('FU00091', 'Tủ quần áo', '2000000', '1', '103H3'),
('FU00092', 'Tủ quần áo', '2000000', '1', '104H3'),
('FU00093', 'Tủ quần áo', '2000000', '1', '101H4'),
('FU00094', 'Tủ quần áo', '2000000', '1', '102H4'),
('FU00095', 'Tủ quần áo', '2000000', '1', '103H4'),
('FU00096', 'Tủ quần áo', '2000000', '1', '104H4'),
('FU00097', 'Tủ quần áo', '2000000', '1', '101H5'),
('FU00098', 'Tủ quần áo', '2000000', '1', '102H5'),
('FU00099', 'Tủ quần áo', '2000000', '1', '103H5'),
('FU00100', 'Tủ quần áo', '2000000', '1', '104H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00101', 'Giường đôi', '1000000', '1', '105H1'),
('FU00102', 'Giường đôi', '1000000', '1', '106H1'),
('FU00103', 'Giường đôi', '1000000', '1', '107H1'),
('FU00104', 'Giường đôi', '1000000', '1', '108H1'),
('FU00105', 'Giường đôi', '1000000', '1', '109H2'),
('FU00106', 'Giường đôi', '1000000', '1', '105H2'),
('FU00107', 'Giường đôi', '1000000', '1', '106H2'),
('FU00108', 'Giường đôi', '1000000', '1', '107H2'),
('FU00109', 'Giường đôi', '1000000', '1', '108H3'),
('FU00110', 'Giường đôi', '1000000', '1', '109H3'),
('FU00111', 'Giường đôi', '1000000', '1', '105H3'),
('FU00112', 'Giường đôi', '1000000', '1', '106H3'),
('FU00113', 'Giường đôi', '1000000', '1', '107H4'),
('FU00114', 'Giường đôi', '1000000', '1', '108H4'),
('FU00115', 'Giường đôi', '1000000', '1', '109H4'),
('FU00116', 'Giường đôi', '1000000', '1', '105H4'),
('FU00117', 'Giường đôi', '1000000', '1', '106H5'),
('FU00118', 'Giường đôi', '1000000', '1', '107H5'),
('FU00119', 'Giường đôi', '1000000', '1', '108H5'),
('FU00120', 'Giường đôi', '1000000', '1', '109H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00121', 'Bàn làm việc', '500000', '1', '105H1'),
('FU00122', 'Bàn làm việc', '500000', '1', '106H1'),
('FU00123', 'Bàn làm việc', '500000', '1', '107H1'),
('FU00124', 'Bàn làm việc', '500000', '1', '108H1'),
('FU00125', 'Bàn làm việc', '500000', '1', '109H2'),
('FU00126', 'Bàn làm việc', '500000', '1', '105H2'),
('FU00127', 'Bàn làm việc', '500000', '1', '106H2'),
('FU00128', 'Bàn làm việc', '500000', '1', '107H2'),
('FU00129', 'Bàn làm việc', '500000', '1', '108H3'),
('FU00130', 'Bàn làm việc', '500000', '1', '109H3'),
('FU00131', 'Bàn làm việc', '500000', '1', '105H3'),
('FU00132', 'Bàn làm việc', '500000', '1', '106H3'),
('FU00133', 'Bàn làm việc', '500000', '1', '107H4'),
('FU00134', 'Bàn làm việc', '500000', '1', '108H4'),
('FU00135', 'Bàn làm việc', '500000', '1', '109H4'),
('FU00136', 'Bàn làm việc', '500000', '1', '105H4'),
('FU00137', 'Bàn làm việc', '500000', '1', '106H5'),
('FU00138', 'Bàn làm việc', '500000', '1', '107H5'),
('FU00139', 'Bàn làm việc', '500000', '1', '108H5'),
('FU00140', 'Bàn làm việc', '500000', '1', '109H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00141', 'Ghế', '100000', '1', '105H1'),
('FU00142', 'Ghế', '100000', '1', '106H1'),
('FU00143', 'Ghế', '100000', '1', '107H1'),
('FU00144', 'Ghế', '100000', '1', '108H1'),
('FU00145', 'Ghế', '100000', '1', '109H2'),
('FU00146', 'Ghế', '100000', '1', '105H2'),
('FU00147', 'Ghế', '100000', '1', '106H2'),
('FU00148', 'Ghế', '100000', '1', '107H2'),
('FU00149', 'Ghế', '100000', '1', '108H3'),
('FU00150', 'Ghế', '100000', '1', '109H3'),
('FU00151', 'Ghế', '100000', '1', '105H3'),
('FU00152', 'Ghế', '100000', '1', '106H3'),
('FU00153', 'Ghế', '100000', '1', '107H4'),
('FU00154', 'Ghế', '100000', '1', '108H4'),
('FU00155', 'Ghế', '100000', '1', '109H4'),
('FU00156', 'Ghế', '100000', '1', '105H4'),
('FU00157', 'Ghế', '100000', '1', '106H5'),
('FU00158', 'Ghế', '100000', '1', '107H5'),
('FU00159', 'Ghế', '100000', '1', '108H5'),
('FU00160', 'Ghế', '100000', '1', '109H5');

INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00161', 'Ghế', '100000', '1', '105H1'),
('FU00162', 'Ghế', '100000', '1', '106H1'),
('FU00163', 'Ghế', '100000', '1', '107H1'),
('FU00164', 'Ghế', '100000', '1', '108H1'),
('FU00165', 'Ghế', '100000', '1', '109H2'),
('FU00166', 'Ghế', '100000', '1', '105H2'),
('FU00167', 'Ghế', '100000', '1', '106H2'),
('FU00168', 'Ghế', '100000', '1', '107H2'),
('FU00169', 'Ghế', '100000', '1', '108H3'),
('FU00170', 'Ghế', '100000', '1', '109H3'),
('FU00171', 'Ghế', '100000', '1', '105H3'),
('FU00172', 'Ghế', '100000', '1', '106H3'),
('FU00173', 'Ghế', '100000', '1', '107H4'),
('FU00174', 'Ghế', '100000', '1', '108H4'),
('FU00175', 'Ghế', '100000', '1', '109H4'),
('FU00176', 'Ghế', '100000', '1', '105H4'),
('FU00177', 'Ghế', '100000', '1', '106H5'),
('FU00178', 'Ghế', '100000', '1', '107H5'),
('FU00179', 'Ghế', '100000', '1', '108H5'),
('FU00180', 'Ghế', '100000', '1', '109H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00181', 'Ti vi', '8000000', '1', '105H1'),
('FU00182', 'Ti vi', '8000000', '1', '106H1'),
('FU00183', 'Ti vi', '8000000', '1', '107H1'),
('FU00184', 'Ti vi', '8000000', '1', '108H1'),
('FU00185', 'Ti vi', '8000000', '1', '109H2'),
('FU00186', 'Ti vi', '8000000', '1', '105H2'),
('FU00187', 'Ti vi', '8000000', '1', '106H2'),
('FU00188', 'Ti vi', '8000000', '1', '107H2'),
('FU00189', 'Ti vi', '8000000', '1', '108H3'),
('FU00190', 'Ti vi', '8000000', '1', '109H3'),
('FU00191', 'Ti vi', '8000000', '1', '105H3'),
('FU00192', 'Ti vi', '8000000', '1', '106H3'),
('FU00193', 'Ti vi', '8000000', '1', '107H4'),
('FU00194', 'Ti vi', '8000000', '1', '108H4'),
('FU00195', 'Ti vi', '8000000', '1', '109H4'),
('FU00196', 'Ti vi', '8000000', '1', '105H4'),
('FU00197', 'Ti vi', '8000000', '1', '106H5'),
('FU00198', 'Ti vi', '8000000', '1', '107H5'),
('FU00199', 'Ti vi', '8000000', '1', '108H5'),
('FU00200', 'Ti vi', '8000000', '1', '109H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00201', 'Tủ quần áo', '3000000', '1', '105H1'),
('FU00202', 'Tủ quần áo', '3000000', '1', '106H1'),
('FU00203', 'Tủ quần áo', '3000000', '1', '107H1'),
('FU00204', 'Tủ quần áo', '3000000', '1', '108H1'),
('FU00205', 'Tủ quần áo', '3000000', '1', '109H2'),
('FU00206', 'Tủ quần áo', '3000000', '1', '105H2'),
('FU00207', 'Tủ quần áo', '3000000', '1', '106H2'),
('FU00208', 'Tủ quần áo', '3000000', '1', '107H2'),
('FU00209', 'Tủ quần áo', '3000000', '1', '108H3'),
('FU00210', 'Tủ quần áo', '3000000', '1', '109H3'),
('FU00211', 'Tủ quần áo', '3000000', '1', '105H3'),
('FU00212', 'Tủ quần áo', '3000000', '1', '106H3'),
('FU00213', 'Tủ quần áo', '3000000', '1', '107H4'),
('FU00214', 'Tủ quần áo', '3000000', '1', '108H4'),
('FU00215', 'Tủ quần áo', '3000000', '1', '109H4'),
('FU00216', 'Tủ quần áo', '3000000', '1', '105H4'),
('FU00217', 'Tủ quần áo', '3000000', '1', '106H5'),
('FU00218', 'Tủ quần áo', '3000000', '1', '107H5'),
('FU00219', 'Tủ quần áo', '3000000', '1', '108H5'),
('FU00220', 'Tủ quần áo', '3000000', '1', '109H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00221', 'Tủ quần áo', '6000000', '1', '110H1'),
('FU00222', 'Tủ quần áo', '6000000', '1', '111H1'),
('FU00223', 'Tủ quần áo', '6000000', '1', '112H1'),
('FU00224', 'Tủ quần áo', '6000000', '1', '113H1'),
('FU00225', 'Tủ quần áo', '6000000', '1', '114H1'),
('FU00226', 'Tủ quần áo', '6000000', '1', '110H2'),
('FU00227', 'Tủ quần áo', '6000000', '1', '111H2'),
('FU00228', 'Tủ quần áo', '6000000', '1', '112H2'),
('FU00229', 'Tủ quần áo', '6000000', '1', '113H2'),
('FU00230', 'Tủ quần áo', '6000000', '1', '114H2'),
('FU00231', 'Tủ quần áo', '6000000', '1', '110H3'),
('FU00232', 'Tủ quần áo', '6000000', '1', '111H3'),
('FU00233', 'Tủ quần áo', '6000000', '1', '112H3'),
('FU00234', 'Tủ quần áo', '6000000', '1', '113H3'),
('FU00235', 'Tủ quần áo', '6000000', '1', '114H3'),
('FU00236', 'Tủ quần áo', '6000000', '1', '110H4'),
('FU00237', 'Tủ quần áo', '6000000', '1', '111H4'),
('FU00238', 'Tủ quần áo', '6000000', '1', '112H4'),
('FU00239', 'Tủ quần áo', '6000000', '1', '113H4'),
('FU00240', 'Tủ quần áo', '6000000', '1', '114H4'),
('FU00241', 'Tủ quần áo', '6000000', '1', '110H5'),
('FU00242', 'Tủ quần áo', '6000000', '1', '111H5'),
('FU00243', 'Tủ quần áo', '6000000', '1', '112H5'),
('FU00244', 'Tủ quần áo', '6000000', '1', '113H5'),
('FU00245', 'Tủ quần áo', '6000000', '1', '114H5');



INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00246', 'Giường cỡ lớn', '5000000', '1', '110H1'),
('FU00247', 'Giường cỡ lớn', '5000000', '1', '111H1'),
('FU00248', 'Giường cỡ lớn', '5000000', '1', '112H1'),
('FU00249', 'Giường cỡ lớn', '5000000', '1', '113H1'),
('FU00250', 'Giường cỡ lớn', '5000000', '1', '114H1'),
('FU00251', 'Giường cỡ lớn', '5000000', '1', '110H2'),
('FU00252', 'Giường cỡ lớn', '5000000', '1', '111H2'),
('FU00253', 'Giường cỡ lớn', '5000000', '1', '112H2'),
('FU00254', 'Giường cỡ lớn', '5000000', '1', '113H2'),
('FU00255', 'Giường cỡ lớn', '5000000', '1', '114H2'),
('FU00256', 'Giường cỡ lớn', '5000000', '1', '110H3'),
('FU00257', 'Giường cỡ lớn', '5000000', '1', '111H3'),
('FU00258', 'Giường cỡ lớn', '5000000', '1', '112H3'),
('FU00259', 'Giường cỡ lớn', '5000000', '1', '113H3'),
('FU00260', 'Giường cỡ lớn', '5000000', '1', '114H3'),
('FU00261', 'Giường cỡ lớn', '5000000', '1', '110H4'),
('FU00262', 'Giường cỡ lớn', '5000000', '1', '111H4'),
('FU00263', 'Giường cỡ lớn', '5000000', '1', '112H4'),
('FU00264', 'Giường cỡ lớn', '5000000', '1', '113H4'),
('FU00265', 'Giường cỡ lớn', '5000000', '1', '114H4'),
('FU00266', 'Giường cỡ lớn', '5000000', '1', '110H5'),
('FU00267', 'Giường cỡ lớn', '5000000', '1', '111H5'),
('FU00268', 'Giường cỡ lớn', '5000000', '1', '112H5'),
('FU00269', 'Giường cỡ lớn', '5000000', '1', '113H5'),
('FU00270', 'Giường cỡ lớn', '5000000', '1', '114H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00271', 'Ti vi màn hình cong 4k', '14000000', '1', '110H1'),
('FU00272', 'Ti vi màn hình cong 4k', '14000000', '1', '111H1'),
('FU00273', 'Ti vi màn hình cong 4k', '14000000', '1', '112H1'),
('FU00274', 'Ti vi màn hình cong 4k', '14000000', '1', '113H1'),
('FU00275', 'Ti vi màn hình cong 4k', '14000000', '1', '114H1'),
('FU00276', 'Ti vi màn hình cong 4k', '14000000', '1', '110H2'),
('FU00277', 'Ti vi màn hình cong 4k', '14000000', '1', '111H2'),
('FU00278', 'Ti vi màn hình cong 4k', '14000000', '1', '112H2'),
('FU00279', 'Ti vi màn hình cong 4k', '14000000', '1', '113H2'),
('FU00280', 'Ti vi màn hình cong 4k', '14000000', '1', '114H2'),
('FU00281', 'Ti vi màn hình cong 4k', '14000000', '1', '110H3'),
('FU00282', 'Ti vi màn hình cong 4k', '14000000', '1', '111H3'),
('FU00283', 'Ti vi màn hình cong 4k', '14000000', '1', '112H3'),
('FU00284', 'Ti vi màn hình cong 4k', '14000000', '1', '113H3'),
('FU00285', 'Ti vi màn hình cong 4k', '14000000', '1', '114H3'),
('FU00286', 'Ti vi màn hình cong 4k', '14000000', '1', '110H4'),
('FU00287', 'Ti vi màn hình cong 4k', '14000000', '1', '111H4'),
('FU00288', 'Ti vi màn hình cong 4k', '14000000', '1', '112H4'),
('FU00289', 'Ti vi màn hình cong 4k', '14000000', '1', '113H4'),
('FU00290', 'Ti vi màn hình cong 4k', '14000000', '1', '114H4'),
('FU00291', 'Ti vi màn hình cong 4k', '14000000', '1', '110H5'),
('FU00292', 'Ti vi màn hình cong 4k', '14000000', '1', '111H5'),
('FU00293', 'Ti vi màn hình cong 4k', '14000000', '1', '112H5'),
('FU00294', 'Ti vi màn hình cong 4k', '14000000', '1', '113H5'),
('FU00295', 'Ti vi màn hình cong 4k', '14000000', '1', '114H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00296', 'Bàn làm việc', '2000000', '1', '110H1'),
('FU00297', 'Bàn làm việc', '2000000', '1', '111H1'),
('FU00298', 'Bàn làm việc', '2000000', '1', '112H1'),
('FU00299', 'Bàn làm việc', '2000000', '1', '113H1'),
('FU00300', 'Bàn làm việc', '2000000', '1', '114H1'),
('FU00301', 'Bàn làm việc', '2000000', '1', '110H2'),
('FU00302', 'Bàn làm việc', '2000000', '1', '111H2'),
('FU00303', 'Bàn làm việc', '2000000', '1', '112H2'),
('FU00304', 'Bàn làm việc', '2000000', '1', '113H2'),
('FU00305', 'Bàn làm việc', '2000000', '1', '114H2'),
('FU00306', 'Bàn làm việc', '2000000', '1', '110H3'),
('FU00307', 'Bàn làm việc', '2000000', '1', '111H3'),
('FU00308', 'Bàn làm việc', '2000000', '1', '112H3'),
('FU00309', 'Bàn làm việc', '2000000', '1', '113H3'),
('FU00310', 'Bàn làm việc', '2000000', '1', '114H3'),
('FU00311', 'Bàn làm việc', '2000000', '1', '110H4'),
('FU00312', 'Bàn làm việc', '2000000', '1', '111H4'),
('FU00313', 'Bàn làm việc', '2000000', '1', '112H4'),
('FU00314', 'Bàn làm việc', '2000000', '1', '113H4'),
('FU00315', 'Bàn làm việc', '2000000', '1', '114H4'),
('FU00316', 'Bàn làm việc', '2000000', '1', '110H5'),
('FU00317', 'Bàn làm việc', '2000000', '1', '111H5'),
('FU00318', 'Bàn làm việc', '2000000', '1', '112H5'),
('FU00319', 'Bàn làm việc', '2000000', '1', '113H5'),
('FU00320', 'Bàn làm việc', '2000000', '1', '114H5');



INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00321', 'Ghế làm việc', '2000000', '1', '110H1'),
('FU00322', 'Ghế làm việc', '2000000', '1', '111H1'),
('FU00323', 'Ghế làm việc', '2000000', '1', '112H1'),
('FU00324', 'Ghế làm việc', '2000000', '1', '113H1'),
('FU00325', 'Ghế làm việc', '2000000', '1', '114H1'),
('FU00326', 'Ghế làm việc', '2000000', '1', '110H2'),
('FU00327', 'Ghế làm việc', '2000000', '1', '111H2'),
('FU00328', 'Ghế làm việc', '2000000', '1', '112H2'),
('FU00329', 'Ghế làm việc', '2000000', '1', '113H2'),
('FU00330', 'Ghế làm việc', '2000000', '1', '114H2'),
('FU00331', 'Ghế làm việc', '2000000', '1', '110H3'),
('FU00332', 'Ghế làm việc', '2000000', '1', '111H3'),
('FU00333', 'Ghế làm việc', '2000000', '1', '112H3'),
('FU00334', 'Ghế làm việc', '2000000', '1', '113H3'),
('FU00335', 'Ghế làm việc', '2000000', '1', '114H3'),
('FU00336', 'Ghế làm việc', '2000000', '1', '110H4'),
('FU00337', 'Ghế làm việc', '2000000', '1', '111H4'),
('FU00338', 'Ghế làm việc', '2000000', '1', '112H4'),
('FU00339', 'Ghế làm việc', '2000000', '1', '113H4'),
('FU00340', 'Ghế làm việc', '2000000', '1', '114H4'),
('FU00341', 'Ghế làm việc', '2000000', '1', '110H5'),
('FU00342', 'Ghế làm việc', '2000000', '1', '111H5'),
('FU00343', 'Ghế làm việc', '2000000', '1', '112H5'),
('FU00344', 'Ghế làm việc', '2000000', '1', '113H5'),
('FU00345', 'Ghế làm việc', '2000000', '1', '114H5');


INSERT INTO `testh`.`furniture` (`id_fur`, `name_fur`, `price_fur`, `status_fur`, `roomNumber`) 
VALUES 
('FU00346', 'Tủ lạnh SAMSUNG', '24000000', '1', '110H1'),
('FU00347', 'Tủ lạnh SAMSUNG', '24000000', '1', '111H1'),
('FU00348', 'Tủ lạnh SAMSUNG', '24000000', '1', '112H1'),
('FU00349', 'Tủ lạnh SAMSUNG', '24000000', '1', '113H1'),
('FU00350', 'Tủ lạnh SAMSUNG', '24000000', '1', '114H1'),
('FU00351', 'Tủ lạnh SAMSUNG', '24000000', '1', '110H2'),
('FU00352', 'Tủ lạnh SAMSUNG', '24000000', '1', '111H2'),
('FU00353', 'Tủ lạnh SAMSUNG', '24000000', '1', '112H2'),
('FU00354', 'Tủ lạnh SAMSUNG', '24000000', '1', '113H2'),
('FU00355', 'Tủ lạnh SAMSUNG', '24000000', '1', '114H2'),
('FU00356', 'Tủ lạnh SAMSUNG', '24000000', '1', '110H3'),
('FU00357', 'Tủ lạnh SAMSUNG', '24000000', '1', '111H3'),
('FU00358', 'Tủ lạnh SAMSUNG', '24000000', '1', '112H3'),
('FU00359', 'Tủ lạnh SAMSUNG', '24000000', '1', '113H3'),
('FU00360', 'Tủ lạnh SAMSUNG', '24000000', '1', '114H3'),
('FU00361', 'Tủ lạnh SAMSUNG', '24000000', '1', '110H4'),
('FU00362', 'Tủ lạnh SAMSUNG', '24000000', '1', '111H4'),
('FU00363', 'Tủ lạnh SAMSUNG', '24000000', '1', '112H4'),
('FU00364', 'Tủ lạnh SAMSUNG', '24000000', '1', '113H4'),
('FU00365', 'Tủ lạnh SAMSUNG', '24000000', '1', '114H4'),
('FU00366', 'Tủ lạnh SAMSUNG', '24000000', '1', '110H5'),
('FU00367', 'Tủ lạnh SAMSUNG', '24000000', '1', '111H5'),
('FU00368', 'Tủ lạnh SAMSUNG', '24000000', '1', '112H5'),
('FU00369', 'Tủ lạnh SAMSUNG', '24000000', '1', '113H5'),
('FU00370', 'Tủ lạnh SAMSUNG', '24000000', '1', '114H5');


INSERT INTO `testh`.`user` (`username`, `password`, `role`) 
VALUES 
('00134485922', '1', '1'),
('00134423442', '1', '1'),
('00214485922', '1', '1'),
('00224485922', '1', '1'),
('00344485922', '1', '1'),
('00554485922', '1', '1'),
('00666485922', '1', '1'),
('00777485922', '1', '1'),
('00888485922', '1', '1'),
('00999485922', '1', '1');


INSERT INTO `testh`.`employee` (`id_emp`, `name_emp`, `idcard_emp`, `gender_emp`, `birthDate_emp`, `address_emp`, `phone_emp`, `email_emp`, `eduLevel_emp`, `username`) 
VALUES 
('NV001', 'Hoàng Kim Thoa', '00134485922', '0', '2002-09-03', 'Hà Lội', '097234852', 'thoa@gmail.com', 'Đại Học', '00134485922'),
('NV002', 'Nguyễn Nhật Linh', '00134423442', '0', '1988-09-04', 'Bắc Giang', '0972323452', 'linh@gmail.com', 'Cao đẳng', '00134423442'),
('NV003', 'Trần Thị Huyền Trang', '00214485922', '0', '2001-09-05', 'Hải Phòng', '097444852', 'trang@gmail.com', 'THPT', '00214485922'),
('NV004', 'Vũ Khánh Hoàng', '00224485922', '1', '2001-09-06', 'Quảng Ninh', '032334852', 'hoang@gmail.com', 'Đại Học', '00224485922'),
('NV005', 'Võ Nhật Huy', '00344485922', '1', '2001-09-07', 'Thái Bình', '097200852', 'huy@gmail.com', 'Đại Học', '00344485922'),
('NV006', 'Nguyễn Ngọc Ánh', '00554485922', '0', '2001-09-08', 'Nam Định', '097211152', 'anh@gmail.com', 'Cao đẳng', '00554485922'),
('NV007', 'Phan Trang Kiên', '00666485922', '0', '2001-09-09', 'Ninh Bình', '089234852', 'kien@gmail.com', 'Học nghề', '00666485922'),
('NV008', 'Võ Nhật Minh', '00777485922', '1', '2004-09-10', 'Thanh Hóa', '0988834852', 'minh@gmail.com', 'Đại Học', '00777485922'),
('NV009', 'Nguyễn Bá Túc', '00888485922', '1', '1999-04-02', 'Bắc Kạn', '091014852', 'tuc@gmail.com', 'Cao Đẳng', '00888485922'),
('NV010', 'Nguyễn Văn Hoàng Khoa', '00999485922', '1', '2003-02-02', 'Hà Lội', '0970004852', 'khoa@gmail.com', 'Đại Học', '00999485922');





