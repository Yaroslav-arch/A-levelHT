package ua.Lysenko.HW5;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int arraySize = 3;
        int[][] array = new int[arraySize][arraySize];
        assignArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(replaceNumbers(array)[i]));
        }
    }

    private static void assignArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] replaceNumbers(int[][] array) {
        int[][] finalArray = new int[array.length][array.length];
        for (int i = 0; i < finalArray.length; i++) {
            for (int j = 0; j < finalArray.length; j++) {

                finalArray[i][j] = array[j][i];
            }
        }
        System.out.println("replace numbers method called");
        return finalArray;
    }
}
