package main.java.ua.Lysenko.CW5;

import java.util.Arrays;
import java.util.Random;

public class BranchPrediction {
    public static void main(String[] args) {
        int[] array = new int[32000];
        Random rand = new Random(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(255);
        }

        long start = System.nanoTime();
        Arrays.sort(array);
        int sum = 0;
        for (int j = 0; j < 100_000; j++) {

            for (int i = 0; i < array.length; i++) {
                if (array[i] < 128) {
                    sum += array[i];
                }
            }
        }
        long finish = System.nanoTime();
        System.out.println(sum);
        System.out.println("время работы программы: " + ((finish - start) / 1000000000.0) + " c");
    }

}
