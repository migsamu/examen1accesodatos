DROP DATABASE IF EXISTS Bank;

CREATE DATABASE IF NOT EXISTS Bank;

USE Bank;

CREATE TABLE IF NOT EXISTS Customer (
    id INT PRIMARY KEY,
	nif VARCHAR(9) UNIQUE,
	name VARCHAR (100) NOT NULL,
	surname VARCHAR (100) NOT NULL,
	cp INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Account (
	iban VARCHAR (20) PRIMARY KEY,
	owner_id INT NOT NULL,
	balance DOUBLE NOT NULL,
	open_date DATE NOT NULL,
	CONSTRAINT FK_Account_Customer
	FOREIGN KEY (owner_id)
	REFERENCES Customer (id)
	ON UPDATE CASCADE
    ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Movement (
	id INT AUTO_INCREMENT PRIMARY KEY,
	iban VARCHAR (20) NOT NULL,
	movement_date DATETIME NOT NULL,
	amount DOUBLE  NOT NULL,
	description VARCHAR(200) NOT NULL,
	CONSTRAINT FK_Movement_Account
	FOREIGN KEY (iban)
	REFERENCES Account (iban)
	ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO Customer(id, nif, name, surname, cp) VALUES (1, '00000000X', 'Peppa', 'Pig', 31000);
INSERT INTO Customer(id, nif, name, surname, cp) VALUES (2, '10000000X', 'Bob', 'Esponja', 31000);

INSERT INTO Account(iban, owner_id, balance, open_date) VALUES('ES123456789123456789', 1, 1000000, '2019-10-01');
INSERT INTO Movement(iban, movement_date, amount, description) VALUES('ES123456789123456789', '2019-10-01', 2000000, 'Ingreso');
INSERT INTO Movement(iban, movement_date, amount, description) VALUES('ES123456789123456789', '2019-10-10', -1000000, 'Retirada');

INSERT INTO Account(iban, owner_id, balance, open_date) VALUES('ES00000000', 1, 1000, '2010-10-01');
