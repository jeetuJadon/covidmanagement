INSERT INTO USERS(USER_ID,PASSWORD,CUS_TYPE) VALUES ('Jeetu','jadon@123','regular'),
('Gursheen','Aura@2020','premium'),
('Shruti','sh@2020','gold');

INSERT INTO T_COUNTRY(COUNTRY_ID,COUNTRY_NAME) VALUES (1,'India'),
(2,'Singapore');

INSERT INTO T_COUNTRY_AREA(AREA_ID,AREA_NAME, COUNTRY_ID) VALUES
(1,'Maharashtra',1),
(2,'Gujarat',1),
(3,'Madhya Pradesh',1);


INSERT INTO T_PATIENT_DETAILS(PATIENT_NAME,COUNTRY_ID,AREA_ID,PATIENT_STATUS,REMARKS) VALUES
('Jeetu',1,1,0,'Dummy '),
('Jeetu1',1,1,0,'Dummy 2'),
('Jeetu2',1,1,0,'Dummy 3'),
('Jeetu3',1,1,0,'Dummy 4'),
('Jeetu4',1,1,1,'Dummy 5'),
('Jitendrasnh',1,2,0,'Dummy 6'),
('Jitendrasnh1',1,2,0,'Dummy 7'),
('Jitendrasnh2',1,2,0,'Dummy 8'),
('Jitendrasnh3',1,2,0,'Dummy 9'),
('Jitendrasnh4',1,2,1,'Dummy 10');

INSERT INTO CUSTOMER_TYPE_DISCOUNT VALUES('regular',0,5000, 0),
('regular',5000,10000, 10),
('regular',10000,null, 20),
('premium',0,4000, 10),
('premium',4000,8000, 15),
('premium',8000,12000, 20),
('premium',12000,null, 30);