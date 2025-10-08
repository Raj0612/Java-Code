package Educative.ChessGame.pieces;

import Educative.ChessGame.Box;
import Educative.ChessGame.Chessboard;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);

        // Queen moves like a rook or a bishop
        if (dx == dy) { // Diagonal movement (like Bishop)
            int xDirection = (endX > startX) ? 1 : -1;
            int yDirection = (endY > startY) ? 1 : -1;
            int x = startX + xDirection;
            int y = startY + yDirection;
            while (x != endX && y != endY) {
                if (board.getBox(x, y).getPiece() != null) {
                    return false; // Path blocked
                }
                x += xDirection;
                y += yDirection;
            }
            // Destination must be empty or occupied by opponent
            return end.getPiece() == null || end.getPiece().isWhite() != this.isWhite();
        } else if (startX == endX || startY == endY) { // Straight line (like Rook)
            if (startX == endX) { // Vertical
                int step = (endY > startY) ? 1 : -1;
                for (int y = startY + step; y != endY; y += step) {
                    if (board.getBox(startX, y).getPiece() != null) {
                        return false; // Path blocked
                    }
                }
            } else { // Horizontal
                int step = (endX > startX) ? 1 : -1;
                for (int x = startX + step; x != endX; x += step) {
                    if (board.getBox(x, startY).getPiece() != null) {
                        return false; // Path blocked
                    }
                }
            }
            // Destination must be empty or occupied by opponent
            return end.getPiece() == null || end.getPiece().isWhite() != this.isWhite();
        }

        // Not a valid Queen move
        return false;
    }
}
