package PrepInterview.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arrays = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(RemoveDuplicatesFromFirstFiveSortedArray(arrays));

        int[] ints = Arrays.stream(arrays).distinct().toArray();
        long count = Arrays.stream(ints).count();

        System.out.println(Arrays.toString(ints));
        System.out.println(count);

    }
    public static int RemoveDuplicatesFromFirstFiveSortedArray(int[] arrays) {

        if (arrays.length == 0) {
            return 0;
        }
        int addingPoint = 1;
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] != arrays[i - 1]) {
                arrays[addingPoint] = arrays[i];

                addingPoint++;
            }
            /*
               array => 0 0 1 1 1 2 2 3 3 4
               index => 0 1 2 3 4 5 6 7 8 9 => this was my i
               timesOfIndex    array[i] != array[i-1] logic
               1) 1 != 0-0  =>   pass k++   -> 1
               2) 1 != 0-1  =>   fail
               3) 1 != 1  =>   fail
               4) 1 != 1  =>   fail
               5) 2 != 1  =>   pass k++    -> 1
               6) 2 != 2  =>   fail
               7) 3 != 2  =>   pass k++    -> 1
               8) 3 != 3  =>   fail
               8) 4 != 3  =>   pass k++    -> 1

            */
        }
        return addingPoint;
    }
}


//given array as sorted, and we have to remove duplicates
// case array can be empty => so we have to start from 1