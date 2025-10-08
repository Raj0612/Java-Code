package LowLevelDesign.Github.imk13.mychess.pieces;


import LowLevelDesign.Github.imk13.mychess.cell.Cell;
import LowLevelDesign.Github.imk13.mychess.enums.PieceColor;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Pawn");
        return true;
    }
}