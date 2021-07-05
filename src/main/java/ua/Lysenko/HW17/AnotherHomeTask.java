package ua.Lysenko.HW17;

import java.util.*;
import java.util.stream.Collectors;

public class AnotherHomeTask {
    public static void main(String[] args) {
        double [] array = new double [10];
        Random random = new Random(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble();
        }
        System.out.println(Arrays.toString(array));

        DoubleSummaryStatistics doubleSummaryStatistics = Arrays.stream(array)
                .summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }
}
