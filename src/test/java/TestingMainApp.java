
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestingMainApp {

    @Test
    public void validateOWinInColumn() {
        char[][] testBoard = new char[3][3];
        Logic instance = new Logic();
        Mechanics winner = new Mechanics();
        instance.makeMove(testBoard, "1", 'O');
        instance.makeMove(testBoard, "2", 'X');
        instance.makeMove(testBoard, "4", 'O');
        instance.makeMove(testBoard, "3", 'X');
        instance.makeMove(testBoard, "7", 'O');

        assertTrue(winner.winCondition(testBoard, 'O'));
    }

}
