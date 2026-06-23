DECLARE
    -- Cursor to iterate through all customers
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance, IsVIP
        FROM Customers;
    
    v_updated_count NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting VIP Status Updates ---');

    FOR r_cust IN c_customers LOOP
        -- Check if balance is over $10,000
        IF r_cust.Balance > 10000.00 THEN
            -- Check if customer is not already VIP to avoid redundant updates
            IF r_cust.IsVIP IS NULL OR r_cust.IsVIP <> 'TRUE' THEN
                UPDATE Customers
                SET IsVIP = 'TRUE'
                WHERE CustomerID = r_cust.CustomerID;
                
                DBMS_OUTPUT.PUT_LINE('Customer: ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ') promoted to VIP. Balance: $' || r_cust.Balance);
                v_updated_count := v_updated_count + 1;
            END IF;
        END IF;
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updates completed. Total customers promoted: ' || v_updated_count);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred during processing: ' || SQLERRM);
END;
/
