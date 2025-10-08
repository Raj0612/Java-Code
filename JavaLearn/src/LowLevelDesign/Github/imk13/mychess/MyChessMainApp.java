package LowLevelDesign.Github.imk13.mychess;


import LowLevelDesign.Github.imk13.mychess.player.Player;

public class MyChessMainApp {
    public static void main(String[] args) {
        System.out.println("Initializing MyChess.com...");
        Player whitePlayer = new Player("Mike", true);
        Player blackPlayer = new Player("John", false);
        try {
            ChessGame.startGame(whitePlayer, blackPlayer);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}