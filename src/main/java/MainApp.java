
public class MainApp {
    public static void main(String[] args) {

        Intro.Welcome();
        Intro.Instruction();

        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        while (true) {
            Logic.playerOne(board);
            if (Mechanics.isGameOver(board)) {
                break;
            }
            SoutBoard.soutBoard(board);

            /*Logic.playerTwo(board);
            if (Mechanics.isGameOver(board)) {
                break;
            }
            SoutBoard.soutBoard(board);*/

            Logic.computerTurn(board);
            if (Mechanics.isGameOver(board)) {
                break;
            }
            SoutBoard.soutBoard(board);
        }
    }

}