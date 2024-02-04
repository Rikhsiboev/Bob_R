package PrepFromYoutube;

import java.util.*;

/*
15. 3Sum
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class Two_Sum_3 {
    public static void main(String[] args) {
       int[] nums = {-1,0,1,2,-1,-4};
//       int[] nums1 = {0,1,1};
//       int[] nums2 = {0,0,0};

        System.out.println(threeSum(nums));
//        System.out.println(threeSum(nums1));
//        System.out.println(threeSum(nums2));

    }


    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();

        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    ArrayList<Integer> sp = new ArrayList<>();
                    sp.add(nums[i]);
                    sp.add(nums[left]);
                    sp.add(nums[right]);
                    answer.add(sp);
                    left++;
                } else if (sum<0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return new ArrayList<>(answer);
    }

}
