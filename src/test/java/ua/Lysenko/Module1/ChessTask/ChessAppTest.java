package ua.Lysenko.Module1.ChessTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ChessAppTest {
    @InjectMocks
    private ChessApp chessApp;

    @Mock
    private Converter converter;


    @Test
    public void testIllegalMove() {
        Mockito.when(converter.convertCoordinateToIndex(Mockito.anyString())).thenReturn(new int[]{1, 2});
        assertFalse(chessApp.runChessTask("a1 to a2"));
    }

    @Test
    public void testLegalMove() {
        Mockito.when(converter.convertCoordinateToIndex(Mockito.anyString())).thenReturn(new int[]{2, 3});
        assertTrue(chessApp.runChessTask("a1 to b3"));
    }
}