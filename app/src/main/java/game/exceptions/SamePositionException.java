package game.exceptions;

public class SamePositionException extends Exception {
    public SamePositionException() {
        super("The piece is already in the position");
    }
}

