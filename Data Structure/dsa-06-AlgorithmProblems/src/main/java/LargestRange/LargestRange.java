package LargestRange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static void main(String[] args) {
        int [] myArray=new int[]{6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(largestRange(myArray)));
    }
    public static int[] largestRange(int[] array) {
        int[] bestRange=new int[2]; // first field is starting value, second is the end value of the range
        int longestRange=0;
        Map<Integer,Boolean> numsMap=new HashMap<>();
        // true means not visited yet
        for (int i : array) {
           numsMap.put(i,true);
        }
        for (int i : array) {
            if(!numsMap.get(i)) continue;
            // this part means that element is not visited yet
            int currentLength=1;
            int left=i-1;
            int right =i+1;
            // find the left edge of this current value i
            while(numsMap.containsKey(left)){
                numsMap.put(left,false);
                currentLength++;
                left--;
            }
            // find the right edge of this current value i
            while(numsMap.containsKey(right)){
                numsMap.put(right,false);
                currentLength++;
                right++;
            }
            //
            if(currentLength>longestRange){
                longestRange=currentLength;
                bestRange=new int[]{left+1,right-1};
            }
        }
       return bestRange;
    }
}
