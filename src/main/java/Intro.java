public class Intro {

    public static void Welcome() {
        System.out.println("Witaj w grze Kółko i Krzyżyk!");
        System.out.println("Poniżej sposób wybierania kratki.");

    }

    public static void Instruction() {
        char[][] board = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}};
        System.out.println(ConsoleColors.GREEN);
            System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " +  board[0][2] );
            System.out.println("---+---+---");
            System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " +  board[1][2] );
            System.out.println("---+---+---");
            System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " +  board[2][2] );
        System.out.println(ConsoleColors.RESET);
    }
}
