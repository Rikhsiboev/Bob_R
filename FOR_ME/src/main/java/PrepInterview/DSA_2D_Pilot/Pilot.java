package PrepInterview.DSA_2D_Pilot;

import java.util.Arrays;

public class Pilot {
    public static void main(String[] args) {
        int[] xDirection = {2, 3, 2, 4, 2};
        int[] yDirection = {2, 2, 6, 5, 8};

        double[] slope = findSlopeFromDropPoints(xDirection, yDirection);

        System.out.println(Arrays.toString(slope));
        System.out.println("Slope: " + Arrays.toString(slope));
    }

    public static double[] findSlopeFromDropPoints(int[] xDirection, int[] yDirection) {
        // Creating 2D as Coordination
        int coordinates = Math.min(xDirection.length, yDirection.length);
        // Finding the size of the slope array
        double[] slope = new double[coordinates - 1];

        // Looping and finding y2, y1, x2, x1 and calculating slopes
        for (int i = 0; i < coordinates - 1; i++) {
            int x1 = xDirection[i];
            int y1 = yDirection[i];
            int x2 = xDirection[i + 1];
            int y2 = yDirection[i + 1];
            // Make sure that x2 and x1 are not Infinity as vertical lines are undefined
            if (x2 - x1 == 0) {
                slope[i] = Double.POSITIVE_INFINITY;
            } else {
                slope[i] = (double) (y2 - y1) / (x2 - x1);
            }
        }

        // Now to find the longest path
        int longestPath = 0;
        int currentPath = 1; // Move this line outside of the loop

        for (int i = 0; i < slope.length - 1; i++) { // Change the loop termination condition
            if (slope[i] == slope[i + 1]) { // Change this line
                currentPath++;
            } else {
                currentPath = 1;
            }
            if (currentPath > longestPath) {
                longestPath = currentPath;
            }
        }
        System.out.println("Longest Path: " + longestPath);

        return slope;
    }
}
