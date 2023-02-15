package Practice_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxOfArray {
    public static void main(String[] args) {

        //  I used Collections.max() to get the max value of an array
        //  I convert to a list
        // loop to add all the numbers in the list to a list
        // I use Collections.max() to get the max value of an array
        int[] array = {6, 8, 3, 5, 1, 9};
        System.out.println("Given array " + Arrays.toString(array));
        ///////////////
        System.out.println("---------Convert to list > loop to add > Collection.max method--------");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        System.out.println("Collections.max " + Collections.max(list));
        ///////////////
        System.out.println("---------loop for > int max = 0 > add to max--------");
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Max " + max);
        ///////////////
        System.out.println("---------Arrays.stream(array).max().ifPresent(p-> System.out.println(\"Stream of max  \" + p)--------");
        Arrays.stream(array)
                .max()
                .ifPresent(p-> System.out.println("Stream of max  " + p));


    }
}
