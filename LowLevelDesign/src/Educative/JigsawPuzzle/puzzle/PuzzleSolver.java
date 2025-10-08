package Educative.JigsawPuzzle.puzzle;

import Educative.JigsawPuzzle.components.Piece;

import java.util.*;

public class PuzzleSolver {
    public boolean matchPieces(Puzzle puzzle) {
        return solve(puzzle, 0, 0);
    }

    private boolean solve(Puzzle puzzle, int row, int col) {
        int rows = puzzle.getBoard().size();
        int cols = puzzle.getBoard().get(0).size();
        if (row == rows) return true; // Solved

        int nextRow = col == cols - 1 ? row + 1 : row;
        int nextCol = col == cols - 1 ? 0 : col + 1;

        if (puzzle.getBoard().get(row).get(col) != null) {
            return solve(puzzle, nextRow, nextCol);
        }

      //  for (Piece piece : new ArrayList<>(puzzle.getFree())) {
        for (Piece piece : puzzle.getFree()) {
            for (int rotation = 0; rotation < 4; rotation++) {
                if (puzzle.canPlacePiece(piece, row, col)) {
                    puzzle.insertPiece(piece, row, col);
                    if (solve(puzzle, nextRow, nextCol)) return true;
                    // Backtrack
                    puzzle.getBoard().get(row).set(col, null);
                    puzzle.getFree().add(piece);
                }
                piece.rotate();
            }
        }
        return false;
    }
}
