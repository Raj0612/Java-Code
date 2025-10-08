package LowLevelDesign.Github.imk13.mychess.move;

import LowLevelDesign.Github.imk13.mychess.cell.Cell;

import java.util.ArrayList;


public class Moves {
    private ArrayList<Cell> moves = null;

    public Moves(){
        moves = new ArrayList<>();
    }

    public void addMove(Cell move){
        moves.add(move);
    }

    public ArrayList<Cell> getMoves(){
       return moves;
    }

}