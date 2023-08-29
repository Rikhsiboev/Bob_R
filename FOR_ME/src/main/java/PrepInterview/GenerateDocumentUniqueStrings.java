package PrepInterview;

import java.util.*;

public class GenerateDocumentUniqueStrings {
    public static void main(String[] args) {
        String characters = "abcabc";
        String document = "aabbcc";
        System.out.println(generateDocuments(characters, document));
    }

    public static boolean generateDocuments(String characters, String document) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < document.length(); i++) {
            char charAt = document.charAt(i);
            if (!map.containsKey(charAt) || map.get(charAt) == 0){
                return false;
            }
            map.put(charAt, map.get(charAt)-1);
        }
        return true;
    }
}







