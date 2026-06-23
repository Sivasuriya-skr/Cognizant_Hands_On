package mockito.basic;

/**
 * An interface representing a shipping/logistics system.
 */
public interface ShippingService {
    /**
     * Ships the specified item to a customer.
     *
     * @param item the item to ship
     */
    void ship(String item);
}
