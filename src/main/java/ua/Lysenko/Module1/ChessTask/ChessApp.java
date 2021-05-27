package ua.Lysenko.Module1.ChessTask;

import java.util.Scanner;

public class ChessApp {
    private Converter converter;

    public ChessApp() {
        this.converter = new Converter();
    }

    public ChessApp(Converter converter) {
        this.converter = converter;
    }

    public static void main(String[] args) {
        ChessApp chessApp = new ChessApp();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату поля");
        String input = scanner.nextLine();
        chessApp.runChessTask(input);
    }

    boolean runChessTask(String input) {
        Knight whiteKnightOne = new Knight();

        int[] nextCoordinateArr = this.converter.convertCoordinateToIndex(input);
        return whiteKnightOne.checkMovement(nextCoordinateArr[0], nextCoordinateArr[1]);
    }


}

