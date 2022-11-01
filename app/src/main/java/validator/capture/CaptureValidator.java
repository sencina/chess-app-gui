package validator.capture;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class CaptureValidator implements MovementValidator {


    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (!board.isOccupied(movement.getTo())) {
            return true;
        } else if (board.isOccupied(movement.getTo()) && movement.getTo().getPiece().getColour() != movement.getFrom().getPiece().getColour()) {
            return true;}
        return false;
    }
}

