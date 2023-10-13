CREATE DATABASE qwertyBank;

USE qwertyBank;

CREATE TABLE employees (
    empID INT PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    email VARCHAR(500) NOT NULL,
    password VARCHAR(500) NOT NULL
)

CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    Price VARCHAR(255) NOT NULL,
    Stock VARCHAR(255) NOT NULL NOT NULL
);

INSERT INTO Products VALUES (1, 'Salad', '50.0', '20');
INSERT INTO Products VALUES (2, 'Sa', '20.0', '50');

INSERT INTO employees VALUES(1, 'test', 'test@email.com', 'P@$$w0rd');
