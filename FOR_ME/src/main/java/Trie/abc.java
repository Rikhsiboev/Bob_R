package Trie;

import java.util.HashSet;
import java.util.Set;

public class abc {
    public static void main(String[] args) {
        String abc = "abcdeff";

        Set<Character> unq=new HashSet<>();
        Set<Character> dub=new HashSet<>();
        Set<Character> nondub=new HashSet<>();

        for (char c: abc.toCharArray()) {
            if (!unq.add(c)){
                dub.add(c);
            }
        }
        for (char c: abc.toCharArray()) {
            if (!dub.contains(c)){
                nondub.add(c);
            }
        }
        System.out.println("original " +abc);
        System.out.println("uniq"+unq);
        System.out.println("dub"+dub);
        System.out.println("non"+nondub);




    }
}
