package validator.movement;

import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.movement.response.ValidatorResponse;

public class TriDirectionalMovementValidator extends AbstractValidator {

    private final MovementValidator lateralValidator;
    private final MovementValidator verticalValidator;
    private final MovementValidator diagonalValidator;

    public TriDirectionalMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
        this.lateralValidator = new LateralMovementValidator(jumper, limit, 0);
        this.verticalValidator = new StraightMovementValidator(jumper, limit, 0);
        this.diagonalValidator = new DiagonalMovementValidator(jumper, limit, 0);
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {

        if (movement.getFrom().getCol() == movement.getTo().getCol()) {
            return verticalValidator.validate(movement, board);
        } else if (movement.getFrom().getRow() == movement.getTo().getRow()) {
            return lateralValidator.validate(movement, board);
        } else {
            return diagonalValidator.validate(movement, board);
        }
    }
}
