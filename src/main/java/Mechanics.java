public class Mechanics {

    static boolean isGameOver(char[][] board) {
        if (winCondition(board, 'X')) {
            SoutBoard.soutBoard(board);
            System.out.println(ConsoleColors.BLUE + "Player1 wygrał!" + ConsoleColors.RESET);
            return true;
        }

        if (winCondition(board, 'O')) {
            SoutBoard.soutBoard(board);
            System.out.println(ConsoleColors.RED + "Komputer wygrał!" + ConsoleColors.RESET);
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

    public static boolean winCondition(char[][] board, char player) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
            if (count == (size == 3 ? 3 : 5)) {
                return true;
            }
        }

        for (int j = 0; j < size; j++) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
            if (count == (size == 3 ? 3 : 5)) {
                return true;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == player) {
                count++;
            }
        }
        if (count == (size == 3 ? 3 : 5)) {
            return true;
        }

        count = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == player) {
                count++;
            }
        }
        return count == (size == 3 ? 3 : 5);
    }

}
