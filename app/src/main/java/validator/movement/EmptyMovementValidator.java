package validator.movement;

import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.movement.response.ValidatorResponse;

public class EmptyMovementValidator implements MovementValidator {


    @Override
    public ValidatorResponse validate(Movement movement, Board board) {
        return new ValidatorResponse(false);
    }
}
