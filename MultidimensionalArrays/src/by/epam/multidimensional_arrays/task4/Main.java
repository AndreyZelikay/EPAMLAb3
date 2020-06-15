package by.epam.multidimensional_arrays.task4;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[][] matrix = buildSquareMatrix(array.length, array);

        printMatrix(matrix);
    }

    public static int[][] buildSquareMatrix(int size, int[] array) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) Math.pow(array[j], i + 1);
            }
        }

        return matrix;
    }
}
