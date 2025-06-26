
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP CHAR(1)
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);


INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES 
(1, 'Karthikeyan S', TO_DATE('2005-08-06', 'YYYY-MM-DD'), 35420, SYSDATE, 'N');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES 
(2, 'Nandhakumar S', TO_DATE('2002-04-01', 'YYYY-MM-DD'), 45742, SYSDATE, 'N');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES 
(3, 'Kanagamani S', TO_DATE('1962-09-13', 'YYYY-MM-DD'), 45123, SYSDATE, 'N');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES 
(4, 'Selvaraj V', TO_DATE('1960-08-11', 'YYYY-MM-DD'), 41200, SYSDATE, 'N');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES 
(5, 'Hinata N', TO_DATE('2006-05-15', 'YYYY-MM-DD'), 53215, SYSDATE, 'N');


INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES 
(1, 1, 'Savings', 35420, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES 
(2, 2, 'Checking', 45742, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES 
(3, 3, 'Savings', 45123, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES 
(4, 4, 'Checking', 41200, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES 
(5, 5, 'Savings', 53215, SYSDATE);



INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES 
(1, 1, SYSDATE, 200, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES 
(2, 2, SYSDATE, 400, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES 
(3, 3, SYSDATE, 300, 'Withdrawal');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES 
(4, 4, SYSDATE, 100, 'Deposit');
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES 
(5, 5, SYSDATE, 300, 'Withdrawal');



INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES 
(1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES 
(2, 2, 8000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES 
(3, 3, 7000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES 
(4, 4, 4000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1));
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES 
(5, 5, 1000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1));



INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES 
(1, 'Karthikeyan S', 'Developer', 70000, 'IT', TO_DATE('2022-06-12', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES 
(2, 'Nandhakumar S', 'Developer', 70000, 'IT', TO_DATE('2019-08-12', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES 
(3, 'Kanagamani S', 'Manager', 90000, 'HR', TO_DATE('2002-04-01', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES 
(4, 'Selvaraj V', 'Manager', 90000, 'HR', TO_DATE('2000-01-20', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES 
(5, 'Hinata N', 'Developer', 70000, 'IT', TO_DATE('2023-07-23', 'YYYY-MM-DD'));




