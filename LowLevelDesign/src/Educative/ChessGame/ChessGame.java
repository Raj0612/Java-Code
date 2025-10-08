package Educative.ChessGame;

import Educative.ChessGame.accounts.Player;
import Educative.ChessGame.enums.GameStatus;
import Educative.ChessGame.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    private Player[] players;
    private Chessboard board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public ChessGame(Player whitePlayer, Player blackPlayer) {
        players = new Player[]{whitePlayer, blackPlayer};
        board = new Chessboard();
        currentTurn = whitePlayer.isWhiteSide() ? whitePlayer : blackPlayer;
        status = GameStatus.Active;
        movesPlayed = new ArrayList<>();
    }

    public boolean isOver() {
        return status != GameStatus.Active;
    }


    /**
     * Player attempts to move a piece from (startX, startY) to (endX, endY).
     * Returns true if move is successful and legal, false otherwise.
     */
    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        // 1. Check if game is over or wrong player's turn
        if (isOver() || player != currentTurn) {
            return false;
        }
        // 2. Get start and end boxes
        Box start = board.getBox(startX, startY);
        Box end = board.getBox(endX, endY);
        if (start == null || end == null) {
            return false;
        }

        // 3. Validate there is a piece at the start box
        Piece sourcePiece = start.getPiece();
        if (sourcePiece == null) {
            return false;
        }
        // 4. Validate the piece belongs to the player
        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }
        // 5. Create the move object
        Move move = new Move(player, start, end);

        // 6. Validate and make the move
        return makeMove(move, player);
    }

    /**
     * Validates and executes the move if legal.
     * Returns true if move was made, false otherwise.
     */
    private boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getPieceMoved();
        Box start = move.getStart();
        Box end = move.getEnd();

        // 1. Validate move legality using piece's canMove()
        if (!sourcePiece.canMove(board, start, end)) {
            return false;
        }

        // 2. Check if destination has a piece of the same color
        if (end.getPiece() != null && end.getPiece().isWhite() == sourcePiece.isWhite()) {
            return false;
        }

        // 3. Handle special moves (castling, promotion, en passant) here if needed

        // 4. Execute the move
        Piece targetPiece = end.getPiece();
        if (targetPiece != null) {
            targetPiece.setKilled(true);
            move.setCastlingMove(false); // You can add logic for special moves
        }
        end.setPiece(sourcePiece);
        start.setPiece(null);
//        ChessMoveController controller = new ChessMoveController();
//        if (!controller.validateMove(board, move)) return false;
        // 5. Record the move
        movesPlayed.add(move);

        // 6. Switch turn
        currentTurn = (currentTurn == players[0]) ? players[1] : players[0];

        // 7. Check for game-ending conditions (basic placeholder)
        if (isCheckmate(currentTurn)) {
            status = currentTurn.isWhiteSide() ? GameStatus.BlackWin : GameStatus.WhiteWin;
        } else if (isStalemate(currentTurn)) {
            status = GameStatus.Stalemate;
        }

        return true;
    }

    /**
     * Placeholder for checkmate logic.
     * You should implement full checkmate detection here.
     */
    private boolean isCheckmate(Player player) {
        // Implement checkmate detection logic
        return false;
    }

    /**
     * Placeholder for stalemate logic.
     * You should implement full stalemate detection here.
     */
    private boolean isStalemate(Player player) {
        // Implement stalemate detection logic
        return false;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }

    public Chessboard getBoard() {
        return board;
    }
}
