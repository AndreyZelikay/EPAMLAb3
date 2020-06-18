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

    public static int[][] addMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length
                || firstMatrix[0].length != secondMatrix[0].length) {
            throw new IllegalArgumentException("unable to add matrices");
        }

        int[][] resultMatrix = new int[firstMatrix.length][firstMatrix[0].length];

        for(int i = 0; i < firstMatrix.length; i++) {
            for(int j = 0; j < firstMatrix[i].length; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return resultMatrix;
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
