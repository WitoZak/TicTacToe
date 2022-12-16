
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;


public class TestingMainApp {

    @Test
    public void testMakeMove() {
        // Test making a move on empty board
        // given
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        // when
        Logic.makeMove(board, "1,1", 'X');
        char[][] expectedBoard = new char[][]{{' ', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', ' '}};
        // then
        assertArrayEquals(expectedBoard, board);

        // Test making a move on a non-empty board
        // given
        board = new char[][]{{' ', ' ', 'X'},
                {' ', 'O', ' '},
                {' ', ' ', ' '}};
        // when
        Logic.makeMove(board, "0,2", 'O');
        expectedBoard = new char[][]{{' ', ' ', 'O'},
                {' ', 'O', ' '},
                {' ', ' ', ' '}};
        // then
        assertArrayEquals(expectedBoard, board);
    }
    @Test
    public void testComputerTurn() {
        // given
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        // when
        Logic.computerTurn(board);
        // then
        boolean moveMade = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    moveMade = true;
                    break;
                }
            }
        }
        assert moveMade;
    }
    @Test
    public void testIsGameOver() {
        // given
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        // when
        // then
        assertFalse(Mechanics.isGameOver(board));
    }
    @Test
    public void testValidMove() {
        // given
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        // when
        // then
        assertTrue(Logic.validMove(board, "0,0"));
        assertFalse(Logic.validMove(board, "4,4"));

    }
    @Test
    public void testWinConditionXRow() {
        // when
        char[][] board = {{'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        // then
        assertTrue(Mechanics.winCondition(board, 'X'));
    }
    @Test
    public void testWinConditionORow() {
        // when
        char[][] board = {{' ', ' ', ' '},
                {'O', 'O', 'O'},
                {' ', ' ', ' '}};
        // then
        assertTrue(Mechanics.winCondition(board, 'O'));
    }
    @Test
    public void testWinConditionXCol() {
        // when
        char[][] board = {{'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '}};
        // then
        assertTrue(Mechanics.winCondition(board, 'X'));
    }
    @Test
    public void testWinConditionOCol() {
        // when
        char[][] board = {{'O', ' ', ' '},
                {'O', ' ', ' '},
                {'O', ' ', ' '}};
        // then
        assertTrue(Mechanics.winCondition(board, 'O'));
    }
    @Test
    public void testWinConditionXCross() {
        // when
        char[][] board = {{'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}};
        // then
        assertTrue(Mechanics.winCondition(board, 'X'));
    }
    @Test
    public void testWinConditionOCross() {
        // when
        char[][] board = {{'O', 'X', 'X'},
                {'X', 'O', 'O'},
                {'X', 'X', 'O'}};
        // then
        assertTrue(Mechanics.winCondition(board, 'O'));
    }
    @Test
    public void testWinConditionOCross10x10() {
        // when
        char[][] board = {{'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        // then
        assertTrue(Mechanics.winCondition(board, 'O'));
    }
    @Test
    public void testWinConditionXCross10x10() {
        // when
        char[][] board = {{'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        // then
        assertFalse(Mechanics.winCondition(board, 'X'));
    }
}
