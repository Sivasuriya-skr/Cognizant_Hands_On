SET SERVEROUTPUT ON;

DECLARE
CURSOR c_customers IS
SELECT CustomerID, Name, DOB
FROM Customers;

v_age NUMBER;

BEGIN
DBMS_OUTPUT.PUT_LINE('Applying discount...');

FOR cust IN c_customers LOOP

    v_age :=
    TRUNC(MONTHS_BETWEEN(SYSDATE,cust.DOB)/12);

    IF v_age > 60 THEN

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            cust.Name ||
            ' Age=' || v_age ||
            ' => 1% Discount Applied'
        );

    END IF;

END LOOP;

COMMIT;

END;
/
