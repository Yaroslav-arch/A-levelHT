package ua.Lysenko.Module1;

import java.util.Arrays;
import java.util.Random;

public class TaskArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        fillArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Количество разных чисел: " + getQuantityOfDifferentNumbers(array));
    }

    private static void fillArray(int[] array) {
        Random random = new Random(100);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
    }

    private static int getQuantityOfDifferentNumbers(int[] array) {
        int count = 0;
        for (int k : array) {
            if (k == 0) {
                count = 1;
                break;
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = 0;
                }

            }
            if (array[i] != 0) {
                count++;
            }
        }

        return count;
    }

}

