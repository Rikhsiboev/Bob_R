package Muhtar_practice;

public class UniqueCharacters {
    public static void main(String[] args) {
        String str = "aabccdee";
        System.out.println(uniqueCh(str));
    }

    public static String uniqueCh(String str) {
        String uniques = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                uniques += ch;
            }
        }
        return uniques;
    }


}
