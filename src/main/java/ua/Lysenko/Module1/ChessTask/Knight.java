package ua.Lysenko.Module1.ChessTask;

public class Knight {
    int xCoordinate;
    int yCoordinate;

    Knight() {
        this.xCoordinate = 1;
        this.yCoordinate = 1;
    }

    public boolean checkMovement(int x, int y) {
        int deltaX = Math.abs(x - this.xCoordinate);
        int deltaY = Math.abs(y - this.yCoordinate);
        return deltaX * deltaY == 2;

    }

}
