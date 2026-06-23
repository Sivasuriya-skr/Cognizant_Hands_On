# 2. Mockito Basic Testing

This folder contains exercises demonstrating how to use **Mockito** with **JUnit 5** to write isolated unit tests by mocking external system dependencies.

---

## 1. Concepts & Best Practices

### Mocking vs. Stubbing
*   **Mocking**: Creating dummy implementations of interfaces or classes (`mock(Class.class)`). This allows us to test the target class in complete isolation, without relying on actual databases, APIs, or complex subsystems.
*   **Stubbing**: Configuring the mock objects to return preset values when specific methods are called (`when(mock.method()).thenReturn(value)`).

### Interaction Order Verification
In many business flows, executing operations in the correct order is a critical constraint. For example, a customer's credit card must be charged *before* a physical item is shipped.
*   We use Mockito's `InOrder` verification API to enforce execution sequences:
    ```java
    InOrder inOrder = inOrder(mockA, mockB);
    inOrder.verify(mockA).firstMethod();
    inOrder.verify(mockB).secondMethod();
    ```

---

## 2. Code Structure & Exercises

*   **Exercise 1 (Mocking and Stubbing)**: [MyServiceTest.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/test/java/mockito/basic/MyServiceTest.java) mocks [ExternalApi.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/main/java/mockito/basic/ExternalApi.java) and stubs `.getData()` to test [MyService.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/main/java/mockito/basic/MyService.java).
*   **Exercise 6 (Interaction Order)**: [OrderVerificationTest.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/test/java/mockito/basic/OrderVerificationTest.java) verifies that [OrderService.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/main/java/mockito/basic/OrderService.java) calls [PaymentService.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/main/java/mockito/basic/PaymentService.java) before [ShippingService.java](file:///d:/CTS_HANDS_ON/week_1/Module-4_Junit_and_mockito/2.%20Mockito_Basic%20Testing/src/main/java/mockito/basic/ShippingService.java).

---

## 3. How to Execute Tests

To run the Mockito unit tests, run the following Maven command:
```bash
mvn test
```
This will run all test suites under the JUnit 5 platform engine.
