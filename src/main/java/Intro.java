import java.util.Scanner;

public class Intro {

    public static void welcome() {
        System.out.println("Witaj w grze Kółko i Krzyżyk!");
        System.out.println("Poniżej sposób wybierania kratki.");

    }

    public static void instruction() {
        String[][] board = {{"0,0", "0,1", "0,2", "0,3", "0,4", "...", "0,9"},
                {"1,0", "1,1", "1,2", "1,3", "1,4", "...", "0,9"},
                {"2,0", "2,1", "2,2", "2,3", "2,4", "...", "0,9"},
                {"3,0", "3,1", "3,2", "3,3", "3,4", "...", "0,9"},
                {"4,0", "4,1", "4,2", "4,3", "4,4", "...", "0,9"},
                {"...", "...", "...", "...", "...", "...", "..."},
                {"9,0", "9,1", "9,2", "9,3", "9,4", "...", "9,9"}};
        System.out.println(ConsoleColors.GREEN);
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " +  board[0][2] + " " + board[0][3] + " | " + board[0][4] + " | " +  board[0][5] + " | " +  board[0][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " +  board[1][2] + " " + board[1][3] + " | " + board[1][4] + " | " +  board[1][5] + " | " +  board[1][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " +  board[2][2] + " " + board[2][3] + " | " + board[2][4] + " | " +  board[2][5] + " | " +  board[2][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[3][0] + " | " + board[3][1] + " | " +  board[3][2] + " " + board[3][3] + " | " + board[3][4] + " | " +  board[3][5] + " | " +  board[3][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[4][0] + " | " + board[4][1] + " | " +  board[4][2] + " " + board[4][3] + " | " + board[4][4] + " | " +  board[4][5] + " | " +  board[4][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[5][0] + " | " + board[5][1] + " | " +  board[5][2] + " " + board[5][3] + " | " + board[5][4] + " | " +  board[5][5] + " | " +  board[5][6]);
        System.out.println("-----+-----+-----+-----+-----+-----+-----");
        System.out.println(" " + board[6][0] + " | " + board[6][1] + " | " +  board[6][2] + " " + board[6][3] + " | " + board[6][4] + " | " +  board[6][5] + " | " +  board[6][6]);
        System.out.println(ConsoleColors.RESET);
    }

}