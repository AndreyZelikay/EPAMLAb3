package by.epam.one_dimmentional_arrays.task4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 5, 2, 2, 3, 6, 7, 1, 3, 3, 3, 10};

        System.out.println(findMinMostCommonNumber(array));
    }

    public static int findMinMostCommonNumber(int[] array) {
        int[] tempArray = Arrays.copyOf(array, array.length);

        Arrays.sort(tempArray);

        int counter = 0;
        int currentCounter = 0;
        int currentElement = 0;
        int minMostCommonNumber = array[0];

        for (int element : tempArray) {
            if (element == currentElement) {
                currentCounter++;
            } else {
                if (counter < currentCounter) {
                    minMostCommonNumber = currentElement;
                    counter = currentCounter;
                }

                currentElement = element;
                currentCounter = 0;
            }
        }

        return minMostCommonNumber;
    }
}
