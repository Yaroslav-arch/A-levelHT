package main.java.ua.Lysenko.HW5;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[20];
        assignArray(array);
        int deleteIndex = 10;
        System.out.println(Arrays.toString(deleteAndRearrange(array, deleteIndex)));
    }

    private static void assignArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
    }

    private static int[] deleteAndRearrange(int[] array, int deleteIndex) {
        if (array.length - 1 - deleteIndex >= 0)
            System.arraycopy(array, deleteIndex + 1, array, deleteIndex, array.length - 1 - deleteIndex);
        array[array.length - 1] = 0;
        return array;
    }
}
