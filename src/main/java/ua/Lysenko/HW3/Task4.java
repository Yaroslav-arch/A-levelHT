package main.java.ua.Lysenko.HW3;

import java.util.Scanner;

public class Task4 {
    static int a;
    static int b;
    static boolean flag = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setA();
        requestB();

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
            requestB();
            flag = false;
        } else if (b < a) {
            System.out.println("Мало");
            requestB();
            flag = false;
        } else {
            flag = true;
        }

    }

    private static void requestB() {
        System.out.println("Введите число");
        b = scanner.nextInt();

    }
}
