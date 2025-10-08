
package LowLevelDesign.Github.imk13.mychess.pieces;

import LowLevelDesign.Github.imk13.mychess.cell.Cell;
import LowLevelDesign.Github.imk13.mychess.enums.PieceColor;

public class Bishop extends Piece{

    public Bishop(PieceColor pieceColor){
        super(pieceColor);
    }

    @Override
    public Boolean canMove(Cell from, Cell to) {
        System.out.println("Moving Bishop");
        return true;
    }
};