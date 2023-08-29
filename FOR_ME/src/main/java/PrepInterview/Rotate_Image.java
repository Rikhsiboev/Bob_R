package PrepInterview;

public class Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        System.out.println("Original Matrix 1:");
        printMatrix(matrix1);
        rotate(matrix1);
        System.out.println("Rotated Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Original Matrix 2:");
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("Rotated Matrix 2:");
        printMatrix(matrix2);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;  // rows

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                // Swap matrix[i][left] with matrix[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

