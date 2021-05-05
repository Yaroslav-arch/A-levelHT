package ua.Lysenko.HW3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Введите любое слово или фразу");
        Scanner scanner = new Scanner(System.in);
        String basic = scanner.nextLine();
        if (checkPalindrome(deleteSpaces(basic))) {
            System.out.println("Строка " + basic + " - палиндром");
        } else {
            System.out.println("Строка " + basic + " - НЕ палиндром");
        }
    }

    private static String deleteSpaces(String input) {
        return input.replaceAll("\\s+", "");

    }

    private static boolean checkPalindrome(String incoming) {
        StringBuilder reversed = new StringBuilder(incoming.toLowerCase());
        reversed.reverse();
        String income = incoming.toLowerCase();

        return reversed.toString().equals(income);
    }
}
