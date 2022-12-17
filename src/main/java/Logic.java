import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    static void playerOne(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String userOneInput;
        while (true) {
            System.out.println("Player1 jaki jest Twój ruch? --> X <--");
            userOneInput = scanner.nextLine();

            if (!validMove(board, userOneInput)) {
                System.out.println(userOneInput + " jest niedozwolonym ruchem");
                continue;
            }

            int row = Integer.parseInt(userOneInput.split(",")[0]);
            int col = Integer.parseInt(userOneInput.split(",")[1]);
            if (board[row][col] != ' ') {
                System.out.println("To pole jest już zajęte");
                continue;
            }

            makeMove(board, userOneInput, 'X');
            break;
        }
    }

    static void computerTurn(char[][] board) {
        /*
        int size = board.length;
        Random random = new Random();

        int i = random.nextInt(size);
        int j = random.nextInt(size);

        if (board[i][j] == ' ') {
            board[i][j] = 'O';
        } else {
            computerTurn(board);
        }
        */
        List<int[]> availableMoves = getAvailableMoves(board);
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;
        for (int[] move : availableMoves) {
            board[move[0]][move[1]] = 'O';
            int score = minimax(board, 0, false);
            board[move[0]][move[1]] = ' ';
            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }
        }
        board[bestMove[0]][bestMove[1]] = 'O';
    }

    public static int minimax(char[][] board, int depth, boolean isMaximizingPlayer) {
        if (Mechanics.hasWon(board, 'X')) {
            return -1;
        }
        if (Mechanics.hasWon(board, 'O')) {
            return 1;
        }
        if (Mechanics.isDraw(board)) {
            return 0;
        }

        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            List<int[]> availableMoves = getAvailableMoves(board);
            for (int[] move : availableMoves) {
                board[move[0]][move[1]] = 'O';
                int score = minimax(board, depth + 1, false);
                board[move[0]][move[1]] = ' ';
                bestScore = Math.max(score, bestScore);
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            List<int[]> availableMoves = getAvailableMoves(board);
            for (int[] move : availableMoves) {
                board[move[0]][move[1]] = 'X';
                int score = minimax(board, depth + 1, true);
                board[move[0]][move[1]] = ' ';
                bestScore = Math.min(score, bestScore);
            }
            return bestScore;
        }
    }
    private static List<int[]> getAvailableMoves(char[][] board) {
        List<int[]> availableMoves = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    availableMoves.add(new int[] {i, j});
                }
            }
        }

        return availableMoves;
    }


    static boolean validMove(char[][] board, String position) {
        int row = Integer.parseInt(position.split(",")[0]);
        int col = Integer.parseInt(position.split(",")[1]);

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        return board[row][col] == ' ';
    }


    static void makeMove(char[][] board, String position, char symbol) {
        int row, col;

        String[] parts = position.split(",");
        if (parts.length != 2) {
            System.out.println(position + "jest niedozwolonym ruchem");
            return;
        }

        try {
            row = Integer.parseInt(parts[0]);
            col = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println(position + "jest niedozwolonym ruchem");
            return;
        }

        if (row < 0 || row >= 10 || col < 0 || col >= 10) {
            System.out.println(position + "jest niedozwolonym ruchem");
            return;
        }

        board[row][col] = symbol;
    }

}