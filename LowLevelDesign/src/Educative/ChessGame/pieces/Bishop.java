package Educative.ChessGame.pieces;

import Educative.ChessGame.Box;
import Educative.ChessGame.Chessboard;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());

        // Must be a diagonal move
        if (dx != dy) {
            return false;
        }

        int xDirection = (end.getX() - start.getX()) > 0 ? 1 : -1;
        int yDirection = (end.getY() - start.getY()) > 0 ? 1 : -1;

        int x = start.getX() + xDirection;
        int y = start.getY() + yDirection;

        // Check every square between start and end (exclusive) for obstacles
        while (x != end.getX() && y != end.getY()) {
            if (board.getBox(x, y).getPiece() != null) {
                return false; // Path is blocked
            }
            x += xDirection;
            y += yDirection;
        }

        // Destination is either empty or occupied by opponent
        return end.getPiece() == null || end.getPiece().isWhite() != this.isWhite();

    }
}
