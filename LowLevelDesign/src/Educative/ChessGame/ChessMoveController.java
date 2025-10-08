package Educative.ChessGame;

import Educative.ChessGame.pieces.Piece;

public class ChessMoveController {
    public boolean validateMove(Chessboard board, Move move) {
        // Implement move validation logic using piece's canMove()
        Piece piece = move.getPieceMoved();
        return piece != null && piece.canMove(board, move.getStart(), move.getEnd());
    }
}
