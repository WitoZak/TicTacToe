import java.util.Scanner;

public class Logic {

    static void playerOne(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String userOneInput;
        while (true) {
            System.out.println(ConsoleColors.BLUE + "Player1 jaki jest Twój ruch? --> X <--" + ConsoleColors.RESET);
            userOneInput = scanner.nextLine();
            if (validMove(board, userOneInput)) {
                break;
            } else {
                System.out.println(userOneInput + " jest niedozwolonym ruchem");
            }
        }
        System.out.println(ConsoleColors.BLUE);
        makeMove(board, userOneInput, 'X');
        System.out.println(ConsoleColors.RESET);
    }

    static void playerTwo(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        String userTwoInput;
        while (true) {
            System.out.println(ConsoleColors.RED + "Player2 jaki jest Twój ruch? --> O <--" + ConsoleColors.RESET);
            userTwoInput = scanner.nextLine();
            if (validMove(board, userTwoInput)) {
                break;
            } else {
                System.out.println(userTwoInput + " jest niedozwolonym ruchem");
            }
        }
        System.out.println(ConsoleColors.RED);
        makeMove(board, userTwoInput, 'O');
        System.out.println(ConsoleColors.RESET);
    }

    static boolean validMove(char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    static void makeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println("Wybierz inne pole");
        }
    }
}
