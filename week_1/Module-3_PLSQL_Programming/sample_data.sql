-- Populate Customers Table
INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000.00, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (2, 'Jane Smith', TO_DATE('1985-08-20', 'YYYY-MM-DD'), 5500.00, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (3, 'Robert Johnson', TO_DATE('1960-01-10', 'YYYY-MM-DD'), 9500.00, 'FALSE');

INSERT INTO Customers (CustomerID, Name, DOB, Balance, IsVIP)
VALUES (4, 'Emily Davis', TO_DATE('1990-11-30', 'YYYY-MM-DD'), 15000.00, 'FALSE');


-- Populate Accounts Table
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (101, 1, 'Savings', 12000.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (102, 2, 'Savings', 5500.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (103, 3, 'Checking', 9500.00, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastUpdate)
VALUES (104, 4, 'Savings', 15000.00, SYSDATE);


-- Populate Loans Table
-- Loan 1: Customer 1 (>60 years old), due in 45 days, interest rate 8.5%
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (201, 1, 5000.00, 8.5, SYSDATE - 10, SYSDATE + 45);

-- Loan 2: Customer 2 (<60 years old), due in 15 days, interest rate 7.0%
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (202, 2, 10000.00, 7.0, SYSDATE - 5, SYSDATE + 15);

-- Loan 3: Customer 3 (>60 years old), due in 25 days, interest rate 9.0%
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (203, 3, 2000.00, 9.0, SYSDATE - 20, SYSDATE + 25);


-- Populate Employees Table
INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (301, 'Alice Green', 'HR', 5000.00, TO_DATE('2018-03-12', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (302, 'Bob Taylor', 'IT', 6000.00, TO_DATE('2020-07-22', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (303, 'Charlie Brown', 'IT', 7000.00, TO_DATE('2019-10-05', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Department, Salary, HireDate)
VALUES (304, 'David Miller', 'Finance', 8000.00, TO_DATE('2015-05-18', 'YYYY-MM-DD'));

COMMIT;
