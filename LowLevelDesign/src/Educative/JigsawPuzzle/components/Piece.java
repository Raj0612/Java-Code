package Educative.JigsawPuzzle.components;

import Educative.JigsawPuzzle.enums.Edge;

import java.time.LocalDate;
import java.util.*;

public class Piece {
    private final String pieceId;
    // Sides ordered as: TOP, RIGHT, BOTTOM, LEFT
    private List<Side> sides;
    private LocalDate createdDate;

    public Piece(String pieceId, List<Side> sides) {
        if (sides == null || sides.size() != 4) throw new IllegalArgumentException("Must have 4 sides");
        this.pieceId = pieceId;
        this.sides = new ArrayList<>(sides);
        this.createdDate = LocalDate.now();
    }

    public String getPieceId() {
        return pieceId;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void setSides(List<Side> sides) {
        if (sides == null || sides.size() != 4) throw new IllegalArgumentException("Must have 4 sides");
        this.sides = new ArrayList<>(sides);
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    // Rotate piece 90 degrees clockwise
    public void rotate() {
        // Move last side to front (LEFT -> TOP, TOP -> RIGHT, etc.)
        Side last = sides.remove(3);
        sides.add(0, last);
    }

    // Check if piece is a corner (two adjacent FLAT sides)
    public boolean isCorner() {
        int flatCount = 0;
        for (Side s : sides) {
            if (s.getEdge() == Edge.FLAT) flatCount++;
        }
        if (flatCount != 2) return false;
        // Check if flats are adjacent (positions 0-1, 1-2, 2-3, 3-0)
        for (int i = 0; i < 4; i++) {
            if (sides.get(i).getEdge() == Edge.FLAT &&
                    sides.get((i+1)%4).getEdge() == Edge.FLAT) {
                return true;
            }
        }
        return false;
    }

    // Check if piece is an edge (one FLAT side)
    public boolean isEdge() {
        int flatCount = 0;
        for (Side s : sides) {
            if (s.getEdge() == Edge.FLAT) flatCount++;
        }
        return flatCount == 1;
    }

    // Middle: no FLAT sides
    public boolean isMiddle() {
        for (Side s : sides) {
            if (s.getEdge() == Edge.FLAT) return false;
        }
        return true;
    }
}
