package ashishps1.chessgame.pieces;

import ashishps1.chessgame.Board;
import ashishps1.chessgame.Cell;
import ashishps1.chessgame.Color;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }
    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol()- from.getCol());
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
