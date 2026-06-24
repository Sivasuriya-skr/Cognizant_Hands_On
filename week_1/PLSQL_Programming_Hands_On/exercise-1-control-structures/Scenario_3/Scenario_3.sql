SET SERVEROUTPUT ON;

DECLARE

    CURSOR c_loans IS
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE
                            AND SYSDATE + 30;

BEGIN

    FOR loan_rec IN c_loans LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || loan_rec.Name
            || ', Loan '
            || loan_rec.LoanID
            || ' is due on '
            || TO_CHAR(
                   loan_rec.EndDate,
                   'DD-MON-YYYY'
               )
        );

    END LOOP;

END;
/