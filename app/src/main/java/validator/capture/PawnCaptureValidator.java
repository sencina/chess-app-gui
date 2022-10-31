package validator.capture;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class PawnCaptureValidator implements MovementValidator {

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (!(Math.abs(movement.getFrom().getCol() - movement.getTo().getCol()) == 1 && Math.abs(movement.getFrom().getRow() - movement.getTo().getRow()) == 1)) {
            if (!board.isOccupied(movement.getTo())) {
                return true;
            } else if (board.isOccupied(movement.getTo()) && movement.getTo().getPiece().getColour() != movement.getFrom().getPiece().getColour()) {
                return true;}
        }

        throw new InvalidMovementException("Invalid movement");
    }
}
