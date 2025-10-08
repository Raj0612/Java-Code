package Educative.ChessGame;

import Educative.ChessGame.accounts.Player;

public class ChessGameDemo {

    public static void main(String[] args) {
        Person whitePerson = new Person("Jane Doe", "123 Main St", "Boston", "MA", 12345, "USA");
        Person blackPerson = new Person("Jane Doe1", "123 Main St", "Boston", "MA", 12345, "USA");

        Player whitePlayer = new Player(whitePerson, true);
        Player blackPlayer = new Player(blackPerson, false);

        ChessGame game = new ChessGame(whitePlayer, blackPlayer);

        // Optionally: Print the initial board (implement toString in Chessboard/Box for pretty printing)
        // System.out.println(game.getBoard());

        boolean move1 = game.playerMove(whitePlayer, 6, 4, 4, 4);
        System.out.println("White pawn e2 to e4: " + (move1 ? "Success" : "Invalid"));

        boolean move2 = game.playerMove(blackPlayer, 1, 4, 3, 4);
        System.out.println("Black pawn e7 to e5: " + (move2 ? "Success" : "Invalid"));

        // Add more moves as desired, or loop for user input
        if (game.isOver()) {
            System.out.println("Game over! Status: " + game.getStatus());
        } else {
            System.out.println("Game in progress. Next turn: " +
                    (game.getCurrentTurn().isWhiteSide() ? "White" : "Black"));
        }
    }
}
