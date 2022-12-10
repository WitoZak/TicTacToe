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

    static boolean winCondition(char[][] board, char player) {
        int winLength;
        if (board.length == 3) {
            winLength = 3;
        } else {
            winLength = 5;
        }

        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == winLength) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == winLength) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int i = 0; i <= board.length - winLength; i++) {
            for (int j = 0; j <= board[i].length - winLength; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player &&
                        board[i + 3][j + 3] == player && board[i + 4][j + 4] == player) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= board.length - winLength; i++) {
            for (int j = winLength - 1; j < board[i].length; j++) {
                if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player &&
                        board[i + 3][j - 3] == player && board[i + 4][j - 4] == player) {
                    return true;
                }
            }
        }

        return false;
    }


}
