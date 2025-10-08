package Educative.ChessGame;

import Educative.ChessGame.pieces.Piece;

public class Box {
    private Piece piece;
    private int x;
    private int y;

    public Box(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
