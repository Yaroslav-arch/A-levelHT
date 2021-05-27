package main.java.ua.Lysenko.HW5;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[25];
        assignArray(array);
        bubbleSortDesc(array); //добавил обратную сортировку пузырьком для удобства проверки
        System.out.println(Arrays.toString(array));
        System.out.println("Given array is Descending: " + checkArrayIsDesc(array));
    }

    private static void assignArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSortDesc(int[] array) {
        int middle;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    middle = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = middle;
                    isSorted = false;
                }

            }
        }
    }

    private static boolean checkArrayIsDesc(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] >= array[i + 1]) {
                count++;
            }
        }
        return count == array.length - 1;
//        return false;
    }
}
