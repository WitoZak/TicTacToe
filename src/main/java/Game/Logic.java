package Game;

import static Game.TileBoard.isGameOver;
import static Game.TileBoard.tiles;

public class Logic {
    public static void checkForWinner() {
        isDraw();
        diagonalOneHasWon();
        diagonalTwoHasWon();
        colsHasWon();
        rowsHasWon();
    }

    private static void isDraw() {
        if (!isGameOver) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (tiles[row][col].getValue().isEmpty()) {
                        return;
                    }
                }
            }
            isGameOver = true;
            InfoCenter.updateMessage("It's a draw");
            InfoCenter.showStartButton();
        }
    }

    private static void diagonalOneHasWon() {
        if (!isGameOver) {
            if (tiles[0][0].getValue().equals(tiles[1][1].getValue())
                    && tiles[1][1].getValue().equals(tiles[2][2].getValue())
                    && !tiles[0][0].getValue().isEmpty()) {
                String winner = tiles[0][0].getValue();
                endGame(winner);
                return;
            }
        }
    }

    private static void diagonalTwoHasWon() {
        if (!isGameOver) {
            if (tiles[0][2].getValue().equals(tiles[1][1].getValue())
                    && tiles[1][1].getValue().equals(tiles[2][0].getValue())
                    && !tiles[0][2].getValue().isEmpty()) {
                String winner = tiles[0][2].getValue();
                endGame(winner);
                return;
            }
        }
    }

    private static void colsHasWon() {
        if (!isGameOver) {
            for (int col = 0; col < 3; col++) {
                if (tiles[0][col].getValue().equals(tiles[1][col].getValue())
                        && tiles[1][col].getValue().equals(tiles[2][col].getValue())
                        && !tiles[0][col].getValue().isEmpty()) {
                    String winner = tiles[0][col].getValue();
                    endGame(winner);
                    return;
                }
            }
        }
    }

    private static void rowsHasWon() {
        if (!isGameOver) {
            for (int row = 0; row < 3; row++) {
                if (tiles[row][0].getValue().equals(tiles[row][1].getValue())
                        && tiles[row][1].getValue().equals(tiles[row][2].getValue())
                        && !tiles[row][0].getValue().isEmpty()) {
                    String winner = tiles[row][0].getValue();
                    endGame(winner);
                    return;
                }
            }
        }
    }

    private static void endGame(String winner) {
        isGameOver = true;
        InfoCenter.updateMessage("Player " + winner + " wins");
        InfoCenter.showStartButton();
    }

}


    /*
    public static void computerMove() {
        if (isGameOver) {
            return;
        }
        // Use minimax to determine the best move
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (tiles[row][col].getValue().isEmpty()) {
                    // Make a move
                    tiles[row][col].setValue("O");
                    // Evaluate the score
                    int score = minimax('X');
                    // Undo the move
                    tiles[row][col].setValue("");
                    // Update the best score and move
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }
        }
        // Make the best move
        tiles[bestRow][bestCol].setValue("O");
        char playerTurn = 'X';
        checkForWinner();
    }


    private static int minimax(char player) {
        // Check for a winner
        if (diagonalHasWon()) {
            return (player == 'O') ? 1 : -1;
        }
        if (colsHasWon()) {
            return (player == 'O') ? 1 : -1;
        }
        if (rowsHasWon()) {
            return (player == 'O') ? 1 : -1;
        }
        // Check for a draw
        if (isDraw()) {
            return 0;
        }
        // Recursive case: try all possible moves
        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (tiles[row][col].getValue().isEmpty()) {
                    // Make a move
                    tiles[row][col].setValue(String.valueOf(player));
                    // Recurse and get the score
                    int score = minimax(player == 'O' ? 'X' : 'O');
                    // Undo the move
                    tiles[row][col].setValue("");
                    // Update the best score
                    if (player == 'O') {
                        bestScore = Math.max(bestScore, score);
                    } else {
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }
        return bestScore;
    }

      */
