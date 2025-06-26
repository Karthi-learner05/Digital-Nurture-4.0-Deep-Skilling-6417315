# CONTROL STRUCTURES

In this I have implemented the database schema provided and added my own values for the financial record.

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

## SCENARIO 1

 I have applied 1% discount on intrest rate to the peoples who are aged more than 60.

 ``` sql

BEGIN
    FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
        IF MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

 ```

## SCENARIO 2

 I have promoted the peoples to VIP who have balance more than 10000.

``` sql

BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

```

## SCENARIO 3

I sended remainder to the peoples who needs to be pay the loan due within 30 days(1 month).

``` sql

SET SERVEROUTPUT ON;
BEGIN
    FOR loan IN (
        SELECT l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan.Name || ', your loan is due on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/

```
