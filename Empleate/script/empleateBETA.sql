-- MySQL Workbench Forward Engineering

DROP DATABASE empleateBETA;
CREATE DATABASE empleateBETA;
USE empleateBETA ;
DROP TABLE jobCategory;
DROP TABLE offerCategory;
DROP TABLE Job;
DROP TABLE Login;
DROP TABLE Category;
DROP TABLE Manager ;
DROP TABLE Company;
DROP TABLE Offerer;


-- -----------------------------------------------------
-- Table  login
-- -----------------------------------------------------


CREATE TABLE Login (
  idLogin INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NULL UNIQUE,
  password VARCHAR(45) NULL,
  type_log VARCHAR(45) NULL,
  enable INT,
  PRIMARY KEY (idLogin));

-- -----------------------------------------------------
-- Table manager
-- -----------------------------------------------------


CREATE TABLE Manager (
  idManager INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45),
  login INT NOT NULL UNIQUE,
  PRIMARY KEY (idManager),
  CONSTRAINT fkManager FOREIGN KEY (login) REFERENCES Login(idLogin));
  

-- -----------------------------------------------------
-- Table Company
-- -----------------------------------------------------

CREATE TABLE Company (
  idCompany INT NOT NULL  AUTO_INCREMENT,
  name_company VARCHAR(45) NULL,
  email VARCHAR(45) NULL UNIQUE,
  phone VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  location_X double,
  location_Y double,
  address VARCHAR(45) NULL,
  login INT NOT NULL UNIQUE,
  active INT,
  PRIMARY KEY (idCompany),
  CONSTRAINT fkCompany FOREIGN KEY (login) REFERENCES Login(idLogin));


-- -----------------------------------------------------
-- Table  offerer
-- -----------------------------------------------------



CREATE TABLE Offerer( 
  idOfferer INT NOT NULL AUTO_INCREMENT,
  name_offerer VARCHAR(45) NULL,
  lastname VARCHAR(45) NULL,
  nationality VARCHAR(45) NULL,
  email VARCHAR(45) NULL UNIQUE,
  phone VARCHAR(45) NULL,
  location_X double,
  location_Y double,
  residence VARCHAR(45) NULL,
  login INT NOT NULL UNIQUE,
  active INT,
  PRIMARY KEY (idOfferer),
   CONSTRAINT fkOfferer FOREIGN KEY (login) REFERENCES Login(idLogin));




-- -----------------------------------------------------
-- Table  job
-- -----------------------------------------------------


CREATE TABLE Job (
  idJob INT NOT NULL AUTO_INCREMENT,
  name_Job VARCHAR(45) NULL,
  description_Job VARCHAR(45) NULL,
  salary INT NULL,
  type_Job VARCHAR(45) NULL,
  comp INT NOT NULL,
  status_Job INT NULL,
  PRIMARY KEY (idJob),
  CONSTRAINT fk_Job_Company
    FOREIGN KEY (comp)
    REFERENCES Company(idCompany));


-- -----------------------------------------------------
-- Table category
-- -----------------------------------------------------


CREATE TABLE Category (
  idCategory INT NOT NULL AUTO_INCREMENT,
  name_Category VARCHAR(45) NULL,
  parentCategory INT NULL,
  isRoot INT NOT NULL,
  isDad INT NOT NULL,
  PRIMARY KEY (idCategory),
  CONSTRAINT fk_Category_Category1
    FOREIGN KEY (parentCategory)
    REFERENCES Category (idCategory));

-- -----------------------------------------------------
-- Table jobCategory
-- -----------------------------------------------------


CREATE TABLE jobCategory (
  percentage INT NULL,
  j INT NOT NULL,
  cat INT NOT NULL,
  PRIMARY KEY (j, cat),
  CONSTRAINT fk_JobCategory_Job1
    FOREIGN KEY (j)
    REFERENCES Job (idJob),
  CONSTRAINT fk_JobCategory_Category1
    FOREIGN KEY (cat)
    REFERENCES Category (idCategory));


-- -----------------------------------------------------
-- Table offerCategory
-- -----------------------------------------------------


CREATE TABLE offerCategory (
  percentage INT NULL,
  offer INT NOT NULL,
  cat INT NOT NULL,
  PRIMARY KEY (offer, cat),
  CONSTRAINT fk_OfferCategory_Offerer1
    FOREIGN KEY (offer)
    REFERENCES Offerer (idOfferer),
  CONSTRAINT fk_OfferCategory_Category1
    FOREIGN KEY (cat)
    REFERENCES Category (idCategory));
  
  -- -----------------------------------------------------
-- TValores para las tablas
-- -----------------------------------------------------
insert into Login(username,password,type_log,enable) values ('SYS_BDA','adm001','manager',1);
insert into Login(username,password,type_log,enable) values ('ICODER_CR','comp001','company',1);
insert into Login(username,password,type_log,enable) values ('ICAFE_CR','comp002','company',1);
insert into Login(username,password,type_log,enable) values ('INTEL_CO','comp003','company',1);
insert into Login(username,password,type_log,enable) values ('HP_INC','comp004','company',1);
insert into Login(username,password,type_log,enable) values ('SAMSUNG_INC','comp005','company',1);
insert into Login(username,password,type_log,enable) values ('MUNI_HERED','comp006','company',1);
insert into Login(username,password,type_log,enable) values ('andres_G','user001','offerer',1);
insert into Login(username,password,type_log,enable) values ('spidyxD','user002','offerer',1);
 
 insert into Manager (email,login) values ('BDA@system.com',1);
  
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('ICODER','ICODER.COM','123456','Deportes',100.96,93.58,'',2);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('ICAFE','ICAFE.COM','2651556','Invs. Cafe',58.15,74.26,'',3);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('INTEL','INTEL.COM','1274513456','Microproce',89.25,24.36,'',4);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values('HP','HP.COM','51165151','Servicios Infor',561.58,15.36,'',5);
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values ('SAMSUNG','samsung.com','123456','Tecnologia',835.36,58.12,'',6) ;
 insert into Company (name_company,email,phone,description,location_X,location_Y,address,login) values ('Municipalidad','muni@gmail.com','789456','MunicipalidadHeredia',45.36,12.45,'',7) ;
 
