package dsa_03_CollectionsReview.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListReview2 {
    public static void main(String[] args) {
        //Convert an Array to ArrayList with Arrays.asList()
        Integer[] arr={1,2,3,4,6};
        List<Integer> list=Arrays.asList(arr);
        ArrayList<Integer> list2=new ArrayList<>(Arrays.asList(arr));

        //Convert an Array to ArrayList with Collections.addAll()
        List<Integer> list3=new ArrayList<>();
        Collections.addAll(list3, arr);
        System.out.println(list3);


        //convert an ArrayList to Array
        Integer[] arr2=list3.toArray((new Integer[0]));



        //convert an ArrayList to Array using streams
        int[] arr3=list3.stream().mapToInt(i->i).toArray();

        // Sort without comparator


        // Binary Search on collections





    }
}
