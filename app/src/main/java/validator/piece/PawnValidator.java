package validator.piece;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.check.CheckValidator;
import validator.capture.CaptureValidator;
import validator.path.StraightPathValidator;

import java.util.HashMap;
import java.util.Map;

public class PawnValidator implements MovementValidator {

    private Map<String, Integer> countMap;

    private final MovementValidator pathValidator;
    private final MovementValidator firstMoveValidator;
    private final MovementValidator captureValidator;

    private int count;

    public  PawnValidator(int direction) {
        this.pathValidator = new StraightPathValidator(false, 1, direction);
        this.firstMoveValidator = new StraightPathValidator(false, 2, direction);
        this.captureValidator = new CaptureValidator();
        this.count = 0;
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        boolean isDiagonal = Math.abs(movement.getFrom().getCol() - movement.getTo().getCol()) == 1 && Math.abs(movement.getFrom().getRow() - movement.getTo().getRow()) == 1;
        if (isDiagonal) {
            count++;
            if (board.isOccupied(movement.getTo())) return captureValidator.validate(movement, board);
            else return false;
        }
        else {
            if (count == 0) {
                count++;
                if (!board.isOccupied(movement.getTo()))return firstMoveValidator.validate(movement, board);
                else return false;
            }
            else {
                count++;
                if (!board.isOccupied(movement.getTo()))return pathValidator.validate(movement, board);
                else return false;
            }
        }

    }

}
