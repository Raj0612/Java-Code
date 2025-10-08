package Educative.ChessGame.pieces;

import Educative.ChessGame.Box;
import Educative.ChessGame.Chessboard;

public abstract  class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }
    public boolean isKilled() {
        return killed;
    }
    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Chessboard board, Box start, Box end);
}
