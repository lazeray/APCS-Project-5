import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testConstructorAndGetBoardPieces() {
        int rows = 3;
        int cols = 4;

        Board board = new Board(rows, cols);
        int[][] boardPieces = board.getBoardPieces();

        assertEquals(rows, boardPieces.length, "Rows should match");
        assertEquals(cols, boardPieces[0].length, "Columns should match");

        // Check that all elements are initialized to 0
        for (int[] row : boardPieces) {
            for (int cell : row) {
                assertEquals(0, cell, "All elements should be initialized to 0");
            }
        }
    }
}