update Company set address ='SABANA' where idCompany = 6;
update Company set address ='SANTA BARBARA' where idCompany = 5;
update Company set address ='LAGUNILLA' where idCompany = 3;
update Company set address ='SANTA CECILIA' where idCompany = 4;
update Company set address ='HEREDIA' where idCompany = 2;
update Company set address ='BARVA' where idCompany = 1;

update Company set active = 1 where idCompany = 6;
update Company set active = 1 where idCompany = 5;
update Company set active = 1 where idCompany = 3;
update Company set active = 1 where idCompany = 4;
update Company set active = 0 where idCompany = 2;
update Company set active = 0 where idCompany = 1;

update Company set location_X = 9.9340834 where idCompany = 1; -- ICODER
update Company set location_Y = -84.1006278 where idCompany = 1;

update Company set location_X = 10.0345799 where idCompany = 2; -- ICAFE 
update Company set location_Y = -84.1374039 where idCompany = 2;

update Company set location_X = 9.9959059 where idCompany = 3;-- INTEL
update Company set location_Y = -84.1780615 where idCompany = 3;

update Company set location_X = 9.9883804 where idCompany = 4;-- HP
update Company set location_Y = -84.165239 where idCompany = 4;

update Company set location_X = 9.940428 where idCompany = 5;-- SAMSUNG
update Company set location_Y = -84.1560109 where idCompany = 5;

update Company set location_X = 9.9989587 where idCompany = 6; -- MUNICIPALIDAD
update Company set location_Y = -84.1166156 where idCompany = 6;

insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Designer','Designing is life',350000,'private',1, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Programmer','Junior Java',250000,'public',1,1);
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('DBA','Do not touch my data base',450000,'private',2, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Tecnical support','I can fix but is not free',550000,'public',2, 1); 
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Developer','Junior Java',3750000,'private',3,1);
insert into Job (name_Job, description_Job,salary, type_Job, comp, status_Job) values('Manager','loquesea Java',3750000,'public',3,1);


insert into Offerer (name_offerer, lastname, nationality, phone, email,location_X,location_Y, residence,login,active) values ('Andres','Gutierrez','CR','61688613','a@gmail.com',100.96,93.58,'Heredia',8,1);
insert into Offerer (name_offerer, lastname, nationality, phone, email,location_X,location_Y, residence,login,active) values ('Roger','Amador','CR','83656107','r@gmail.com',100.96,93.58,'Desamparados',9,0);




insert into Category (name_Category,isRoot,isDad) values('PROGRAMACION',1,1);    -- 1                   
insert into Category (name_Category,isRoot,isDad) values('Diseño WEB',1,1);    -- 2                      
insert into Category (name_Category,isRoot,isDad) values('REDES',1,1);        -- 3                      
insert into Category (name_Category,isRoot,isDad) values('Manager',1,1);     -- 4                        
insert into Category (name_Category,isRoot,isDad) values('Support Manintenence',1,1);   -- 5             
insert into Category (parentCategory,name_Category,isRoot,isDad) values(1,'JAVA',0,1);    -- 6           
insert into Category (parentCategory,name_Category,isRoot,isDad) values(1,'C++',0,0);  -- 7            
insert into Category (parentCategory,name_Category,isRoot,isDad) values(2,'CSS',0,1);      -- 8          
insert into Category (parentCategory,name_Category,isRoot,isDad) values(3,'CISCO',0,0);    -- 9          
insert into Category (parentCategory,name_Category,isRoot,isDad) values(6,'JSON',0,0);      -- 10         
insert into Category (parentCategory,name_Category,isRoot,isDad) values(8,'BOOTSTRAP',0,0);       -- 11    
insert into Category (parentCategory,name_Category,isRoot,isDad) values(8,'MATERIALIZE',0,0);    -- 12    
insert into Category (parentCategory,name_Category,isRoot,isDad) values(4,'DBA',0,0);       -- 13            
insert into Category (parentCategory,name_Category,isRoot,isDad) values(5,'support tecnician',0,0);  -- 14
insert into Category (parentCategory,name_Category,isRoot,isDad) values(4,'administer',0,0);       -- 15 
insert into Category (parentCategory,name_Category,isRoot,isDad) values(1,'AJAX',0,0); -- 16 




insert into jobCategory (j, cat, percentage)values(1,11,85);
insert into jobCategory (j, cat, percentage)values(2,10,90);
insert into jobCategory (j, cat, percentage)values(6,13,90);  
insert into jobCategory (j, cat, percentage)values(4,14,90);
insert into jobCategory (j, cat, percentage)values(3,15,90);
insert into jobCategory (j, cat, percentage)values(5,7,90);
insert into jobCategory (j, cat, percentage)values(1,12,90);

insert into offerCategory (offer, cat, percentage)values(1,6,90);
insert into offerCategory (offer, cat, percentage)values(1,15,90);
insert into offerCategory (offer, cat, percentage)values(1,8,90);
insert into offerCategory (offer, cat, percentage)values(1,13,90);

insert into offerCategory (offer, cat, percentage)values(2,7,90);
insert into offerCategory (offer, cat, percentage)values(2,6,90);
insert into offerCategory (offer, cat, percentage)values(2,16,90);
insert into offerCategory (offer, cat, percentage)values(2,10,90);
