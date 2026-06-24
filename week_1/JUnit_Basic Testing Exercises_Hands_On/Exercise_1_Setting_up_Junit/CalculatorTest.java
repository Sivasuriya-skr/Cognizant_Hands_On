import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {

        Calculator calc = new Calculator();

        int result = calc.add(10, 20);

        assertEquals(30, result);
    }
}