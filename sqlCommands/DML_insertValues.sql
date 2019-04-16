insert into BANK values(101 ,'Syndicate','Manipal');
insert into BANK values(102 ,'ICICI','Delhi');
insert into BANK values(103 ,'HDFC','Mumbai');
insert into BANK values(104 ,'SBI','Chennai');

insert into BRANCH values(1,101,'Pune');
insert into BRANCH values(2,101,'Sikkim');
insert into BRANCH values(3,101,'Jaipur');
insert into BRANCH values(4,101,'Mangalore');
insert into BRANCH values(1,102,'Nagpur');
insert into BRANCH values(2,102,'Lucknow');
insert into BRANCH values(3,102,'Mumbai');
insert into BRANCH values(4,102,'Gurgaon');

insert into ACCOUNT  values(10001 ,400000,'savings',1,101);
insert into ACCOUNT  values(10002 ,500000,'current',1,101);
insert into ACCOUNT  values(10003 ,200000 ,'savings',2,101);
insert into ACCOUNT  values(10004 ,100000 ,'other',3,101);
insert into ACCOUNT  values(10005, 300000,'joint',1,102);

insert into CUSTOMER values(1000,'Prithvi',12345,'Pune');
insert into CUSTOMER values(2000,'Vaishnav',23456,'Delhi');
insert into CUSTOMER values(3000,'Eshan',34567,'Kolkata');
insert into CUSTOMER values(4000,'Anubhav',45678 ,'Chennai');

insert into LOAN values(111,'housing',    10000000,1,101,1000);
insert into LOAN values(121,'educational',5000000, 2,101,2000);
insert into LOAN values(131,'business' ,  2500000, 3,101,3000);
insert into LOAN values(141,'vehicle' ,   7500000, 4,101,4000);

insert into CUSTOMER_ACCOUNTS values(1000 ,10001);
insert into CUSTOMER_ACCOUNTS values(2000 ,10002);
insert into CUSTOMER_ACCOUNTS values(3000,10003);
insert into CUSTOMER_ACCOUNTS values(4000 ,10004);
insert into CUSTOMER_ACCOUNTS values(1000,10005);
insert into CUSTOMER_ACCOUNTS values(2000,10005);
