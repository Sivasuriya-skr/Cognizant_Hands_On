import java.util.HashMap;
import java.util.Map;

public class Forecasting {

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        
        if (years == 0) {
            return presentValue;
        }
        
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

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

    public static void clearCache() {
        memo.clear();
    }
}
