/**
 * Class containing static methods for Linear Search and Binary Search.
 */
public class SearchAlgorithms {

    /**
     * Linear Search implementation.
     * Iterates through the array and compares each element with the target product ID.
     * Time Complexity: O(N)
     *
     * @param products The array of products.
     * @param targetId The product ID to search for.
     * @return The Product if found, otherwise null.
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product != null && product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search implementation.
     * Works on sorted arrays by repeatedly dividing the search interval in half.
     * Time Complexity: O(log N)
     *
     * @param products The sorted array of products.
     * @param targetId The product ID to search for.
     * @return The Product if found, otherwise null.
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid]; // Found the product
            } else if (comparison < 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return null; // Product not found
    }
}
