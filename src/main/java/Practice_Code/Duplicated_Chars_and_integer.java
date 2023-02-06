package Practice_Code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicated_Chars_and_integer {
    public static void main(String[] args) {
//////////////////////////FOR STRING///////////////////////////////////////////////////////////////////////////////
        System.out.println("/////////////////FOR STRING/////////////");
        String a = "aA11";
        System.out.println("String => " + a);
        a=a.toLowerCase();

        String result = "";
        String count = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!result.contains("" + c)) {  //String.valueOf
                result += c;
            } else if (!count.contains("" + c)) {  //String.valueOf
                count += c;
            }
        }

        System.out.println("Distinct characters: " + result);
        System.out.println("Duplicate characters: " + count);
        System.out.println("Count of duplicates: " + count.length());

        System.out.println("////////////////FOR INTEGER//////////////////");
/////////////////////////FOR INTEGER //////////////////////////////////////////////////////////////////////
        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3};
        String result1 = "";
        String count1 = "";
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (!result1.contains(String.valueOf(num))) {
                result1 += num + " ";
            } else if (!count1.contains(String.valueOf(num))) {
                count1 += num + " ";
            }
        }

        System.out.println("Distinct numbers: " + result1);
        System.out.println("Duplicate numbers: " + count1);
        System.out.println("Count of duplicates: " + count1.trim().split(" ").length);
        System.out.println("/////////////////////////Generic Method/////////////////////////////////////////////////////////////");
        /////////////////////////Generic Method//////////////////////////////////////////////////////////////////////
        List<String> list1 = Arrays.asList("aA11", "bB22", "cC33", "aA11");
        System.out.println("Given String in Array"+(list1));
        Map<String, Integer> result4 = getDuplicatesCount(list1);
        System.out.println("For Strings: " + result4);

        List<Integer> list2 = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
        System.out.println("Given Integer in Array"+(list2));
        Map<Integer, Integer> result5 = getDuplicatesCount(list2);
        System.out.println("For Integers: " + result5);


    }

    /////////////////////////Generic Method//////////////////////////////////////////////////////////////////////
    /// I found in internet to make sure that but same logic but with Generic
    public static <T> Map<T, Integer> getDuplicatesCount(List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for (T item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        Map<T, Integer> result = new HashMap<>();
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
    /////////////////////////Stream for String//////////////////////////////////////////////////////////////////////
    public static void countDistinctAndDuplicateChars(String input) {
        Map<Character, Long> charFrequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String distinct = charFrequency.keySet().stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        String duplicates = charFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining());

        System.out.println("Distinct characters: " + distinct);
        System.out.println("Duplicate characters: " + duplicates);
        System.out.println("Count of duplicates: " + duplicates.length());
    }
    /////////////////////////Stream for Integer//////////////////////////////////////////////////////////////////////

    public static void countDistinctAndDuplicateInts(List<Integer> input) {
        Map<Integer, Long> intFrequency = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String distinct = intFrequency.keySet().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        String duplicates = intFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> String.valueOf(entry.getKey()))
                .collect(Collectors.joining(", "));

        System.out.println("Distinct integers: " + distinct);
        System.out.println("Duplicate integers: " + duplicates);
        System.out.println("Count of duplicates: " + duplicates.length());
    }


}
/*
Question-1 Count the number of Duplicated Chars
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example:
"abcde" -> 0 # no characters repeats more than once. "aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`) "indivisibility" -> 1 # 'i' occurs six times.
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice. "aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice.

 */