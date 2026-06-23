/**
 * Concrete Creator class implementing the factory method for Excel Documents.
 */
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
