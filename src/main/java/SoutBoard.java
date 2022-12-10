public class SoutBoard {
    public static void soutBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                for (int j = 0; j < board[i].length; j++) {
                    if (j < board[i].length - 1) {
                        System.out.print("---+");
                    } else {
                        System.out.print("---");
                    }
                }
                System.out.println();
            }
        }
    }
}