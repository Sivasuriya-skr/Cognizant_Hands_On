package mockito.basic;

/**
 * An interface representing a payment processing system.
 */
public interface PaymentService {
    /**
     * Charges the specified amount to a payment account.
     *
     * @param amount the amount to charge
     */
    void charge(double amount);
}
