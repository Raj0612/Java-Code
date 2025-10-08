package LowLevelDesign.Github.imk13.mychess.pieces;

import LowLevelDesign.Github.imk13.mychess.cell.Cell;
import LowLevelDesign.Github.imk13.mychess.enums.PieceColor;
public class Rook extends Piece{
    private Boolean isCastled;

    public Rook(PieceColor pieceColor){
        super(pieceColor);
        isCastled = false;
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Rook");
        return true;
    }

    public Boolean getIsCastled(){
        return isCastled;
    }

    public void setIsCastled() {
        isCastled = true;
    }
}