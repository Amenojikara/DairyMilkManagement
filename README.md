User Manual
Dairy Milk Management 

Prerequisites :- Mysql Workbench , Netbeans 8.2 (preferable) , javaFx 


Step -1 : Setting Up the database .

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
  `TotalAmount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
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


Step -2 : Download and set up the mysql connector . 
Now got to the mysql connector link and download platform independent zip file  :
https://dev.mysql.com/downloads/connector/j/
![img2](https://user-images.githubusercontent.com/72779637/117534314-ae14de80-afa5-11eb-81ca-5787f3432a84.png)


extract the zip file into any location . 

Example :-i have extracted it into the downloads . 

![img4](https://user-images.githubusercontent.com/72779637/117534323-b9680a00-afa5-11eb-8913-91c2b5c94c03.png)



then open your project folder inside the netbeans (prefferable netbeans as it contains javafx and you need not to install it ) .

go to libraries



![img1](https://user-images.githubusercontent.com/72779637/117534328-c1c04500-afa5-11eb-8ef2-51d3c620236b.png)



Right click and go to properties . 

![img6](https://user-images.githubusercontent.com/72779637/117534340-d13f8e00-afa5-11eb-8ab5-c89040111223.png)


Select this Broken Reference and remove it 


![img7](https://user-images.githubusercontent.com/72779637/117534345-d7356f00-afa5-11eb-867c-9763505d642c.png)



Now click on add JAR/Folder 
![img8](https://user-images.githubusercontent.com/72779637/117534351-dd2b5000-afa5-11eb-8af7-fc8385fdf424.png)




Go to the location where you extracted the mysql connector zip file .
![img9](https://user-images.githubusercontent.com/72779637/117534356-e3213100-afa5-11eb-9c55-c321d8a03ab7.png)



Got inside this mysql-connector-java-{version}  folder 
You will find mysql-connector jar file select it and click ok . 
![img10](https://user-images.githubusercontent.com/72779637/117534361-eae0d580-afa5-11eb-8ab4-99b28855bbb9.png)


 















Step -3 Running the project .

Run the project and on the starting page specify your mysql-connection password for the mysql workbench .


![img5](https://user-images.githubusercontent.com/72779637/117534434-4e6b0300-afa6-11eb-9b7a-6839290be1f7.png)


Click on submit . 
Now one can efficiently update,add,delete etc data inside the project . 

don’t forget to mention your mysql connection passsword in the textfield in the start page and click submit ,  if you don’t do this project will give you mysql connection errors . 
 





 
