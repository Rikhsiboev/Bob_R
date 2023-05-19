package Roman2Integer;

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    public static void main(String[] args) {
        System.out.println(romanToInteger("CMXCIV"));
    }

    static int romanToInteger(String s) {
        // ("M", 1000); ("D", 500);("C", 100);("L", 50);("X", 10);("V", 5);("I", 1);
        // Map for Roman Numerals
        Map<String,Integer> values=new HashMap<>();
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
        int sum=0;
        int i=0;
        while(i<s.length()){
            String currentSymbol=s.substring(i,i+1);
            int currentValue=values.get(currentSymbol);
            int nextValue=0;
            if(i+1<s.length()){
                String nextSymbol=s.substring(i+1,i+2);
                nextValue=values.get(nextSymbol);
            }
            if (currentValue<nextValue){
                sum+=(nextValue-currentValue);
                // make a double jump - Both exp evaluated
                i+=2;
            }
            else {
                sum+=currentValue;
                i++;
            }

        }


        return sum;
    }
}
