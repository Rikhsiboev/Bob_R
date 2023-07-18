import java.util.HashMap;
import java.util.Map;

public class LotteryCoupon {
    public static int lotteryCoupons(int n) {
        Map<Integer, Integer> sumFreq = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Sum Frequencies: " + sumFreq);

        int maxWinners = 0;
        int maxWinnersCount = 0;

        for (int freq : sumFreq.values()) {
            if (freq > maxWinners) {
                maxWinners = freq;
                maxWinnersCount = 1;
            } else if (freq == maxWinners) {
                maxWinnersCount++;
            }
        }

        System.out.println("Max Winners: " + maxWinners);
        System.out.println("Max Winners Count: " + maxWinnersCount);

        return maxWinnersCount;
    }

    private static int getDigitSum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 12;
        int result = lotteryCoupons(n);
        System.out.println("Number of values of s: " + result);
    }
}
