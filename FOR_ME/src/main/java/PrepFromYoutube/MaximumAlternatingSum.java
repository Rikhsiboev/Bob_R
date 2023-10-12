package PrepFromYoutube;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumAlternatingSum {
    public static void main(String[] args) {
        int[] nums1 = {4, 2, 5, 3};  /// 7
        // (4+5)-(2+3)=> 9 - 5 => 7
        int[] nums2 = {5, 6, 7, 8};  /// 8
        // (5+7)-(6+8)= 12-14=>2 =>
        int[] nums3 = {6, 2, 1, 2, 4, 5};  /// 10
        System.out.println(streamSumMax(nums1));
    }

    public static int maximumAlternatingSum(int[] sum) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < sum.length; i++) {
            even = Math.max(odd + sum[i], even);
            odd = even - sum[i];
        }
        return even;
    }

    public static int streamSumMax(int[] nums) {
        int evenSum = IntStream.range(0, nums.length)
                .filter(i -> i % 2 == 0)
                .map(i -> nums[i])
                .sum();

        int oddSum = IntStream.range(0, nums.length)
                .filter(i -> i % 2 != 0)
                .map(i -> nums[i])
                .sum();

        return Math.max(oddSum - evenSum, 0);
    }
}
