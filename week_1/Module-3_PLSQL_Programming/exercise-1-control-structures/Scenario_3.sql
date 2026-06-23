DECLARE
    -- Cursor to fetch loans due in the next 30 days along with customer details
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate, l.LoanAmount
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_found BOOLEAN := FALSE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting Loan Due Date Reminders ---');

    FOR r_loan IN c_due_loans LOOP
        v_found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Hello ' || r_loan.Name || 
                             ', your loan (ID: ' || r_loan.LoanID || 
                             ') of amount $' || r_loan.LoanAmount || 
                             ' is due on ' || TO_CHAR(r_loan.EndDate, 'YYYY-MM-DD') || 
                             '. Please ensure sufficient funds for repayment.');
    END LOOP;

    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due within the next 30 days.');
    END IF;
END;
/
