package ua.Lysenko.HW3;

import java.util.Scanner;

public class Task4 {
    static int a;
    static int b;
    static boolean flag = false;

    public static void main(String[] args) {
        setA();
        setB();

        while (!flag) {
            checkNumber();
        }

        System.out.println("Угадал!");

    }

    private static void setA() {
        int min = 0;
        int max = 100;
        a = min + (int) (Math.random() * max);

    }

    private static void checkNumber() {


        if (b > a) {
            System.out.println("Много");
            setB();
            flag = false;
        } else if (b < a) {
            System.out.println("Мало");
            setB();
            flag = false;
        } else {
            flag = true;
        }

    }

    private static void setB() {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        b = scanner.nextInt();

    }
}
