package junit.basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit.
 * This class demonstrates the lifecycle methods and a structured approach to writing unit tests.
 */
public class AAAPatternTest {

    // Test Fixture object
    private Calculator calculator;

    /**
     * Setup method annotated with @Before.
     * Runs before each test to prepare the environment and initialize the test fixture.
     */
    @Before
    public void setUp() {
        System.out.println("  [Before] Initializing Calculator fixture...");
        
        // Arrange phase (setting up the preconditions/objects)
        calculator = new Calculator();
    }

    /**
     * Teardown method annotated with @After.
     * Runs after each test to clean up the test environment resources.
     */
    @After
    public void tearDown() {
        System.out.println("  [After] Cleaning up Calculator fixture...");
        calculator = null;
    }

    /**
     * Test case showing the AAA pattern for addition.
     */
    @Test
    public void testAdditionAAA() {
        System.out.println("    [Test] Running testAdditionAAA...");

        // 1. Arrange: Done in setUp() by creating the calculator instance
        int number1 = 20;
        int number2 = 10;

        // 2. Act: Execute the method under test
        int result = calculator.add(number1, number2);

        // 3. Assert: Validate the outcome
        assertEquals(30, result);
    }

    /**
     * Test case showing the AAA pattern for subtraction.
     */
    @Test
    public void testSubtractionAAA() {
        System.out.println("    [Test] Running testSubtractionAAA...");

        // 1. Arrange: Done in setUp(). Define test inputs:
        int number1 = 20;
        int number2 = 10;

        // 2. Act: Execute subtraction
        int result = calculator.subtract(number1, number2);

        // 3. Assert: Validate that 20 - 10 equals 10
        assertEquals(10, result);
    }
}
