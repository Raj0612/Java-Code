package Educative.ChessGame.pieces;

import Educative.ChessGame.Box;
import Educative.ChessGame.Chessboard;

public class Rook extends Piece {
    private boolean hasMoved = false;

    public Rook(boolean white) {
        super(white);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean moved) {
        this.hasMoved = moved;
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        // Rook moves in straight lines: either same row or same column
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Must move in a straight line and not stay in the same place
        if (startX != endX && startY != endY) {
            return false;
        }
        if (startX == endX && startY == endY) {
            return false;
        }

        // Check for obstacles between start and end (exclusive)
        if (startY == endY) { // Moving vertically
            int step = (startX < endX) ? 1 : -1;
            for (int x = startX + step; x != endX; x += step) {
                if (board.getBox(x, startY).getPiece() != null) {
                    return false; // Path blocked
                }
            }
        } else { // Moving horizontally
            int step = (startY < endY) ? 1 : -1;
            for (int y = startY + step; y != endY; y += step) {
                if (board.getBox(startX, y).getPiece() != null) {
                    return false; // Path blocked
                }
            }
        }

        // Destination must be empty or occupied by opponent
        return end.getPiece() == null || end.getPiece().isWhite() != this.isWhite();
    }
}
