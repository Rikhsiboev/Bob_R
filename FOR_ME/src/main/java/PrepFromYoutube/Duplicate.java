package PrepFromYoutube;

import java.util.*;
import java.util.stream.Collectors;

public class Duplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicateSet(nums1));
        System.out.println(containsDuplicateSet(nums2));
        System.out.println(containsDuplicateSet(nums3));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateHashMap(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            if (hashMap.containsKey(nums[i])) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsDuplicateSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }

    public static boolean containsDuplicateWithStream(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .size() != nums.length;
    }

    public static boolean containsDuplicateWithStreamDistinct(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .count()< nums.length;
    }

    public static boolean containsDuplicateWithStreamHashSet(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num->!hashSet.add(num));
    }

    public static List<Integer> findDuplicateWithStream(int [] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> listDuplicates = new ArrayList<>();
        Arrays.stream(nums)
                .filter(num->!hashSet.add(num))
                .forEach(listDuplicates::add);
        return listDuplicates;
    }


}
