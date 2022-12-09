
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;


public class TestingMainApp {

    @Test
    public void testValidMove() {
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        assertTrue(Logic.validMove(board, "1"));
        assertFalse(Logic.validMove(board, "10"));

        board[0][0] = 'X';
        assertFalse(Logic.validMove(board, "1"));
    }

    @Test
    public void testMakeMove() {
        char[][] board = {{' ', 'O', 'X'},
                {'X', ' ', 'X'},
                {'O', 'X', 'O'}};

        Logic.makeMove(board, "1", 'X');
        assertEquals('X', board[0][0]);

        Logic.makeMove(board, "5", 'O');
        assertEquals('O', board[1][1]);
    }

    @Test
    public void testWinConditionXRow() {
        char[][] board = {{'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        assertTrue(Mechanics.winCondition(board, 'X'));
    }

    @Test
    public void testWinConditionORow() {
        char[][] board = {{' ', ' ', ' '},
                {'O', 'O', 'O'},
                {' ', ' ', ' '}};


        assertTrue(Mechanics.winCondition(board, 'O'));
    }

    @Test
    public void testWinConditionXCol() {
        char[][] board = {{'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}};

        assertTrue(Mechanics.winCondition(board, 'X'));
    }

    @Test
    public void testWinConditionOCol() {
        char[][] board = {{'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}};

        assertTrue(Mechanics.winCondition(board, 'O'));
    }

    @Test
    public void testWinConditionXCross() {
        char[][] board = {{'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}};

        assertTrue(Mechanics.winCondition(board, 'X'));

        assertFalse(Mechanics.winCondition(board, 'O'));
    }

}
