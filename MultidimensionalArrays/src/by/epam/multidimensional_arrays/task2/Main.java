package by.epam.multidimensional_arrays.task2;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = buildSquareMatrix(4);

        printMatrix(matrix);
    }

    public static int[][] buildSquareMatrix(int size) {
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size - 1; i++) {
            matrix[i][i] = (i + 1) * (i + 2);
        }

        matrix[size - 1][size - 1] = size * (size + 1);

        return matrix;
    }
}
