CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN Accounts.AccountID%TYPE,
    p_dest_account IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) IS
    v_source_balance Accounts.Balance%TYPE;
    v_dummy Accounts.Balance%TYPE;
    v_low_acc Accounts.AccountID%TYPE;
    v_high_acc Accounts.AccountID%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting TransferFunds Stored Procedure ---');
    
    -- Input Validation
    IF p_amount IS NULL OR p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Transfer amount must be greater than zero.');
    END IF;
    
    IF p_source_account = p_dest_account THEN
        RAISE_APPLICATION_ERROR(-20004, 'Source and destination accounts must be different.');
    END IF;

    -- Define locking order based on account ID to prevent deadlocks
    IF p_source_account < p_dest_account THEN
        v_low_acc := p_source_account;
        v_high_acc := p_dest_account;
    ELSE
        v_low_acc := p_dest_account;
        v_high_acc := p_source_account;
    END IF;

    -- Lock both accounts in the defined order to guarantee consistency and avoid deadlock
    BEGIN
        SELECT Balance INTO v_dummy FROM Accounts WHERE AccountID = v_low_acc FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20005, 'Account ID ' || v_low_acc || ' does not exist.');
    END;

    BEGIN
        SELECT Balance INTO v_dummy FROM Accounts WHERE AccountID = v_high_acc FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20006, 'Account ID ' || v_high_acc || ' does not exist.');
    END;

    -- Retrieve the source balance (already locked)
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account;

    -- Check for sufficient balance
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20007, 'Insufficient balance. Source Account ID ' || p_source_account || 
                                ' has balance: $' || v_source_balance || ', requested: $' || p_amount);
    END IF;

    -- Update Source Account
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_source_account;

    -- Update Destination Account
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastUpdate = SYSDATE
    WHERE AccountID = p_dest_account;

    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Fund transfer completed successfully.');
    DBMS_OUTPUT.PUT_LINE('Transferred: $' || p_amount || ' from Account ID: ' || p_source_account || ' to Account ID: ' || p_dest_account);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction rolled back. Error in TransferFunds: ' || SQLERRM);
        RAISE;
END;
/
