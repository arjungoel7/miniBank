--Simple Queries

--1.	Select the names of all customers along with their account numbers, type and balance.

	SELECT C.c_name, A.acc_no, A.type, A.balance
	FROM customer C INNER JOIN customer_accounts CA ON C.aadhaar = CA.aadhaar INNER JOIN account A ON CA.acc_no = A.acc_no
	ORDER BY A.acc_no;


--2.	Select the name and loan number of all customers who have taken a loan.

	SELECT C.c_name,L.loan_no
	FROM customer C NATURAL JOIN loan L;


--Complex Queries

--1.	Find the name of the bank which has the maximum number of customers.

	WITH bank_cust(bcode,name,num_cust) AS (SELECT B.code,B.name,COUNT(C.aadhaar)
					     FROM Bank B INNER JOIN Account A ON A.code = B.code INNER JOIN customer_accounts CA ON CA.acc_no = A.acc_no INNER JOIN customer C ON CA.aadhaar = C.aadhaar
					     GROUP BY B.code,B.name),
	bank_cust_max(num_cust) AS (SELECT MAX(num_cust) FROM bank_cust)
	SELECT B1.bcode,B1.name
	FROM bank_cust B1, bank_cust_max B2
	WHERE B1.num_cust = B2.num_cust;

--2.	Display the details of those banks which have a branch in a city where any bank is head quartered.

	WITH city_add AS (SELECT head_address FROM bank)
	SELECT B.code, B.name
	FROM bank B INNER JOIN branch Br ON B.code = Br.code
	WHERE Br.address IN (SELECT * FROM city_add);
