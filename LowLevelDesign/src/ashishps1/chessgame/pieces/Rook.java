package ashishps1.chessgame.pieces;

import ashishps1.chessgame.Board;
import ashishps1.chessgame.Cell;
import ashishps1.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}