import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.*;

public class TestingMainApp {

    @Test
    public void testNewGameBoard(){

        char[][] expectedGameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        char[][] testBoard = new char[3][3];
        SoutBoard.soutBoard(testBoard);
        assertTrue(Arrays.deepEquals(expectedGameBoard, testBoard));
    }
    @Test


    public void validateOWinInColumn(char[][] board, char symbol) {

    }

    public void validateOWinInCross(char[][] board, char symbol) {

    }

    public void validateXWinInRow(char[][] board, char symbol) {

    }

    public void validateXWinInColumn(char[][] board, char symbol) {

    }

    public void validateXWinInCross(char[][] board, char symbol) {

    }
    public void validateAllTies(char[][] board, char symbol) {

    }
    public void validateIsMoveValid(char[][] board, char symbol) {

    }


}
