package Educative.ChessGame;


import Educative.ChessGame.accounts.Player;

public class ChessGameView {

    ChessGame game;
    public void playMove(ChessGame game, Player player, int startX, int startY, int endX, int endY) {
       boolean result = game.playerMove(player, startX, startY, endX, endY);
        // Implement UI update logic after the move
    }

    public ChessGame getGame() {
        return game;
    }

    public void setGame(ChessGame game) {
        this.game = game;
    }
}
