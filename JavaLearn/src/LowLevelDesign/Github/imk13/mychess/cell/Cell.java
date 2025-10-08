package LowLevelDesign.Github.imk13.mychess.cell;


import LowLevelDesign.Github.imk13.mychess.pieces.Piece;

public class Cell {
    Integer x;
    Integer y;
    Piece piece;

    public Cell(Integer x1, Integer y1, Piece newPiece){
        x = x1;
        y = y1;
        piece = newPiece;
    }

    public Piece getPiece() {
        return piece;
    }

}