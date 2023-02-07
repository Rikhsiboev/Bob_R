package Practice_Code;

import java.util.Arrays;

public class Maximum_Number_of_Words {
    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};

        int temp = 0;
        for (String stt:sentences) {
            String [] m = stt.split(",");
            temp = Math.max(temp,sentences.length);
        }
        System.out.println(temp);

    }
}

