
public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern (Document Management System) ===");

        System.out.println("\n--- Creating Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println("\n--- Creating PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println("\n--- Creating Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\n--- Testing Document Factory Processing Pipeline ---");
        System.out.println("Using wordFactory processDocument():");
        wordFactory.processDocument();

        System.out.println("\nUsing pdfFactory processDocument():");
        pdfFactory.processDocument();

        System.out.println("\nUsing excelFactory processDocument():");
        excelFactory.processDocument();

        System.out.println("\n=== Factory Method Pattern Test Completed ===");
    }
}
