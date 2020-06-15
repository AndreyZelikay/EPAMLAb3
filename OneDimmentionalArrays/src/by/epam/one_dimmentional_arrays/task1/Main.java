package by.epam.one_dimmentional_arrays.task1;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(calcMaxValue(array));
    }

    public static int calcMaxValue(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] + array[array.length - i - 1] > max) {
                max = array[i] + array[array.length - i - 1];
            }
        }

        return max;
    }
}
