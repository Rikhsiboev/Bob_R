package Practice_Code;

import java.util.function.Function;

public class AnimalFeast {
    public static void main(String[] args) {

        String str1 = "chickadee";
        String str2 = "chocolate";

        str1.trim().replaceAll("\\s+", " ");
        str2.trim().replaceAll("\\s+", " ");

        char animal = str1.charAt(0);
        char food = str2.charAt(0);
        char animal1 = str1.charAt(str1.length() - 1);
        char food1 = str2.charAt(str2.length() - 1);

        boolean answer = (animal == food && animal1 == food1) ? true : false;
        System.out.println(answer);


    }

    public static boolean methodWithAnimalAndDish(String str1, String str2) {
        str1.trim().replaceAll("\\s+", " ");
        str2.trim().replaceAll("\\s+", " ");
        char animal = str1.charAt(0);
        char food = str2.charAt(0);
        char animal1 = str1.charAt(str1.length() - 1);
        char food1 = str2.charAt(str2.length() - 1);
        boolean answer;
        return answer = (animal == food && animal1 == food1) ? true : false;
    }

    private static final Function<String, String> sanitize = (s) -> s.trim().replaceAll("\\s+", "");

    public static boolean isAllowedToBringDish(String beast, String dish) {
        return sanitize.apply(beast).charAt(0) == sanitize.apply(dish).charAt(0) && sanitize.apply(beast).charAt(sanitize.apply(beast).length() - 1) == sanitize.apply(dish).charAt(sanitize.apply(dish).length() - 1);
    }


}


