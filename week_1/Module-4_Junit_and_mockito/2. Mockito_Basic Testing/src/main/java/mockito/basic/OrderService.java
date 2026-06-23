package mockito.basic;

/**
 * A service class responsible for processing orders.
 * It coordinates payment charging and item shipping.
 */
public class OrderService {
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    /**
     * Constructs OrderService with required collaborators.
     *
     * @param paymentService  the payment collaborator
     * @param shippingService the shipping collaborator
     */
    public OrderService(PaymentService paymentService, ShippingService shippingService) {
        this.paymentService = paymentService;
        this.shippingService = shippingService;
    }

    /**
     * Processes an order. The payment must be charged before the item is shipped.
     *
     * @param item  the item name
     * @param price the price of the item
     */
    public void processOrder(String item, double price) {
        // Step 1: Charge the customer
        paymentService.charge(price);

        // Step 2: Ship the item
        shippingService.ship(item);
    }
}
