package main.java.ua.Lysenko.HW5;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        System.out.println(Arrays.deepToString(fillArray(array)));
    }

    private static int[][] fillArray(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (i % 2 == 0) ? count : -count;
                count++;
            }
        }
        return array;
    }
}
