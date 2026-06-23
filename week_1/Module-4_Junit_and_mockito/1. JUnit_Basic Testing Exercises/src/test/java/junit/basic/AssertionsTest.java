package junit.basic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 3: Assertions in JUnit.
 * This class demonstrates various assertion methods provided by JUnit to validate conditions.
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        System.out.println("Executing AssertionsTest - Testing various JUnit assertions.");

        // Assert equals - verifies that two values are equal
        assertEquals(5, 2 + 3);
 
        // Assert true - verifies that a condition is true
        assertTrue(5 > 3);
 
        // Assert false - verifies that a condition is false
        assertFalse(5 < 3);
 
        // Assert null - verifies that an object reference is null
        assertNull(null);
 
        // Assert not null - verifies that an object reference is not null
        assertNotNull(new Object());
    }
}
