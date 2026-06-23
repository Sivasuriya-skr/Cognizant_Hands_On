DECLARE
    -- Cursor to loop through all customers
    CURSOR c_customers IS
        SELECT CustomerID, Name, DOB
        FROM Customers;
    
    v_age NUMBER;
    v_updated_count NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting Loan Interest Discount Processing ---');

    FOR r_cust IN c_customers LOOP
        -- Calculate current age based on Date of Birth
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12);
        
        -- Check if customer age is above 60
        IF v_age > 60 THEN
            -- Apply a 1% discount to their current loan interest rates
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = r_cust.CustomerID;
            
            -- If any loan was updated, log and increment the counter
            IF SQL%ROWCOUNT > 0 THEN
                DBMS_OUTPUT.PUT_LINE('Customer: ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ', Age: ' || v_age || ') - Applied 1% discount to loan(s).');
                v_updated_count := v_updated_count + SQL%ROWCOUNT;
            END IF;
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rate discount process completed. Total loans updated: ' || v_updated_count);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred during processing: ' || SQLERRM);
END;
/
