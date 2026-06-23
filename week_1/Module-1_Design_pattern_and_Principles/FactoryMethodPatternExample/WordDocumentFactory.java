/**
 * Concrete Creator class implementing the factory method for Word Documents.
 */
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
