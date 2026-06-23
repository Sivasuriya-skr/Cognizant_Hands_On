CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) IS
    v_updated_rows NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Starting UpdateEmployeeBonus Stored Procedure ---');
    
    -- Input Validation
    IF TRIM(p_department) IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Department name cannot be null or empty.');
    END IF;
    
    IF p_bonus_percentage IS NULL OR p_bonus_percentage < 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Bonus percentage must be a non-negative number.');
    END IF;

    -- Update salary of employees in a given department by adding a bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    
    v_updated_rows := SQL%ROWCOUNT;
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Employee bonus update completed.');
    DBMS_OUTPUT.PUT_LINE('Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Bonus applied: ' || p_bonus_percentage || '%');
    DBMS_OUTPUT.PUT_LINE('Employees updated: ' || v_updated_rows);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction rolled back. Error in UpdateEmployeeBonus: ' || SQLERRM);
        RAISE;
END;
/
