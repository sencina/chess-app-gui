package validator;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import interfaces.VictoryValidator;
import validator.path.AbstractPathValidator;

public class Validator implements MovementValidator {

    private final MovementValidator pathValidator;
    private final MovementValidator captureValidator;
    private final MovementValidator checkValidator;

    public Validator(MovementValidator pathValidator, MovementValidator captureValidator, CheckValidator checkValidator) {
        this.pathValidator = pathValidator;
        this.captureValidator = captureValidator;
        this.checkValidator = checkValidator;
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {
        return pathValidator.validate(movement, board) && captureValidator.validate(movement, board) && !checkValidator.validate(movement, board);
    }
}
