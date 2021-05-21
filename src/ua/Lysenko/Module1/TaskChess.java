package ua.Lysenko.Module1;

import java.util.Scanner;

public class TaskChess {
    public static void main(String[] args) {
        ChessField originalPosition = new ChessField();
        ChessField intendedPosition = new ChessField();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите букву текущей ячейки");
        originalPosition.letter = scanner.next();
        System.out.println("Введите цифру текущей ячейки");
        originalPosition.number = scanner.nextInt();
        System.out.println("Введите букву желаемой ячейки");
        intendedPosition.letter = scanner.next();
        System.out.println("Введите цифру желаемой ячейки");
        intendedPosition.number = scanner.nextInt();

        int difference = originalPosition.getIndex() - intendedPosition.getIndex();
        if (originalPosition.getIndex() == -1 || intendedPosition.getIndex() == -1) {
            System.out.println("Введите букву от а до h и число от 1 до 8");
        } else {
            if (Math.abs(difference) == 17 || Math.abs(difference) == 15 || Math.abs(difference) == 10 || Math.abs(difference) == 6) {
                System.out.println("Выбранное поле подходит");
            } else {
                System.out.println("Выбранное НЕ поле подходит");
            }
        }
    }
}

