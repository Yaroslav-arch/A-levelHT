package ua.Lysenko.Module1.ChessTask;

public class Converter {
    private int xCoordinate;
    private int yCoordinate;

    public int[] convertCoordinateToIndex(String coordinate) {
        String letter = coordinate.substring(0, 1);
        int[] coordinates = new int[2];
        coordinates[0] = getLetterNumber(letter);
        coordinates[1] = Integer.parseInt(coordinate.substring(1, 2));
        return coordinates;
    }

    private int getLetterNumber(String letter) {
        int letterToNumber = -1;
        if (letter.equalsIgnoreCase("a")) {
            letterToNumber = 1;
        }
        if (letter.equalsIgnoreCase("b")) {
            letterToNumber = 2;
        }
        if (letter.equalsIgnoreCase("c")) {
            letterToNumber = 3;
        }
        if (letter.equalsIgnoreCase("d")) {
            letterToNumber = 4;
        }
        if (letter.equalsIgnoreCase("e")) {
            letterToNumber = 5;
        }
        if (letter.equalsIgnoreCase("f")) {
            letterToNumber = 6;
        }
        if (letter.equalsIgnoreCase("g")) {
            letterToNumber = 7;
        }
        if (letter.equalsIgnoreCase("h")) {
            letterToNumber = 8;
        }
        return letterToNumber;
    }
}

