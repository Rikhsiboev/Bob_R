package PrepFromYoutube;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Two_Sum {

    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(array1, target1)));
        int[] array2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(array2, target2)));
        int[] array3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(array3, target3)));

        System.out.println("---------Stream------------------");

        System.out.println(Arrays.toString(streamOfTwoSum(array1, target1)));
        System.out.println(Arrays.toString(streamOfTwoSum(array2, target2)));
        System.out.println(Arrays.toString(streamOfTwoSum(array3, target3)));

        System.out.println("---------Map------------------");

        System.out.println(Arrays.toString(twoSumWithHashMap(array1, target1)));
        System.out.println(Arrays.toString(twoSumWithHashMap(array2, target2)));
        System.out.println(Arrays.toString(twoSumWithHashMap(array3, target3)));
    }

    public static int[] streamOfTwoSum(int[] arrays, int target) {
        return IntStream.range(0, arrays.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, arrays.length)
                        .filter(j -> arrays[i] + arrays[j] == target)
                        .mapToObj(k -> new int[]{i, k}))
                .findFirst()
                .orElse(new int[2]);
    }

    public static int[] twoSum(int[] array, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + array[i + 1] == target) {
                answer[0] = i;
                answer[1] = i + 1;
            }
        }
        return answer;
    }

    public static int[] twoSumWithHashMap(int[] array, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i <array.length ; i++) {
            int diff = target-array[i];
            if (map.containsKey(diff)){
                answer[0]= map.get(diff);
                answer[1]=i;
                return answer;
            }
            map.put(array[i],i);
        }
        return answer;
    }
}
/**
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */