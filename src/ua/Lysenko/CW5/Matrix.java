package ua.Lysenko.CW5;

public class Matrix {
    private double[][] inner;

    public Matrix(double[][] inner) {
        this.inner = inner;
    }

    public void setElement(int row, int column, double newValue) {
        validateIndics(row, column);
        inner[row][column] = newValue;
    }

    private void validateIndics(int row, int column) {
        if (row >= inner.length || column >= inner[0].length) {
           throw new RuntimeException("Wrong row or column");
        }
    }

    public double getElement(int row, int column) {
        validateIndics(row, column);
        return inner[row][column];
    }

    public static void main(String[] args) {
       double [][] array = {{1,2,3},{2,3,4}};
        Matrix matrix = new Matrix(array);
        matrix.setElement(1,2,4.0);
    }
}
