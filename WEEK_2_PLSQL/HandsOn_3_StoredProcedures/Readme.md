# CONTROL STRUCTURES

In this I have implemented the database schema provided and added my own values for the procedure record.

## SCHEMA
---------------------------

***``` Customer```***

| Column Name   | Null?     | Type           |
|---------------|-----------|----------------|
| CUSTOMERID    | NOT NULL  | NUMBER         |
| NAME          |           | VARCHAR2(100)  |
| DOB           |           | DATE           |
| BALANCE       |           | NUMBER         |
| LASTMODIFIED  |           | DATE           |
| ISVIP         |           | CHAR(1)        |

***``` Transaction ```***

| Column Name      | Null?     | Type           |
|------------------|-----------|----------------|
| TRANSACTIONID    | NOT NULL  | NUMBER         |
| ACCOUNTID        |           | NUMBER         |
| TRANSACTIONDATE  |           | DATE           |
| AMOUNT           |           | NUMBER         |
| TRANSACTIONTYPE  |           | VARCHAR2(10)   |

***``` Account ```***

| Column Name   | Null?     | Type           |
|---------------|-----------|----------------|
| ACCOUNTID     | NOT NULL  | NUMBER         |
| CUSTOMERID    |           | NUMBER         |
| ACCOUNTTYPE   |           | VARCHAR2(20)   |
| BALANCE       |           | NUMBER         |
| LASTMODIFIED  |           | DATE           |

***``` Employee ```***

| Column Name | Null?     | Type           |
|-------------|-----------|----------------|
| EMPLOYEEID  | NOT NULL  | NUMBER         |
| NAME        |           | VARCHAR2(100)  |
| POSITION    |           | VARCHAR2(50)   |
| SALARY      |           | NUMBER         |
| DEPARTMENT  |           | VARCHAR2(50)   |
| HIREDATE    |           | DATE           |

***``` Loan```***

| Column Name   | Null?     | Type           |
|---------------|-----------|----------------|
| LOANID        | NOT NULL  | NUMBER         |
| CUSTOMERID    |           | NUMBER         |
| LOANAMOUNT    |           | NUMBER         |
| INTERESTRATE  |           | NUMBER         |
| STARTDATE     |           | DATE           |
| ENDDATE       |           | DATE           |



***I have mentioned the data's added in these tables in output picture by these table names***

---------------------------

## STORED PROCEDURES

***``` Monthly Interest ```***

``` sql

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = SYSDATE
  WHERE AccountType = 'Savings';
  
  COMMIT;
END;
/


```

***``` Bonus Provider ```***

``` sql

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_percent / 100)
  WHERE Department = dept_name;

  COMMIT;
END;
/


```

***``` Transfer Funds ```***

``` sql

CREATE OR REPLACE PROCEDURE TransferFunds (
  from_acc_id IN NUMBER,
  to_acc_id IN NUMBER,
  amount IN NUMBER
) AS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance
  FROM Accounts
  WHERE AccountID = from_acc_id;

  IF from_balance < amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - amount,
      LastModified = SYSDATE
  WHERE AccountID = from_acc_id;

  UPDATE Accounts
  SET Balance = Balance + amount,
      LastModified = SYSDATE
  WHERE AccountID = to_acc_id;

  COMMIT;
END;
/


```


## PROCEDURE CALLER

This is an seperate procedure caller script to call the created procedures.

***``` Procedure Caller ```***

``` sql

BEGIN
  TransferFunds(1, 2, 500);
END;
/

SELECT * FROM Accounts;

BEGIN
  ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/

SELECT * FROM Employees;

```

