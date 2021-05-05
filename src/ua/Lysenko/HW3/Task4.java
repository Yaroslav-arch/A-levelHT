package ua.Lysenko.HW3;

import java.util.Scanner;

public class Task4 {
    static int a;
    static int b;

    public static void main(String[] args) {
        setA();
        setB();

        while (!checkNumber()) {
            checkNumber();
        }

        System.out.println("Угадал!");

    }

    private static void setA() {
        int min = 0;
        int max = 1000;
        a = min + (int) (Math.random() * max);

    }

    private static boolean checkNumber() {


        if (b > a) {
            System.out.println("Много");
            setB();
            return false;
        } else if (b < a) {
            System.out.println("Мало");
            setB();
            return false;
        } else {
            return true;
        }

    }

    private static void setB() {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        b = scanner.nextInt();

    }
}
