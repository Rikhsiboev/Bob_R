package Practice_Code;

import java.util.function.Function;

public class SumAllNumbersAsString {
    public static void main(String[] args) {
        /// 1) Interface Function public interface Function<T, R>
        /// 2) Lambda
        /// 3) For each loop for String to find
        ///    a) trim remove all space text from front and back
        ///    b) Split separate all " " space to get as array
        ///    c) to find each Char of String as Index For loop
        ///    d) Character.isDigit  inbuilt method with String method chartAt
        ///    e) if from String we get digit, and we're comparing with String by ?  Integer.valueOf(s) : 0



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
                                            // wrapped class with valueOf method
                sum += (count == s.length()) ? Integer.valueOf(s) : 0;
            }
            return sum;
        };

        System.out.println(sumOfAllIntegers.apply("12 some text 35    7 445"));
    }
}
