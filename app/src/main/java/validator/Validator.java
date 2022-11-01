package validator;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.check.CheckValidator;

import java.util.Set;

public class Validator implements MovementValidator {

    private final Set<MovementValidator> validators;

    public Validator(Set<MovementValidator> validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

            for (MovementValidator validator : validators) {
                if (!validator.validate(movement, board)) {
                    return false;
                }
            }
            return true;
    }
}
