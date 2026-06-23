-- ============================================================================
-- VERIFICATION SCRIPT FOR MODULE 3: PL/SQL PROGRAMMING
-- ============================================================================
-- Note: Make sure to execute schema.sql and sample_data.sql first.
-- Enable console printing in SQL*Plus or SQL Developer:
-- SET SERVEROUTPUT ON;
-- ============================================================================

PROMPT ========================================================================
PROMPT --- VERIFYING EXERCISE 1: CONTROL STRUCTURES ---
PROMPT ========================================================================

PROMPT --- 1.1 BEFORE running Loan Interest Discount Scenario ---
SELECT l.LoanID, c.Name, c.DOB, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age, l.InterestRate 
FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID;

PROMPT Running Scenario 1 (Discount for Customers > 60)...
@exercise-1-control-structures/Scenario_1.sql;

PROMPT --- 1.1 AFTER running Scenario ---
SELECT l.LoanID, c.Name, c.DOB, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age, l.InterestRate 
FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID;


PROMPT --- 1.2 BEFORE running VIP Status Promotion Scenario ---
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;

PROMPT Running Scenario 2 (VIP promotion for Balance > 10,000)...
@exercise-1-control-structures/Scenario_2.sql;

PROMPT --- 1.2 AFTER running Scenario ---
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;


PROMPT --- 1.3 Running Scenario 3 (Print reminders for loans due in next 30 days) ---
@exercise-1-control-structures/Scenario_3.sql;


PROMPT ========================================================================
PROMPT --- COMPILING EXERCISE 3 STORED PROCEDURES ---
PROMPT ========================================================================
PROMPT Compiling ProcessMonthlyInterest...
@exercise-3-stored-procedures/Scenario_1.sql;

PROMPT Compiling UpdateEmployeeBonus...
@exercise-3-stored-procedures/Scenario_2.sql;

PROMPT Compiling TransferFunds...
@exercise-3-stored-procedures/Scenario_3.sql;


PROMPT ========================================================================
PROMPT --- VERIFYING EXERCISE 3: STORED PROCEDURES ---
PROMPT ========================================================================

PROMPT --- 3.1 BEFORE running ProcessMonthlyInterest ---
SELECT AccountID, CustomerID, AccountType, Balance FROM Accounts;

PROMPT Running ProcessMonthlyInterest...
EXEC ProcessMonthlyInterest;

PROMPT --- 3.1 AFTER running ProcessMonthlyInterest ---
SELECT AccountID, CustomerID, AccountType, Balance FROM Accounts;


PROMPT --- 3.2 BEFORE running UpdateEmployeeBonus for IT department by 10% ---
SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE Department = 'IT';

PROMPT Running UpdateEmployeeBonus for IT department...
EXEC UpdateEmployeeBonus('IT', 10);

PROMPT --- 3.2 AFTER running UpdateEmployeeBonus ---
SELECT EmployeeID, Name, Department, Salary FROM Employees WHERE Department = 'IT';


PROMPT --- 3.3.A BEFORE running TransferFunds (Successful transfer) ---
-- Transferring 500 from Account 101 to Account 102
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (101, 102);

PROMPT Running TransferFunds (Success Case)...
EXEC TransferFunds(101, 102, 500);

PROMPT --- 3.3.A AFTER running TransferFunds (Successful transfer) ---
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (101, 102);


PROMPT --- 3.3.B Running TransferFunds (Failure Case: Insufficient Funds) ---
-- Account 102 has balance around 6055 (5500 + 1% interest + 500 transfer)
-- Attempting to transfer 10000 (should fail)
BEGIN
    TransferFunds(102, 101, 10000);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Caught Expected Exception: ' || SQLERRM);
END;
/


PROMPT --- 3.3.C Running TransferFunds (Failure Case: Account does not exist) ---
-- Attempting to transfer from non-existent account 999
BEGIN
    TransferFunds(999, 101, 100);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Caught Expected Exception: ' || SQLERRM);
END;
/
