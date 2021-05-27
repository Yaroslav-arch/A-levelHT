package main.java.ua.Lysenko.HW4;

import java.util.Arrays;


public class Task2 {
    static int maxValue;

    public static void main(String[] args) {
        int[] array = new int[1000];
        assignArray(array);
        getMaxValue(array);
        System.out.println("Простых чисел в массиве: " + (getPrimeNumbersQuantity(array, createPrimeNumbersArray())));

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

    private static int[] createPrimeNumbersArray() {
        int count = 4;
        int[] primeNumbersArray = new int[1000];
        primeNumbersArray[0] = 2;
        primeNumbersArray[1] = 3;
        primeNumbersArray[2] = 5;
        primeNumbersArray[3] = 7;
        for (int i = 11; i <= maxValue; i += 2) {
            if (simple(i)) {
                count++;
                primeNumbersArray[count] = i;
            }
        }
        return primeNumbersArray;
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

    private static int getPrimeNumbersQuantity(int[] arrayOriginal, int[] arraySimple) {
        int count = 0;
        for (int j : arrayOriginal) {
            for (int k : arraySimple) {
                if (j == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

