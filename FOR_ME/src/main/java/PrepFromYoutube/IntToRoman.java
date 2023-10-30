package PrepFromYoutube;

import java.util.HashMap;

public class IntToRoman {
    public static void main(String[] args) {

//        System.out.println(RomanToInt("III"));      // Output: 3
//        System.out.println(RomanToInt("LVIII"));    // Output: 58
        System.out.println(RomanToInt("MCMXCIV"));  // Output: 1994
    }

    public static int RomanToInt(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int answer = 0;
        int n = string.length();

        for (int i = 0; i < n; i++) {

            if (i < n - 1 && map.get(string.charAt(i)) < map.get(string.charAt(i + 1))) {
                answer -= map.get(string.charAt(i));
            } else {
                answer += map.get(string.charAt(i));
            }

        }

        return answer;
    }
}
