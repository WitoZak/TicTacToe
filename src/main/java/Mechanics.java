public class Mechanics {

    static boolean isGameOver(char[][] board) {
        if (winCondition(board, 'X')) {
            SoutBoard.soutBoard(board);
            System.out.println(ConsoleColors.BLUE + "Player1 wygrał!" + ConsoleColors.RESET);
            return true;
        }

        if (winCondition(board, 'O')) {
            SoutBoard.soutBoard(board);
            System.out.println(ConsoleColors.RED + "Player2 wygrał!" + ConsoleColors.RESET);
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        SoutBoard.soutBoard(board);
        System.out.println("Gra zakończyła się remisem");
        return true;
    }

     static boolean winCondition(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

}