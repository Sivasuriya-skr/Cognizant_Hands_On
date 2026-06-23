/**
 * Test class to verify the recursive Financial Forecasting algorithm.
 */
public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Financial Forecasting ===");

        double presentValue = 1000.00; // Starting capital
        double growthRate = 0.05;      // 5% annual growth rate
        int years = 15;                // Forecast period in years

        System.out.println("Starting Capital: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + years + " years");

        // 1. Calculate future value using standard recursion
        System.out.println("\n--- Standard Recursive Calculation ---");
        long startTime = System.nanoTime();
        double futureValue = Forecasting.calculateFutureValue(presentValue, growthRate, years);
        long endTime = System.nanoTime();

        System.out.printf("Future Value after %d years: $%.2f%n", years, futureValue);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");

        // Print year by year projection to show progression
        System.out.println("\nYear-by-Year Forecast Projection:");
        for (int i = 0; i <= years; i += 3) {
            if (i == 0) continue;
            double val = Forecasting.calculateFutureValue(presentValue, growthRate, i);
            System.out.printf("  Year %2d: $%.2f%n", i, val);
        }

        // 2. Calculate future value using optimized memoization
        System.out.println("\n--- Memoized Recursive Calculation ---");
        Forecasting.clearCache();
        startTime = System.nanoTime();
        double futureValueMemo = Forecasting.calculateFutureValueMemo(presentValue, growthRate, years);
        endTime = System.nanoTime();

        System.out.printf("Future Value (Memoized) after %d years: $%.2f%n", years, futureValueMemo);
        System.out.println("Execution Time (with caching): " + (endTime - startTime) + " ns");

        System.out.println("\n=== Financial Forecasting Test Completed ===");
    }
}
