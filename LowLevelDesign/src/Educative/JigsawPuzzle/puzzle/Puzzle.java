package Educative.JigsawPuzzle.puzzle;

import Educative.JigsawPuzzle.components.Piece;
import Educative.JigsawPuzzle.components.Side;

import java.util.*;

public class Puzzle {
    private List<List<Piece>> board;
    private List<Piece> free; // Pieces not placed yet
    private int rows;
    private int cols;

    private static Puzzle puzzle = null;

    private Puzzle(int rows, int cols, List<Piece> pieces) {
        this.rows = rows;
        this.cols = cols;
        this.board = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Piece> row = new ArrayList<>(Collections.nCopies(cols, null));
            board.add(row);
        }
        System.out.println("Board initial " + Arrays.deepToString(board.toArray()));
        this.free = new ArrayList<>(pieces);
    }

    public static Puzzle getInstance(int rows, int cols, List<Piece> pieces) {
        if (puzzle == null) {
            puzzle = new Puzzle(rows, cols, pieces);
        }
        return puzzle;
    }

    public List<List<Piece>> getBoard() {
        return board;
    }

    public List<Piece> getFree() {
        return free;
    }

    public void insertPiece(Piece piece, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) throw new IllegalArgumentException("Invalid position");
        if (board.get(row).get(col) != null) throw new IllegalStateException("Position already occupied");
        board.get(row).set(col, piece);
        free.remove(piece);
    }

    // Check if a piece can be placed at (row, col) with its current orientation
    public boolean canPlacePiece(Piece piece, int row, int col) {
        // Check top neighbor
        if (row > 0 && board.get(row-1).get(col) != null) {
            Side thisTop = piece.getSides().get(0);
            Side neighborBottom = board.get(row-1).get(col).getSides().get(2);
            if (!thisTop.fitsWith(neighborBottom)) return false;
        }
        // Check left neighbor
        if (col > 0 && board.get(row).get(col-1) != null) {
            Side thisLeft = piece.getSides().get(3);
            Side neighborRight = board.get(row).get(col-1).getSides().get(1);
            if (!thisLeft.fitsWith(neighborRight)) return false;
        }
        // Check bottom neighbor
        if (row < rows-1 && board.get(row+1).get(col) != null) {
            Side thisBottom = piece.getSides().get(2);
            Side neighborTop = board.get(row+1).get(col).getSides().get(0);
            if (!thisBottom.fitsWith(neighborTop)) return false;
        }
        // Check right neighbor
        if (col < cols-1 && board.get(row).get(col+1) != null) {
            Side thisRight = piece.getSides().get(1);
            Side neighborLeft = board.get(row).get(col+1).getSides().get(3);
            if (!thisRight.fitsWith(neighborLeft)) return false;
        }
        return true;
    }
}
