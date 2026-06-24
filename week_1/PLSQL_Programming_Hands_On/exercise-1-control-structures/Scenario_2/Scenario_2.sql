SET SERVEROUTPUT ON;

DECLARE
CURSOR c_customers IS
SELECT CustomerID,
Name,
Balance
FROM Customers;
BEGIN


FOR cust IN c_customers LOOP

    IF cust.Balance > 10000 THEN

        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            cust.Name ||
            ' promoted to VIP'
        );

    END IF;

END LOOP;

COMMIT;


END;
/
