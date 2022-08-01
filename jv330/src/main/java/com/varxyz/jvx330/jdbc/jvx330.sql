CREATE TABLE Customer(
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId		VARCHAR(20)		NOT NULL,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL, --  123456-7890123
	phone		VARCHAR(13)		NOT NULL, --  010-1234-1234
	regDate		TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;
SELECT count(*) FROM Customer;
SELECT * FROM Account;
UPDATE Account SET balance=50000 WHERE aid=3005;

CREATE TABLE Account (
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	customerId		BIGINT			NOT NULL,
	accountNum		CHAR(12)		NOT NULL,	-- 000-00-0000
	accType			CHAR(1)			NOT NULL 	DEFAULT 'S',
	balance			DOUBLE			NOT NULL	DEFAULT  0,
	interestRate	DOUBLE			NOT NULL 	DEFAULT  0.0,
	overAmount		DOUBLE			NOT NULL	DEFAULT  0.0,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_CustomerId_FK 
		FOREIGN KEY (customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;

DELETE FROM Customer WHERE cid = 1004;