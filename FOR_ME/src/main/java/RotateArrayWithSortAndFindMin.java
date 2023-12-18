public class RotateArrayWithSortAndFindMin {
    public static void main(String[] args) {
        // Test cases
//        int[] nums0 = {};
//        int[] nums1 = {1};
//        int[] nums2 = {8, 2};
//        int[] nums3 = {7, 9, 10, 25, 45};
//        int[] nums4 = {3, 4, 5, 1, 2}; // Rotated sorted array
//        int[] nums5 = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums6 = {11, 13, 15, 17};
       int[] nums7 = {11, 15,4,8,5, 17};

//        int result0 = findMinSortedArrayWithBinary(nums0);
//        int result1 = findMinSortedArrayWithBinary(nums1);
//        int result2 = findMinSortedArrayWithBinary(nums2);
//        int result3 = findMinSortedArrayWithBinary(nums3);
//        int result4 = findMinSortedArrayWithBinary(nums4);
//        int result5 = findMinSortedArrayWithBinary(nums5);
//        int result6 = findMinSortedArrayWithBinary(nums6);
        int result7 = findMinSortedArrayWithBinary(nums7);

//        System.out.println("Result for nums1: " + result0); // Expected output: -1
//        System.out.println("Result for nums1: " + result1); // Expected output: 1
//        System.out.println("Result for nums2: " + result2); // Expected output: 2
//        System.out.println("Result for nums3: " + result3); // Expected output: 7
//        System.out.println("Result for nums4: " + result4); // Expected output: 1
//        System.out.println("Result for nums4: " + result5); // Expected output: 0
//        System.out.println("Result for nums4: " + result6); // Expected output: 11
        System.out.println("Result for nums4: " + result7); // Expected output:
    }

    public static int findMinSortedArrayWithBinary(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) {
            return -1; // Return an invalid value or handle it as needed
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else { // Handling the case when nums[mid] == nums[right]
                right--; // Decrement right pointer to avoid duplicate elements
            }
        }
        return nums[left]; // For an invalid input or edge case
    }
}
