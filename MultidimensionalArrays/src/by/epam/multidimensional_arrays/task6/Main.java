package by.epam.multidimensional_arrays.task6;

import java.util.Arrays;

import static by.epam.multidimensional_arrays.MatrixUtils.addMatrices;
import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] square = buildMagicSquare(5);

        printMatrix(square);
    }

    public static int[][] buildMagicSquare(int size) {
        if (size % 2 == 1) {
            return buildOddOrderMagicSquare(size);
        } else if (size % 4 == 0) {
            return buildEvenlyEvenOrderMagicSquare(size);
        } else {
            return buildEvenlyOddOrderMagicSquare(size);
        }
    }

    public static int[][] buildOddOrderMagicSquare(int size) {
        int[][] square = new int[size][size];

        int x = size / 2;
        int y = size - 1;

        int number = 1;
        while (number <= Math.pow(size, 2)) {
            square[y][x] = number;

            if (number % size == 0) {
                x++;
            } else {
                x--;
                y--;
            }

            number++;

            x = (x >= size) ? 0 : x;
            x = (x < 0) ? size - 1 : x;

            y = (y >= size) ? 0 : y;
            y = (y < 0) ? size - 1 : y;
        }

        return square;
    }

    public static int[][] buildEvenlyEvenOrderMagicSquare(int size) {
        int[][] square = new int[size][size];

        int number = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square[i][j] = (isInFourOrderSquareDiagonal(i, j)) ? (int) (Math.pow(size, 2) + 1 - number) : number;
                number++;
            }
        }

        return square;
    }

    public static boolean isInFourOrderSquareDiagonal(int x, int y) {
        return (x % 4 == y % 4) || ((3 - x % 4) == y % 4);
    }

    public static int[][] buildEvenlyOddOrderMagicSquare(int size) {
        int[][] firstAuxiliarySquare = new int[size][size];
        int[][] secondAuxiliarySquare = new int[size][size];

        int[][] bufferMagicSquare = buildOddOrderMagicSquare(size / 2);

        for (int i = 0; i < size / 2; i++) {
            System.arraycopy(bufferMagicSquare[i], 0, firstAuxiliarySquare[i], 0, size / 2);
            System.arraycopy(bufferMagicSquare[i], 0, firstAuxiliarySquare[i], size / 2, size - size / 2);
        }

        for (int i = size / 2; i < size; i++) {
            System.arraycopy(bufferMagicSquare[i - size / 2], 0, firstAuxiliarySquare[i], 0, size / 2);
            System.arraycopy(bufferMagicSquare[i - size / 2], 0, firstAuxiliarySquare[i], size / 2, size - size / 2);
        }

        int k = (size - 2) / 4;

        for (int i = 0; i < size / 2; i++) {
            if (i != size / 4) {
                Arrays.fill(secondAuxiliarySquare[i], 0, k, (int) (3 * Math.pow(size / 2, 2)));
                Arrays.fill(secondAuxiliarySquare[i], k, size / 2, 0);
            } else {
                Arrays.fill(secondAuxiliarySquare[i], 0, size / 4 - k + 1, 0);
                Arrays.fill(secondAuxiliarySquare[i], size / 4 - k + 1, size / 4 + 1, (int) (3 * Math.pow(size / 2, 2)));
                Arrays.fill(secondAuxiliarySquare[i], size / 4 + 1, size, 0);
            }

            Arrays.fill(secondAuxiliarySquare[i], size / 2, size - 1, (int) (2 * Math.pow(size / 2, 2)));
            secondAuxiliarySquare[i][size - 1] = (int) Math.pow(size / 2, 2);
        }

        for (int i = size / 2; i < size; i++) {
            if (i != 3 * size / 4) {
                Arrays.fill(secondAuxiliarySquare[i], 0, k, 0);
                Arrays.fill(secondAuxiliarySquare[i], k, size / 2, (int) (3 * Math.pow(size / 2, 2)));
            } else {
                Arrays.fill(secondAuxiliarySquare[i], 0, size / 4 - k + 1, (int) (3 * Math.pow(size / 2, 2)));
                Arrays.fill(secondAuxiliarySquare[i], size / 4 - k + 1, size / 4 + 1, 0);
                Arrays.fill(secondAuxiliarySquare[i], size / 4 + 1, size, (int) (3 * Math.pow(size / 2, 2)));
            }

            Arrays.fill(secondAuxiliarySquare[i], size / 2, size - 1, (int) Math.pow(size / 2, 2));
            secondAuxiliarySquare[i][size - 1] = (int) (2 * Math.pow(size / 2, 2));
        }

        return addMatrices(firstAuxiliarySquare, secondAuxiliarySquare);
    }
}
