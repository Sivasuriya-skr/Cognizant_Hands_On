/**
 * Concrete Creator class implementing the factory method for PDF Documents.
 */
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
