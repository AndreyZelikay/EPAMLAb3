package by.epam.multidimensional_arrays.task5;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] firstMatrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] secondMatrix = new int[][]{{1, 2}, {1, 2}, {1, 2}};

        int[][] result = multiplyMatrices(firstMatrix, secondMatrix);

        printMatrix(result);
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("matrices are not compatible");
        }

        int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                int element = 0;

                for (int k = 0; k < secondMatrix.length; k++) {
                    element += firstMatrix[i][k] * secondMatrix[k][j];
                }

                resultMatrix[i][j] = element;
            }
        }

        return resultMatrix;
    }
}
