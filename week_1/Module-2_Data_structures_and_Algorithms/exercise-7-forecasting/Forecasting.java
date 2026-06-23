import java.util.HashMap;
import java.util.Map;

/**
 * Class implementing recursive and optimized forecasting algorithms.
 */
public class Forecasting {

    // Cache for memoized version of future value calculation
    private static Map<Integer, Double> memo = new HashMap<>();

    /**
     * Standard Recursive Approach to calculate future value.
     * Formula: FV = PV * (1 + r)^n
     * Recursion formulation: FV(n) = FV(n-1) * (1 + r)
     * Time Complexity: O(N)
     * Space Complexity: O(N) due to recursion stack depth
     *
     * @param presentValue The starting value (PV).
     * @param growthRate The growth rate per period (r) as a decimal (e.g., 0.05 for 5%).
     * @param years The number of periods/years (n).
     * @return The forecasted future value (FV).
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: If years is 0, the future value is equal to the present value.
        if (years == 0) {
            return presentValue;
        }
        // Recursive step: FV(n) = FV(n-1) * (1 + r)
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    /**
     * Optimized Memoized Recursive Approach.
     * Useful if growth rates vary or if there are multiple calculations for intermediate years
     * that we want to cache to avoid recalculating.
     * Note: For simple geometric progression, a simple loop or direct power formula (Math.pow)
     * is the ultimate O(1) space optimization, which we discuss in analysis.
     *
     * @param presentValue The starting value.
     * @param growthRate The growth rate.
     * @param years The number of years.
     * @return The cached or calculated future value.
     */
    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = calculateFutureValueMemo(presentValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    /**
     * Clear the memoization cache.
     */
    public static void clearCache() {
        memo.clear();
    }
}
