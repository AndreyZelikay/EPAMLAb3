package by.epam.multidimensional_arrays.task3;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = buildSquareMatrix(2);

        printMatrix(matrix);
    }

    public static int[][] buildSquareMatrix(int size) {
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i; j++) {
                matrix[i][j] = 1;
            }
        }

        for (int i = size - 1; i >= size / 2; i--) {
            for (int j = size - i - 1; j < i + 1; j++) {
                matrix[i][j] = 1;
            }
        }

        return matrix;
    }
}
