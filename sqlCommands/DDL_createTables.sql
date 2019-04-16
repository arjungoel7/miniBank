CREATE TABLE bank(
	code NUMBER(8) PRIMARY KEY,
	name VARCHAR (30) NOT NULL,
	head_address VARCHAR(40)
);

CREATE TABLE branch(
	br_no NUMBER(8) not null,
	code references bank(code) ON DELETE CASCADE,
	address VARCHAR(40),
	PRIMARY KEY(code,br_no)
);

CREATE TABLE account(
	acc_no NUMBER(8) PRIMARY KEY,
	balance NUMBER(10) NOT NULL,
	acc_type VARCHAR(8) CHECK (acc_type IN('savings','current','joint','other')),
	br_no NUMBER(8) NOT NULL,
	code number(8) NOT NULL,
	FOREIGN KEY (br_no, code) REFERENCES branch(br_no,code) ON DELETE CASCADE
);

CREATE TABLE customer(
	aadhaar NUMBER(8) PRIMARY KEY,
	c_name VARCHAR(25) NOT NULL,
	phone_no NUMBER(13),
	c_address VARCHAR(30)
);

CREATE TABLE loan(
	loan_no NUMBER(8) PRIMARY KEY,
	loan_type VARCHAR(20) CHECK (loan_type IN('educational','housing','marriage','vehicle','business')),
	amount NUMBER (10) NOT NULL,
	br_no NUMBER(8) NOT NULL,
	code NUMBER(8) NOT NULL,
	aadhaar REFERENCES customer(aadhaar),
	FOREIGN KEY (br_no, code) REFERENCES branch(br_no,code) ON DELETE CASCADE
);

CREATE TABLE customer_accounts(
	aadhaar REFERENCES customer(aadhaar) ON DELETE CASCADE,
	acc_no REFERENCES account(acc_no) ON DELETE CASCADE
);
