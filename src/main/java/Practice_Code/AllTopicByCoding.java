package Practice_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTopicByCoding {
    public static void main(String[] args) {


        // From array to ArrayList
        String[] arr = {"Java", "C#", "Python", "PHP"};
        Integer[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4};
        /////////////////////////////
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        /////////////////////////////
        //Create a new ArrayList
        List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));   // List only accept Integer Wrapped classes

        //Create a new Array
        String [] newArr = list.toArray(new String[list.size()]);
        Integer[] newArray =list.toArray(new Integer[list2.size()]);

        /////////////////////////////
        //if i need sort use Arrays.sort()
        //from collections.sort()





    }
}
