package game.exceptions;

public class NoPieceException extends Exception {
    public NoPieceException() {
        super("There is no piece in the position");
    }
}
