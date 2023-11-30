package PrepFromYoutube;

import java.util.Arrays;
import java.util.Comparator;
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


    public int[] twoSumHashMapApproach(int[] nums, int target) {
            Map <Integer,Integer> map = new HashMap<>();
            for(int i = 0; i<nums.length;i++){
                int answer = target - nums[i];
                if(map.containsKey(answer)){
                    return new int[]{map.get(answer),i};
                }
                map.put(nums[i],i);
            }
            return new int[]{};
        }

    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{}; // No solution found!
    }
    public int[] twoSumTwoPointerApproach(int[] nums, int target) {
        int[][] numsWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsWithIndex[i][0] = nums[i];
            numsWithIndex[i][1] = i;
        }


        Arrays.sort(numsWithIndex, Comparator.comparingInt(arr -> arr[0]));
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // No solution found!
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