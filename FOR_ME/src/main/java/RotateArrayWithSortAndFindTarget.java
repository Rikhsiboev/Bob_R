public class RotateArrayWithSortAndFindTarget {

    public int search(int[] nums, int target) {

        int n = nums.length - 1;
        int left = 0;
        int right = n;
        int mid = 0;

        while (left < right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    return right = mid - 1;
                } else {
                    return left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target < nums[right]) {
                    return left = mid + 1;
                } else {
                    return right = mid - 1;
                }
            }
        }
        return -1;
    }
}


