package main.java.ua.Lysenko.HW4;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        assignArray(array);
        replaceEven(array);

    }

    private static void assignArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = 1;
            int max = 100;
            array[i] = min + (int) (Math.random() * max);
        }
    }

    private static void replaceEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }
}
