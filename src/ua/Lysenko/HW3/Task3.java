package ua.Lysenko.HW3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите предложение");
        Scanner scanner = new Scanner(System.in);
        String basic = scanner.nextLine();
        System.out.println("В строке " + basic + " " + countSpaces(basic) + " слов(а)");

    }

    private static int countSpaces(String in) {
        String[] words = in.split("\\s+");
        int count = words.length;
        return count - checkingForNumbers(words);
    }

    private static int checkingForNumbers(String[] words) {
//        String regex = "\\d+";
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i].replaceAll("[0-9]+", "");
            if (s.equals("")) {
                counter++;
            }
        }
        return counter;
    }
}
