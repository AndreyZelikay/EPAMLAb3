package by.epam.multidimensional_arrays.task6;

import static by.epam.multidimensional_arrays.MatrixUtils.printMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] square = buildEvenlyEvenMagicSquare(8);

        printMatrix(square);
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

    public static int[][] buildEvenlyEvenMagicSquare(int size) {
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

    public static int[][] buildEvenlyOddMagicSquare(int size) {
        int[][] bufferSquare = buildEvenlyEvenMagicSquare(size - 2);

        int[][] resultSquare = new int[size][size];

        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                resultSquare[i][j] = bufferSquare[i - 1][j - 1] + 2 * (size - 1);
            }
        }

        resultSquare[0][0] = 3 * size / 2 - 1;
        resultSquare[0][size - 1] = 1;
        resultSquare[size - 1][0] = (int) Math.pow(size, 2);
        resultSquare[size - 1][size - 1] = (int) Math.pow(size, 2) - 3 * size / 2 + 2;

        for (int i = 1; i < size / 2 - 2; i++) {
            resultSquare[0][i] = 2 * i + 1;
            resultSquare[size - 1][i] = (int) Math.pow(size, 2) + 1 - resultSquare[0][i];
        }

        for (int i = 1; i < size / 2; i++) {
            resultSquare[0][i + size / 2 - 1] = (int) Math.pow(size, 2) + 1 - 2 * i;
            resultSquare[size - 1][i + size / 2 - 1] = (int) Math.pow(size, 2) + 1 - resultSquare[0][i + size / 2 - 1];
        }

        resultSquare[1][0] = 2 * size / 2 - 1;

        for (int i = 1; i <= size / 2; i++) {
            resultSquare[i + 1][0] = (int) Math.pow(size, 2) - 2 * size + i + 2;
        }

        for(int i = 1; i < size / 2 - 1; i++) {
            resultSquare[i + size / 2 + 1][0] = 3 * size / 2 - 1 - i;
        }
        
        return resultSquare;
    }
}
