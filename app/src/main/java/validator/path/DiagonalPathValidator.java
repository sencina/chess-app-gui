package validator.path;

import exception.InvalidMovementException;
import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;

public class DiagonalPathValidator extends AbstractPathValidator{

    public DiagonalPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (jumper) return true;

        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = Math.abs(fromX - toX) <= limit && Math.abs(fromY - toY) <= limit;

        if (Math.abs(fromX - toX) == Math.abs(fromY - toY) && inLimit) {

            int min = Math.min(fromX, toX);
            int max = Math.max(fromX, toX);

            int directionX = (toX - fromX) / Math.abs(max - min);
            int directionY = (toY - fromY) / Math.abs(max - min);

            for (int i = min + 1; i < max; i++) {
                Position position = board.getPosition(i, fromY + (i - min) * directionY);
                if (!position.isEmpty()) {
                    throw new InvalidMovementException("There is a piece in the way");
                }
            }

            return true;

        }

        throw new InvalidMovementException("Invalid movement");
    }
}
