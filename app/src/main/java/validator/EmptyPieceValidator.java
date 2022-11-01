package validator;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class EmptyPieceValidator implements MovementValidator {

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {
        throw new InvalidMovementException("Can't move an empty piece");
    }

}
