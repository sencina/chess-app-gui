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
    private final MovementValidator checkValidator;

    public  PawnValidator(int direction) {
        this.pathValidator = new StraightPathValidator(false, 1, direction);
        this.firstMoveValidator = new StraightPathValidator(false, 2, direction);
        this.captureValidator = new CaptureValidator();
        this.checkValidator = new CheckValidator();
        this.countMap = new HashMap<>();
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        boolean isDiagonal = Math.abs(movement.getFrom().getCol() - movement.getTo().getCol()) == 1 && Math.abs(movement.getFrom().getRow() - movement.getTo().getRow()) == 1;
        if (isDiagonal) {
            countMap.put(movement.getFrom().getPiece().getId(), countMap.containsKey(movement.getFrom().getPiece().getId()) ? countMap.get(movement.getFrom().getPiece().getId()) + 1 : 1);
            if (board.isOccupied(movement.getTo())) return captureValidator.validate(movement, board) && !checkValidator.validate(movement, board);
            else throw new InvalidMovementException("Invalid diagnonal movement (Needs to eat a piece to move diagonally)");
        }
        else {
            if (!countMap.containsKey(movement.getFrom().getPiece().getId())) {
                countMap.put(movement.getFrom().getPiece().getId(), countMap.containsKey(movement.getFrom().getPiece().getId()) ? countMap.get(movement.getFrom().getPiece().getId()) + 1 : 1);
                if (!board.isOccupied(movement.getTo()))return firstMoveValidator.validate(movement, board) && !checkValidator.validate(movement, board);
                else throw new InvalidMovementException("Position is occupied");
            }
            else {
                countMap.put(movement.getFrom().getPiece().getId(), countMap.containsKey(movement.getFrom().getPiece().getId()) ? countMap.get(movement.getFrom().getPiece().getId()) + 1 : 1);
                if (!board.isOccupied(movement.getTo()))return pathValidator.validate(movement, board) && !checkValidator.validate(movement, board);
                else throw new InvalidMovementException("Position is occupied");
            }
        }

    }

}
