package by.epam.one_dimmentional_arrays.task5;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 5, 2, 2, 3, 6, 7, 1, 3, 3, 3, 10};

        System.out.println(findMaxOfEvenElements(array) + findMinOfOddElements(array));
    }

    public static int findMaxOfEvenElements(int[] array) {
        int max = array[1];

        for (int i = 1; i < array.length; i += 2) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static int findMinOfOddElements(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i += 2) {
            if(array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}
