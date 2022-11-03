package validation.movementValidor;


import game.status.GameStatus;
import game.movement.Movement;

public interface MovementValidator {

    boolean validate(Movement movement, GameStatus status) throws Exception;
}
