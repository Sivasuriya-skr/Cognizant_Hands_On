package mockito.basic;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 * Exercise 6: Verifying Interaction Order.
 * Demonstrates how to verify that mock methods are called in a specific order.
 */
public class OrderVerificationTest {

    @Test
    public void testOrderOfInteractions() {
        // 1. Create mock objects
        PaymentService mockPayment = mock(PaymentService.class);
        ShippingService mockShipping = mock(ShippingService.class);

        OrderService orderService = new OrderService(mockPayment, mockShipping);

        // 2. Call the methods in a specific order (Payment then Shipping)
        orderService.processOrder("Premium Laptop", 1500.00);

        // 3. Verify the interaction order
        // Create an InOrder verifier passing the mocks whose execution order needs validation
        InOrder inOrder = inOrder(mockPayment, mockShipping);

        // Assert that charge was called before ship
        inOrder.verify(mockPayment).charge(1500.00);
        inOrder.verify(mockShipping).ship("Premium Laptop");
    }
}
