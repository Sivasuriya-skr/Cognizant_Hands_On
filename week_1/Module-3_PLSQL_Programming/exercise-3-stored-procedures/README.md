# Exercise 3: Stored Procedures

Stored procedures are schema objects that encapsulate a set of SQL statements and PL/SQL blocks. They reside on the server, compile once, and can be executed by applications or database users. 

---

## 1. Concepts & Best Practices

### Benefits of Stored Procedures
*   **Modularity & Reusability**: Logic is written once and shared across multiple systems, standardizing business rules.
*   **Performance**: Since they are stored in compiled form in the database, network round-trips are minimized, and SQL compilation overhead is reduced.
*   **Security**: Users can be granted execution permissions on procedures without giving direct select/update permissions to the underlying tables.

### Concurrency and Concurrency Control
*   **Lost Update Prevention**: When updating records based on current value calculations, we lock the rows using `FOR UPDATE`. This prevents concurrent sessions from modifying the same data between the read and write steps.
*   **Deadlock Prevention**: If two sessions lock the same two resources in a different order, a deadlock occurs. In [Scenario_3.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-3-stored-procedures/Scenario_3.sql), we resolve this by identifying the lower and higher account IDs and always locking the lower ID first, establishing a consistent locking order globally.

### Transaction Control
*   We use `COMMIT` to save changes permanently when the operation succeeds.
*   We use `ROLLBACK` in the exception handler to ensure that if any step fails (e.g., database error or validation violation), the entire database transaction is reverted to a consistent state.

---

## 2. Implementation Overview

### Scenario 1: Process Monthly Interest
*   **Procedure**: `ProcessMonthlyInterest`
*   **Logic**: Calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance. Updates the audit column `LastUpdate` to `SYSDATE`.
*   **File**: [Scenario_1.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-3-stored-procedures/Scenario_1.sql)

### Scenario 2: Employee Bonus Scheme
*   **Procedure**: `UpdateEmployeeBonus`
*   **Parameters**: `p_department` (IN, VARCHAR2), `p_bonus_percentage` (IN, NUMBER)
*   **Logic**: Updates the salary of employees in a given department by adding a bonus percentage passed as a parameter. Includes check validations for null/empty departments and negative bonus percentages.
*   **File**: [Scenario_2.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-3-stored-procedures/Scenario_2.sql)

### Scenario 3: Fund Transfer Between Accounts
*   **Procedure**: `TransferFunds`
*   **Parameters**: `p_source_account` (IN, NUMBER), `p_dest_account` (IN, NUMBER), `p_amount` (IN, NUMBER)
*   **Logic**: Safely transfers funds between two accounts. Checks that the accounts exist, they are distinct, and that the source account has a sufficient balance before executing the transfer. Implements deadlock-free double-row locking.
*   **File**: [Scenario_3.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/exercise-3-stored-procedures/Scenario_3.sql)

---

## 3. How to Run & Verify

1. Run the database schema initialization script: [schema.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/schema.sql)
2. Load mock data: [sample_data.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/sample_data.sql)
3. Compile the stored procedures by executing their respective scripts in an Oracle SQL client.
4. Execute the verification scripts in [verify.sql](file:///d:/CTS_HANDS_ON/week_1/Module-3_PLSQL_Programming/verify.sql) to run and test successful and failure scenarios.
