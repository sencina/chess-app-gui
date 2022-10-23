package interfaces;

import game.movements.Movement;
import validator.movement.response.ValidatorResponse;

public interface MovementValidator {

    public ValidatorResponse validate(Movement movement, Board board);

}
