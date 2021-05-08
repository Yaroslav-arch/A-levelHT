package ua.Lysenko.HW4;

import java.util.Arrays;


public class Task2 {
    static int maxValue;

    public static void main(String[] args) {
        int[] array = new int[1000];
        assignArray(array);
        getMaxValue(array);
        System.out.println("Простых чисел в массиве: " + (compareArrays(array, getSimpleNumber())));

    }

    private static void assignArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = 1;
            int max = 10;
            array[i] = min + (int) (Math.random() * max);
        }
    }

    private static void getMaxValue(int[] array) {
        Arrays.sort(array);
        maxValue = array[array.length - 1];
    }

    private static int[] getSimpleNumber() {
        int count = 4;
        int[] simpleNumberArray = new int[1000];
        simpleNumberArray[0] = 2;
        simpleNumberArray[1] = 3;
        simpleNumberArray[2] = 5;
        simpleNumberArray[3] = 7;
        for (int i = 11; i <= maxValue; i += 2) {
            if (simple(i)) {
                count++;
                simpleNumberArray[count] = i;
            }
        }
        return simpleNumberArray;
    }

    static boolean simple(int a) {
        int p = 0;
        if ((a % 2 == 0) || (a % 10 == 5)) {
            return false;
        } else {
            for (int j = 3; j <= Math.sqrt(a); j += 2) {
                if (a % j == 0) {
                    p += 1;
                    break;
                }
            }
        }
        return p <= 0;

    }

    private static int compareArrays(int[] arrayOriginal, int[] arraySimple) {
        int count = 0;
        for (int i = 0; i < arrayOriginal.length; i++) {
            for (int j = 0; j < arraySimple.length; j++) {
                if (arrayOriginal[i] == arraySimple[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

