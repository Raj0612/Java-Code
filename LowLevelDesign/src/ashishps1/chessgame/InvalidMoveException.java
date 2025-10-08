package ashishps1.chessgame;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(final String message) {
        super(message);
    }
}
