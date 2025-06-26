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