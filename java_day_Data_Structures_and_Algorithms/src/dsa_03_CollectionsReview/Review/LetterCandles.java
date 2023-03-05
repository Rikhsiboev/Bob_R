package dsa_03_CollectionsReview.Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class LetterCandles {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Read inputs here!

        System.out.println("Enter letter count: ");
        int letterCount = Integer.parseInt(reader.readLine());

        System.out.println("Enter number candles that can be removed : ");
        int m = Integer.parseInt(reader.readLine());

        System.out.println("Enter number candles that can be removed : ");
        String  letters = reader.readLine();

        System.out.println(letterCandlesCost(letterCount, m, letters));
    }
    public static int letterCandlesCost(int letterCount, int m,String str){
      int cost=0;
        return cost;
    }
}
