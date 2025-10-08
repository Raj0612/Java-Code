package Educative.ChessGame;

import Educative.ChessGame.pieces.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chessboard {
    private Box[][] boxes;
    private Date creationDate;

    public Chessboard() {
        this.creationDate = new Date();
        boxes = new Box[8][8];
        resetBoard();
    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = boxes[i][j].getPiece();
                if (p != null && !p.isKilled()) {
                    pieces.add(p);
                }
            }
        }
        return pieces;
    }

    public void resetBoard() {
        boxes = new Box[8][8];
        // Place Black pieces (top of the board, rows 0 and 1)
        boxes[0][0] = new Box(0, 0, new Rook(false));
        boxes[0][1] = new Box(0, 1, new Knight(false));
        boxes[0][2] = new Box(0, 2, new Bishop(false));
        boxes[0][3] = new Box(0, 3, new Queen(false));
        boxes[0][4] = new Box(0, 4, new King(false));
        boxes[0][5] = new Box(0, 5, new Bishop(false));
        boxes[0][6] = new Box(0, 6, new Knight(false));
        boxes[0][7] = new Box(0, 7, new Rook(false));
        for (int j = 0; j < 8; j++) {
            boxes[1][j] = new Box(1, j, new Pawn(false));
        }


        // Place White pieces (bottom of the board, rows 7 and 6)
        boxes[7][0] = new Box(7, 0, new Rook(true));
        boxes[7][1] = new Box(7, 1, new Knight(true));
        boxes[7][2] = new Box(7, 2, new Bishop(true));
        boxes[7][3] = new Box(7, 3, new Queen(true));
        boxes[7][4] = new Box(7, 4, new King(true));
        boxes[7][5] = new Box(7, 5, new Bishop(true));
        boxes[7][6] = new Box(7, 6, new Knight(true));
        boxes[7][7] = new Box(7, 7, new Rook(true));
        for (int j = 0; j < 8; j++) {
            boxes[6][j] = new Box(6, j, new Pawn(true));
        }

        // Fill the rest of the board with empty boxes (no pieces)
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Box(i, j, null);
            }
        }
    }

    public void updateBoard() {
        // Logic to update board after a move (if needed)
    }

    public Box getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) return null;
        return boxes[x][y];
    }
}
