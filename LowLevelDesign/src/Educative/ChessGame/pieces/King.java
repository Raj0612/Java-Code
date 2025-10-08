package Educative.ChessGame.pieces;

import Educative.ChessGame.Box;
import Educative.ChessGame.Chessboard;

public class King extends Piece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white);
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }
    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Chessboard board, Box start, Box end) {
        int dx = Math.abs(start.getX() - end.getX());
        int dy = Math.abs(start.getY() - end.getY());

        // Standard one-square move in any direction
        if ((dx <= 1 && dy <= 1) && (dx + dy > 0)) {
            return end.getPiece() == null || end.getPiece().isWhite() != this.isWhite();
        }

        // Castling: king moves two squares horizontally from its original position
        // For white: from (7,4) to (7,6) or (7,2)
        // For black: from (0,4) to (0,6) or (0,2)
        if (!castlingDone && dy == 0 && dx == 2) {
            int row = start.getX();
            boolean isWhite = this.isWhite();

            // King must be on original square
            if ((isWhite && row == 7 && start.getY() == 4) || (!isWhite && row == 0 && start.getY() == 4)) {
                // King-side castling
                if (end.getY() == 6) {
                    // Check squares between king and rook are empty
                    if (board.getBox(row, 5).getPiece() == null && board.getBox(row, 6).getPiece() == null) {
                        // Check rook exists and hasn't moved (you need to track rook movement)
                        Piece rook = board.getBox(row, 7).getPiece();
                        if (rook instanceof Rook && !((Rook)rook).hasMoved() && rook.isWhite() == isWhite) {
                            // TODO: Check king is not in check, and does not pass through check[4][5]
                            return true;
                        }
                    }
                }
                // Queen-side castling
                if (end.getY() == 2) {
                    if (board.getBox(row, 3).getPiece() == null && board.getBox(row, 2).getPiece() == null && board.getBox(row, 1).getPiece() == null) {
                        Piece rook = board.getBox(row, 0).getPiece();
                        if (rook instanceof Rook && !((Rook)rook).hasMoved() && rook.isWhite() == isWhite) {
                            // TODO: Check king is not in check, and does not pass through check[4][5]
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}

