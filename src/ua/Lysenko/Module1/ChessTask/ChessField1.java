package ua.Lysenko.Module1.ChessTask;

import java.util.Scanner;

public class ChessField1 extends ChessField{
    String letter;
    int number;
    int index;

    public ChessField1() {
    }

    void setValues() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите букву поля назначения от а до h");
            this.letter = scanner.next();

        } while (getIndex() == -1);

        do {
            System.out.println("Введите номер поля назначения от 1 до 8");
            this.number = scanner.nextInt();
        } while (this.number < 1 || this.number > 8);
    }


    int getIndex() {
        int index;
        if (this.letter.equalsIgnoreCase("a")) {
            index = this.number;
        } else if (this.letter.equalsIgnoreCase("b")) {
            index = this.number + 8;
        } else if (this.letter.equalsIgnoreCase("c")) {
            index = this.number + 16;
        } else if (this.letter.equalsIgnoreCase("d")) {
            index = this.number + 24;
        } else if (this.letter.equalsIgnoreCase("e")) {
            index = this.number + 32;
        } else if (this.letter.equalsIgnoreCase("f")) {
            index = this.number + 40;
        } else if (this.letter.equalsIgnoreCase("g")) {
            index = this.number + 48;
        } else if (this.letter.equalsIgnoreCase("h")) {
            index = this.number + 56;
        } else index = -1;
        return index;
    }

}
