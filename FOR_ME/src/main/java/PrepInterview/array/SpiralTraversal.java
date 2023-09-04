package PrepInterview.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 10},
                {12, 13, 14, 5, 20},
                {11, 16, 15, 6, 30},
                {10, 9, 8, 7, 40}
        };

        List<Integer> result = spiralOrder(matrix);

        System.out.println(result); // Should print [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Check if there's still a valid row to traverse
            if (top <= bottom) {
                // Traverse bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Check if there's still a valid column to traverse
            if (left <= right) {
                // Traverse left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
