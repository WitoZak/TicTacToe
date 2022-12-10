import java.util.Random;
import java.util.Scanner;

public class Logic {

    static void playerOne(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String userOneInput;
        while (true) {
            System.out.println(ConsoleColors.BLUE + "Player1 jaki jest Twój ruch? --> X <--" + ConsoleColors.RESET);
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

            System.out.println(ConsoleColors.BLUE);
            makeMove(board, userOneInput, 'X');
            System.out.println(ConsoleColors.RESET);
            break;
        }
    }

    static void computerTurn(char[][] board) {
        int size = board.length;
        Random random = new Random();

        int i = random.nextInt(size);
        int j = random.nextInt(size);

        if (board[i][j] == ' ') {
            board[i][j] = 'O';
        } else {
            computerTurn(board);
        }
    }

    static boolean validMove(char[][] board, String position) {
        String[] parts = position.split(",");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
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