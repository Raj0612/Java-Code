package Educative.ChessGame;

import Educative.ChessGame.accounts.Player;
import Educative.ChessGame.pieces.Piece;

public class Move {
    private Box start;
    private Box end;
    private Piece pieceKilled;
    private Piece pieceMoved;
    private Player player;
    private boolean castlingMove = false;

    public Move(Player player, Box start, Box end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.pieceKilled = end.getPiece();
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }
    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }
    public Piece getPieceMoved() {
        return pieceMoved;
    }
    public Piece getPieceKilled() {
        return pieceKilled;
    }
    public Box getStart() {
        return start;
    }
    public Box getEnd() {
        return end;
    }
    public Player getPlayer() {
        return player;
    }
}
