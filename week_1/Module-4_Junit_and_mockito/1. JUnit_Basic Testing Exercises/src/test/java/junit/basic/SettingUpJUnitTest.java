package junit.basic;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Exercise 1: Setting Up JUnit.
 * This class serves as the initial test file to verify JUnit compilation and environment setup.
 */
public class SettingUpJUnitTest {

    @Test
    public void testJUnitSetup() {
        System.out.println("Executing SettingUpJUnitTest - JUnit is correctly configured!");
        // A simple assertion that is guaranteed to pass to verify that JUnit runs.
        assertTrue("JUnit environment should be successfully configured.", true);
    }
}
