package ua.Lysenko.HW4;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        assignArray(array);
        System.out.println(ariphMean(array));
        System.out.println(geomMean(array));
    }

    private static void assignArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = 1;
            int max = 10;
            array[i] = min + (int) (Math.random() * max);
        }
    }

    private static double ariphMean(int[] array) {
        double sum = 0;
        for (int j : array) {
            sum = sum + j;
        }
        return sum / 400;
    }

    private static double geomMean(int[] array) {
        double mult = 1.0;
        for (int j : array) {
            mult = mult * j;
        }
        return Math.pow(mult, 1.0 / 400);
    }
}
