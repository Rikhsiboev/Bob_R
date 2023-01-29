package Practice_Code;

import java.util.function.Function;

public class SumAllNumbersAsString {
    public static void main(String[] args) {
        // interface with 2 <T,I> name              lambda
        Function<String, Integer> sumOfAllIntegers = p -> {
            // for get final result
            Integer sum = 0;

            // for each loop                        from sting find each element
            for (String s : p.trim().replaceAll("\\s+", " ").split(" ")) {

                int count = 0;

                for (int i = 0; i < s.length(); i++) {
                                            // finding digit in String
                    count += (Character.isDigit(s.charAt(i))) ? 1 : 0;
                }

                sum += (count == s.length()) ? Integer.valueOf(s) : 0;
            }
            return sum;
        };

        System.out.println(sumOfAllIntegers.apply("12 some text 35    7 445"));
    }
}
