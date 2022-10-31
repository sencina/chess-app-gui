package validator.path;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;

public class TriDirectionalPathValidator extends AbstractPathValidator{

    private final CrossPathValidator crossPathValidator;
    private final DiagonalPathValidator diagonalPathValidator;

    public TriDirectionalPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
        this.crossPathValidator = new CrossPathValidator(jumper, limit, direction);
        this.diagonalPathValidator = new DiagonalPathValidator(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (movement.getFrom().getCol() == movement.getTo().getCol() || movement.getFrom().getRow() == movement.getTo().getRow()) {
            return crossPathValidator.validate(movement, board);
        } else {
            return diagonalPathValidator.validate(movement, board);
        }

    }
}
