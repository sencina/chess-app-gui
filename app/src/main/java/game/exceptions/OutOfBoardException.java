package game.exceptions;

public class OutOfBoardException extends Exception {
    public OutOfBoardException() {
        super("The position is out of the board");
    }
}
