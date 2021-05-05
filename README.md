# DairyMilkManagement

inside your mysql workbench run these queries 

Create Database dairyMilk;
use dairyMilk;

CREATE TABLE `purchase` (
  `id` int DEFAULT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `StaffId` varchar(255) DEFAULT NULL,
  `seller_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `milktype` varchar(255) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `Rate` double DEFAULT NULL,
  `TotalAmount` double DEFAULT NULL
  );
  
  CREATE TABLE `sellmilk` (
  `id` int NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `staffid` varchar(255) DEFAULT NULL,
  `DealerName` varchar(255) DEFAULT NULL,
  `milktype` varchar(255) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `staff` (
  `staffid` varchar(255) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`staffid`)
);


CREATE TABLE `stock` (
  `id` int NOT NULL,
  `milktype` varchar(255) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `transaction` (
  `id` int NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `purchase_sales_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into stock value(1, 'cow', 100);
insert into stock value(2, 'buffalo', 100);
insert into stock value(3, 'camel', 100);
