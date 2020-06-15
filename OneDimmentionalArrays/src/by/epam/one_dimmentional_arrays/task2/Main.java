package by.epam.one_dimmentional_arrays.task2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 1, 1, 8, 9, 10};

        int min = findMin(array);

        System.out.println(Arrays.toString(removeAll(array, min)));
    }

    public static int findMin(int[] array) {
        int min = array[0];

        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }

        return min;
    }

    public static int[] removeAll(int[] array, int element) {
        int[] resultArray = new int[array.length];

        int j = 0;
        for (int value : array) {
            if (value != element) {
                resultArray[j] = value;
                j++;
            }
        }

        return Arrays.copyOfRange(resultArray, 0, j);
    }
}
