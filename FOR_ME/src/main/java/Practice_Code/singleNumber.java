package Practice_Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class singleNumber {
    public static void main(String[] args) {
        int[] num = {2, 2, 1};
        System.out.println(singleNumber(num)); //==> 1


    }

   public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();  // ==>  O(n) => spacy
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {  // 2 => 2 => 1   // ==>  O(n) loop as time
            if (!set.contains(num)) { // 2 => 2
                set.add(num);   // 2 => 1
                uniqueSum += num; // 3
            }
            sum += num; // 2 => 2+2 = 5
        }
        return 2 * uniqueSum - sum; //==>  2*3-5 = 1
    }
        
   

}
