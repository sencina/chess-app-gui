package interfaces;

import exception.InvalidMovementException;
import game.movements.Movement;

public interface MovementValidator {

    public boolean validate(Movement movement, Board board) throws InvalidMovementException;

}
