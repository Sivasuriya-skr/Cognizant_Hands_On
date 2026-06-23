import java.util.Arrays;

/**
 * Test class to verify and compare Linear and Binary Search operations.
 */
public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== Testing E-commerce Search Function ===");

        // Setup mock products
        Product[] products = {
            new Product("P105", "Smartphone", "Electronics"),
            new Product("P101", "Laptop", "Electronics"),
            new Product("P103", "Coffee Maker", "Appliances"),
            new Product("P102", "Running Shoes", "Apparel"),
            new Product("P104", "Desk Chair", "Furniture")
        };

        // Linear Search can run on unsorted array
        System.out.println("\n--- Testing Linear Search (Unsorted Array) ---");
        String targetId = "P103";
        System.out.println("Searching for Product ID: " + targetId);
        
        long startTime = System.nanoTime();
        Product foundLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endTime = System.nanoTime();
        
        if (foundLinear != null) {
            System.out.println("Product Found (Linear): " + foundLinear);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");

        // Binary Search requires a sorted array
        System.out.println("\n--- Testing Binary Search (Sorted Array) ---");
        // Sort products by target search key (productId)
        Arrays.sort(products);
        System.out.println("Sorted products for Binary Search:");
        for (Product p : products) {
            System.out.println("  " + p);
        }
        
        System.out.println("Searching for Product ID: " + targetId);
        startTime = System.nanoTime();
        Product foundBinary = SearchAlgorithms.binarySearch(products, targetId);
        endTime = System.nanoTime();

        if (foundBinary != null) {
            System.out.println("Product Found (Binary): " + foundBinary);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");

        // Test non-existing product
        System.out.println("\n--- Testing Non-Existing Product ---");
        String missingId = "P999";
        System.out.println("Searching for non-existent Product ID: " + missingId);
        
        Product missingLinear = SearchAlgorithms.linearSearch(products, missingId);
        System.out.println("Linear Search result: " + (missingLinear == null ? "Not Found" : missingLinear));

        Product missingBinary = SearchAlgorithms.binarySearch(products, missingId);
        System.out.println("Binary Search result: " + (missingBinary == null ? "Not Found" : missingBinary));
        
        System.out.println("\n=== Search Test Completed ===");
    }
}
