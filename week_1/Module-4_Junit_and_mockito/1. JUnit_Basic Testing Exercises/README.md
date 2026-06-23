# 1. JUnit Basic Testing Exercises

This folder contains hands-on exercises demonstrating the fundamentals of Java unit testing using **JUnit 4**.

---

## 1. Concepts & Best Practices

### Unit Testing & Assertions
Unit testing isolates components to verify correctness. We use JUnit assertions to compare actual results with expected values:
*   `assertEquals(expected, actual)`: Compares equality.
*   `assertTrue(condition)`: Validates condition is true.
*   `assertFalse(condition)`: Validates condition is false.
*   `assertNull(object)`: Validates reference is null.
*   `assertNotNull(object)`: Validates reference is not null.

### Arrange-Act-Assert (AAA) Pattern
AAA is a layout pattern for unit tests that enhances readability:
1.  **Arrange**: Set up the initial state, parameters, objects, and mocks needed.
2.  **Act**: Invoke the target method being tested.
3.  **Assert**: Check that the output or side effects match expectations.

### Test Fixtures & Lifecycle Hook Annotations
A test fixture is a fixed state of a set of objects used as a baseline for running tests.
*   `@Before`: Methods annotated with `@Before` run before **each** test case. Used to setup/instantiate fixtures (Arrange).
*   `@After`: Methods annotated with `@After` run after **each** test case. Used to clean up resource references to keep tests isolated.

---

## 2. Code Structure & Exercises

*   **Exercise 1 (JUnit Setup)**: Verified via [SettingUpJUnitTest.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/1.%20JUnit_Basic%20Testing%20Exercises/src/test/java/junit/basic/SettingUpJUnitTest.java).
*   **Exercise 3 (Assertions)**: [AssertionsTest.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/1.%20JUnit_Basic%20Testing%20Exercises/src/test/java/junit/basic/AssertionsTest.java) implements basic assertion matches.
*   **Exercise 4 (AAA Pattern & Fixtures)**: [AAAPatternTest.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/1.%20JUnit_Basic%20Testing%20Exercises/src/test/java/junit/basic/AAAPatternTest.java) tests `Calculator.java` methods with setup/teardown methods.

---

## 3. How to Execute Tests

To run the unit tests in this project, run the following Maven command:
```bash
mvn test
```
This will compile the source code and execute all tests, reporting results in the terminal.
