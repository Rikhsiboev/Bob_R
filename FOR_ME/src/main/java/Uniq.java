import java.util.*;

public class Uniq {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqOrNot(array));
    }

    private static boolean uniqOrNot(Integer[] array) {
        // using Hashmap<Integer,Integer> (Elements,freq)
        Map<Integer, Integer> freq = new HashMap<>();
        // count number and put all i to freq
        for (int i : array) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);//=> in table i KEY => value i Value and i+1
        }
        // put the freq in the set find if there are duplicate value

        Set<Integer> freqSet = new HashSet<>();
        for (int valueJ : freq.values()) {
            if (!freqSet.add(valueJ)) {
                return false;
            }
        }
        return true;
    }
}
