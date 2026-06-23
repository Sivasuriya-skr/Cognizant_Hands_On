# Exercise 1: Control Structures

Control structures in PL/SQL allow procedural processing of database records. They include conditional execution structures (`IF-THEN-ELSE`) and iterative loops (`FOR LOOP`, `WHILE LOOP`, `LOOP-END LOOP`), often coupled with cursor structures to traverse query result sets.

---

## 1. Understading PL/SQL Control Structures

### Cursors and Iterative Loops
*   **Cursor**: A cursor is a pointer to the private SQL area containing information about the processing of a SELECT statement. We use an **implicit cursor** in `FOR r_cust IN c_customers` loop, which automatically handles opening, fetching, and closing the cursor, avoiding boilerplate code and preventing resource leaks.
*   **Row Updates**: Inside cursor loops, we can perform DML updates targeting specific records based on criteria fetched.

### Date Arithmetic and Calculations
*   **Age Calculation**: In Oracle PL/SQL, we use `MONTHS_BETWEEN(SYSDATE, DOB) / 12` and apply `TRUNC` to get the customer's completed years of age.
*   **Date Range Filters**: In SQL/PL-SQL, filtering for due dates in a range utilizes expressions like `EndDate BETWEEN SYSDATE AND SYSDATE + 30`.

---

## 2. Implementation Overview

### Scenario 1: Loan Interest Rate Discount
*   **Problem**: Apply a 1% discount to loan interest rates for customers older than 60 years.
*   **Approach**: Iterates through all customers. For each, calculates their age from `DOB`. If the age exceeds 60, updates the `Loans` table where `CustomerID` matches.
*   **File**: [Scenario_1.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-1-control-structures/Scenario_1.sql)

### Scenario 2: VIP Status Promotion
*   **Problem**: Set the `IsVIP` flag to `'TRUE'` for all customers whose balance is over $10,000.
*   **Approach**: Iterates through all customers. Checks if `Balance > 10000.00` and if the customer is not already promoted. Performs the UPDATE statement and commits.
*   **File**: [Scenario_2.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-1-control-structures/Scenario_2.sql)

### Scenario 3: Loan Repayment Reminders
*   **Problem**: Print a reminder message for loans due in the next 30 days.
*   **Approach**: Uses a cursor joining `Loans` and `Customers` where the loan's `EndDate` is between `SYSDATE` and `SYSDATE + 30`. Prints a custom statement using `DBMS_OUTPUT.PUT_LINE` for each loan found.
*   **File**: [Scenario_3.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-1-control-structures/Scenario_3.sql)

---

## 3. How to Run & Verify

1. Run the database schema initialization script: [schema.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/schema.sql)
2. Load mock data: [sample_data.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/sample_data.sql)
3. Execute the respective anonymous block SQL script inside an Oracle SQL client (SQL*Plus, Oracle SQL Developer, or Oracle Live SQL) with `SET SERVEROUTPUT ON` enabled.
4. Verify the DB table changes using the verification queries in [verify.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/verify.sql).
