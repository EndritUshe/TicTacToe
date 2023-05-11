import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        char [][] board = {{' ',' ', ' '},
                            {' ', ' ',' '},
                             {' ',' ',' '}};
        printBoard(board);

        Scanner scanner = new Scanner(System.in);
      while (true) {
          playerMove(board, scanner);
         if(isGameFinished(board)){
             break;
         }
          computerMove(board);
          printBoard(board);
      }
      scanner.close();
    }

    private static boolean isGameFinished(char [][] board) {
       if(hasContestantWon(board, 'X')){
            printBoard(board);
           System.out.println("The player has won.");
           return true;
       }

        if(hasContestantWon(board, 'O')){
            printBoard(board);
            System.out.println("The computer has won.");
            return true;
        }

        for(int i = 0; i< board.length; i++){
        for(int j =0; j <board[i].length; j ++)
            if (board[i][j] == ' ') {
                return false;
            }
    }
        System.out.println("The game ends in a tie.");
    printBoard(board);

        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol )||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol )||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol )||
                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol )||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol )||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol )||
                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol )||
                (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol )
        ){
     return true;

        }
        return false;
    }

    private static void computerMove(char[][] board) {
        Random random = new Random();
        int computerMove;
        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }

            System.out.println("Computer chose " + computerMove);
            placeMove(board, Integer.toString(computerMove), 'O');

    }

    private static boolean isValidMove(char [][] board, String position){
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
    private static void playerMove(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("What place would you like to put? (1-9)");
            userInput = scanner.nextLine();
            if(isValidMove(board, (userInput))){
                break;
            }
            else {
                System.out.println("Wrong move buddy.");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
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
            default -> System.out.println("Wrong input buddy.");

        }
    }
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+ "|" + board[0][1]+ "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+ "|" + board[1][1]+ "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+ "|" + board[2][1]+ "|" + board[2][2]);
    }
}