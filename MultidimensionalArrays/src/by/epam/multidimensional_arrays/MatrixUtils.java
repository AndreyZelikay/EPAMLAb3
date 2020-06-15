package by.epam.multidimensional_arrays;

public class MatrixUtils {
    public static void printMatrix(int[][] matrix) {
        for(int[] row: matrix) {
            for(int element: row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
