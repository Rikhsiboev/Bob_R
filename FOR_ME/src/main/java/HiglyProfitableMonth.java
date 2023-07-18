import java.util.List;

public class HiglyProfitableMonth {
    public static void main(String[] args) {
        int[] stockPrices = { 5, 3, 5, 7, 8, 10};
        int k = 3;
        int result = highlyProfitableIntervals(stockPrices, k);
        System.out.println(result);
    }
    public static int highlyProfitableIntervals( int[] stockPrices, int k) {
//        int n = stockPrices.length;
//        int[] stockPrices = { 5, 3, 5, 7, 8 };
        int count = 0;
        for (int i = 0; i <= stockPrices.length - k; i++) {
            boolean isIncreasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (stockPrices[j] >= stockPrices[j + 1]) {
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing) {
                count++;
            }
        }
        return count;
    }
}
