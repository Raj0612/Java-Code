package ashishps1.chessgame.pieces;

import ashishps1.chessgame.Board;
import ashishps1.chessgame.Cell;
import ashishps1.chessgame.Color;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }
    public abstract boolean isValidMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return color;
    }
}
