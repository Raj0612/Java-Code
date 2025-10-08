package LowLevelDesign.Github.imk13.mychess.pieces;

import LowLevelDesign.Github.imk13.mychess.cell.Cell;
import LowLevelDesign.Github.imk13.mychess.enums.PieceColor;

public abstract class Piece {
    private Boolean isAlive = true;
    private PieceColor pieceColor;
  
	public Piece(PieceColor newPieceColor) {
        pieceColor = newPieceColor;
	}
	public abstract Boolean canMove(Cell from, Cell to);
}