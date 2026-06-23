/**
 * Abstract Creator class defining the Factory Method.
 */
public abstract class DocumentFactory {
    // The Factory Method that concrete subclasses will implement
    public abstract Document createDocument();

    /**
     * Helper operation that demonstrates how the factory method is used.
     * The creator's primary responsibility is NOT creating products. Usually, it contains
     * some core business logic that relies on Product objects returned by the factory method.
     */
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}
