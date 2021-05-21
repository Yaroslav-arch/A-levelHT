package ua.Lysenko.Module1;

public class ChessField {
    String letter;
    int number;

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


    public ChessField() {
    }
}
