package ua.Lysenko.Module1.ChessTask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConverterTest {
    private Converter converter = new Converter();

    @Test
    public void convertCoordinates() {
        String coordinate = "a1";
        int[] resultIndex = converter.convertCoordinateToIndex(coordinate);
        assertArrayEquals(new int[]{1,1}, resultIndex);

    }

    @Test
    public void convertCoordinates1() {
        String coordinate = "b1";
        int[] resultIndex = converter.convertCoordinateToIndex(coordinate);
        assertArrayEquals(new int[]{2,1}, resultIndex);
    }
}
