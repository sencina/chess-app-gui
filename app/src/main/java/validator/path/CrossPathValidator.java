package validator.path;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;

public class CrossPathValidator extends AbstractPathValidator{

    private final LateralPathValidator lateralPathValidator;
    private final StraightPathValidator straightPathValidator;

    protected CrossPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
        this.lateralPathValidator = new LateralPathValidator(jumper, limit, direction);
        this.straightPathValidator = new StraightPathValidator(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (movement.getFrom().getCol() == movement.getTo().getCol()) {
            return straightPathValidator.validate(movement, board);
        } else if (movement.getFrom().getRow() == movement.getTo().getRow()) {
            return lateralPathValidator.validate(movement, board);
        } else {
            throw new InvalidMovementException("Invalid movement");
        }
    }
}
