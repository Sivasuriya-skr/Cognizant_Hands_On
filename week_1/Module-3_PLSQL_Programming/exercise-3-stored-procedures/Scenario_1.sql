CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    v_updated_rows NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting ProcessMonthlyInterest Stored Procedure ---');

    -- Update balance of all savings accounts by applying an interest rate of 1%
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastUpdate = SYSDATE
    WHERE AccountType = 'Savings';

    v_updated_rows := SQL%ROWCOUNT;
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest process completed.');
    DBMS_OUTPUT.PUT_LINE('Savings accounts updated: ' || v_updated_rows);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction rolled back. Error in ProcessMonthlyInterest: ' || SQLERRM);
        RAISE;
END;
/
