import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        System.out.println("Setup Method Executed");
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {

        // Arrange
        int num1 = 10;
        int num2 = 20;

        // Act
        int result = calculator.add(num1, num2);

        // Assert
        assertEquals(30, result);

        System.out.println("Test Executed Successfully");
    }

    @After
    public void teardown() {
        System.out.println("Teardown Method Executed");
        calculator = null;
    }
}