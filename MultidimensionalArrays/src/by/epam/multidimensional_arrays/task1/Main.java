package by.epam.multidimensional_arrays.task1;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = buildSquareMatrix(4);

        printMatrix(matrix);
    }

    public static int[][] buildSquareMatrix(int size) {
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = (i % 2 == 1) ? size - j : j + 1;
            }
        }

        return matrix;
    }
}
