package ua.Lysenko.HW4;

import java.util.Arrays;


public class Task3 {
    static int maxValue;

    public static void main(String[] args) {
        int[] array = new int[1000];
        assignArray(array);
        getMaxValue(array);
        System.out.println("Составных чисел в масссиве: " + (1000 - compareArrays(array, getSimpleNumber())));

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

    static boolean simple(int a) {//берем число i
        int p = 0;//переменная для определения результата
        if ((a % 2 == 0) || (a % 10 == 5)) {//исключаем числа, которые заканчиваются на 5 и четные
            return false;
        } else {
            for (int j = 3; j <= Math.sqrt(a); j += 2) {//делим на все нечетные числа до корня из i
                if (a % j == 0) {// если хотя бы на одно число делится, то остановка цикла, переход к следующему числу
                    p += 1;
                    break;
                }
            }
        }
        //если p = 0, то возвращаем true, число простое
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

