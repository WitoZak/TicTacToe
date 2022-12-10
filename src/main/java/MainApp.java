import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Intro.welcome();
        Intro.instruction();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Na jakiej planszy chcesz grać (3x3 or 10x10):");
        String dimensions = scanner.nextLine();


        char[][] board;
        if (dimensions.equals("3x3")) {
            board = new char[][]{{' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};
        } else if (dimensions.equals("10x10")) {
            board = new char[][]{{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        } else {
            System.out.println("Nie ma takiej planszy. Używam domyślnej planszy 3x3.");
            board = new char[][]{{' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};
        }
        SoutBoard.soutBoard(board);

        while (true) {

            Logic.playerOne(board);
            if (Mechanics.isGameOver(board)) {
                break;
            }
            SoutBoard.soutBoard(board);

            Logic.computerTurn(board);
            if (Mechanics.isGameOver(board)) {
                break;
            }
            SoutBoard.soutBoard(board);
        }
    }

}