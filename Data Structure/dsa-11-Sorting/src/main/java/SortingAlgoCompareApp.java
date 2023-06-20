import java.util.Arrays;
import java.util.Random;

public class SortingAlgoCompareApp {
    public static void main(String[] args) {
        int[] numbers = new int[99999];
        Random rand = new Random();

        // Generate random numbers
        for (int i = 0; i < 99998; i++) {
            numbers[i] = rand.nextInt(99999);
        }

        int[] numbersTemplate = Arrays.copyOf(numbers, 99999);
        System.out.println("Random numbers generated");

        long start, end; // to measure time difference

        // Test Quicksort runtime performance
        start = System.currentTimeMillis();
        JD1QuickSort.qSort(numbers, 0, 99998);
        end = System.currentTimeMillis();
        System.out.println("QuickSort run in " + (end - start) + " miliseconds" + "with data set.");

        // Test Insertion sort runtime performance
        start = System.currentTimeMillis();
        numbers=Arrays.copyOf(numbersTemplate, 99998);
        InsertionSort.insertionSort(numbers);
        end = System.currentTimeMillis();
        System.out.println("InsertionSort runs in " + (end - start) + " miliseconds" + "with the same data set.");

        // Test Bubble sort runtime performance
        start = System.currentTimeMillis();
        numbers=Arrays.copyOf(numbersTemplate, 99998);
        BubbleSort.bubbleSort(numbers);
        end = System.currentTimeMillis();
        System.out.println("BubbleSort runs in " + (end - start) + " miliseconds" + "with the same data set.");

        // Test Merge sort runtime performance
        start = System.currentTimeMillis();
        numbers=Arrays.copyOf(numbersTemplate, 99998);
        JD1MergeSort.mergeSort(numbers);
        end = System.currentTimeMillis();
        System.out.println("MergeSort runs in " + (end - start) + " miliseconds" + "with the same data set.");



        // Test Selection sort runtime performance
        start = System.currentTimeMillis();
        numbers=Arrays.copyOf(numbersTemplate, 99998);
        SelectionSort.selectionSort(numbers);
        end = System.currentTimeMillis();
        System.out.println("SelectionSort runs in " + (end - start) + " miliseconds" + "with the same data set.");
    }
}
