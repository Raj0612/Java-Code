package Educative.JigsawPuzzle;

import Educative.JigsawPuzzle.components.*;
import Educative.JigsawPuzzle.enums.Edge;
import Educative.JigsawPuzzle.puzzle.*;

import java.util.*;

public class JigsawPuzzle {
    public static void main(String[] args) {
        // Define sides for each piece
        // For a 2x2 puzzle, let's define sides so that only correct matching is possible

        // Piece 0 (Top Left Corner): TOP and LEFT are FLAT, RIGHT and BOTTOM are connectors
        Piece p0 = new Piece("P0", Arrays.asList(
                new Side(Edge.FLAT, 0),     // TOP
                new Side(Edge.EXTRUSION, 1),// RIGHT
                new Side(Edge.INDENTATION, 2), // BOTTOM
                new Side(Edge.FLAT, 0)      // LEFT
        ));

        // Piece 1 (Top Right Corner): TOP and RIGHT are FLAT, LEFT and BOTTOM are connectors
        Piece p1 = new Piece("P1", Arrays.asList(
                new Side(Edge.FLAT, 0),     // TOP
                new Side(Edge.FLAT, 0),     // RIGHT
                new Side(Edge.EXTRUSION, 3),// BOTTOM
                new Side(Edge.INDENTATION, 1) // LEFT
        ));

        // Piece 2 (Bottom Left Corner): BOTTOM and LEFT are FLAT, TOP and RIGHT are connectors
        Piece p2 = new Piece("P2", Arrays.asList(
                new Side(Edge.EXTRUSION, 2),// TOP
                new Side(Edge.INDENTATION, 4), // RIGHT
                new Side(Edge.FLAT, 0),     // BOTTOM
                new Side(Edge.FLAT, 0)      // LEFT
        ));

        // Piece 3 (Bottom Right Corner): BOTTOM and RIGHT are FLAT, TOP and LEFT are connectors
        Piece p3 = new Piece("P3", Arrays.asList(
                new Side(Edge.INDENTATION, 3), // TOP
                new Side(Edge.FLAT, 0),     // RIGHT
                new Side(Edge.FLAT, 0),     // BOTTOM
                new Side(Edge.EXTRUSION, 4) // LEFT
        ));

        // List of all pieces
        List<Piece> pieces = Arrays.asList(p0, p1, p2, p3);

        // Create the puzzle instance (Singleton)
        Puzzle puzzle = Puzzle.getInstance(2, 2, pieces);

        // Solve the puzzle
        PuzzleSolver solver = new PuzzleSolver();
        boolean solved = solver.matchPieces(puzzle);

        // Print the result
        if (solved) {
            System.out.println("Puzzle solved!");
            List<List<Piece>> board = puzzle.getBoard();
            for (int i = 0; i < board.size(); i++) {
                for (int j = 0; j < board.get(i).size(); j++) {
                    Piece piece = board.get(i).get(j);
                    if (piece != null) {
                        System.out.print(piece.getPieceId() + " ");
                    } else {
                        System.out.print("null ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Puzzle could not be solved.");
        }
    }
}
