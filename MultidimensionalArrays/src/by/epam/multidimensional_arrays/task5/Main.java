package by.epam.multidimensional_arrays.task5;

import static by.epam.multidimensional_arrays.MatrixUtils.multiplyMatrices;
import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] firstMatrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] secondMatrix = new int[][]{{1, 2}, {1, 2}, {1, 2}};

        int[][] result = multiplyMatrices(firstMatrix, secondMatrix);

        printMatrix(result);
    }
}
