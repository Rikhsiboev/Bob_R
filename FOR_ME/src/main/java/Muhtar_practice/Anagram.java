package Muhtar_practice;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String str1="heart";
        String str2="earth";
        System.out.println(anagram(str1,str2));
    }

    public static String anagram(String str1,String str2){
        String anagram="";
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (Arrays.equals(chars1,chars2)){
            anagram="anagram";
        }else {
            anagram="not anagram";
        }
        return anagram;
    }
}
