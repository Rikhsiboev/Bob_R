package PrepInterview.array;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Largest_Range {
    public static void main(String[] args) {

        int[] myArray = new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(Arrays.toString(largestRange(myArray)));
    }

    public static int[] largestRange(int[] myArray) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int longRange = 0;
        for (int num : myArray) {
            set.add(num);
        }

        for (int num : myArray) {

            int left = num - 1;
            int right = num + 1;
            int currentLength = 1;
            set.remove(num);

            while (set.contains(left)){
                currentLength++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)){
                currentLength++;
                set.remove(right);
                right++;
            }
            if (currentLength>longRange){
                result[0]=left+1;
                result[1]=right-1;
                longRange=currentLength;
            }
        }

        return result;
    }


}
