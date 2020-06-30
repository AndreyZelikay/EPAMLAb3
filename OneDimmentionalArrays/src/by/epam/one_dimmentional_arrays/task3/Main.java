package by.epam.one_dimmentional_arrays.task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 0, 0, 3, 4, 0, 0, 0, 0};

        System.out.println(Arrays.toString(findKey(array)));
    }

    public static int[] findKey(int[] array) {
        int firstKnownIndex = 0;
        int secondKnownIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && firstKnownIndex == 0) {
                firstKnownIndex = i;
            } else if (array[i] != 0 && secondKnownIndex == 0) {
                secondKnownIndex = i;
            }
        }

        int[] result = new int[array.length];
        result[firstKnownIndex] = array[firstKnownIndex];
        result[secondKnownIndex] = array[secondKnownIndex];

        if (!isFindKeyPossible(0, result, firstKnownIndex, secondKnownIndex)) {
            throw new IllegalArgumentException("unable to build key");
        }

        return result;
    }

    private static boolean isFindKeyPossible(int currentIndex, int[] array, int firstKnownIndex, int secondKnownIndex) {
        if (currentIndex == array.length) {
            return isKeyMatches(array);
        }

        if (currentIndex == firstKnownIndex || currentIndex == secondKnownIndex) {
            return isFindKeyPossible(currentIndex + 1, array, firstKnownIndex, secondKnownIndex);
        }

        for (int i = 1; i <= 6; i++) {
            array[currentIndex] = i;
            if (isFindKeyPossible(currentIndex + 1, array, firstKnownIndex, secondKnownIndex)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isKeyMatches(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] + array[i + 1] + array[i + 2] != 10) {
                return false;
            }
        }

        return true;
    }

}
