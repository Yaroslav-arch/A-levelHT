package ua.Lysenko.HW3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите предложение");
        Scanner scanner = new Scanner(System.in);
        String basic = scanner.nextLine();
        System.out.println("В строке " + basic + " " + countSpaces(basic) + " слов(а)");
        System.out.println("В строке " + basic + " " + anothercount(basic) + " слов(а)");
    }


    private static int countSpaces(String in) {
        String checked = in.trim();
        return checked.length() - checked.replaceAll(" ", "").length() + 1;
    }

    private static int anothercount(String in) {
        int count = 0;
        for (String returnValue : in.split(" ")) {
            count = returnValue.length();
        }
        return count;
    }
}
