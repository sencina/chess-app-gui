package validator.path;

import exception.InvalidMovementException;
import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;

public class StraightPathValidator extends AbstractPathValidator{


    public StraightPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        if (jumper) return true;

        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = fromX == toX && Math.abs(fromY - toY) <= limit;
        boolean inDirection = direction == (toY-fromY)/Math.abs(fromY - toY) || direction == 0;
        if (fromX == toX && inLimit && inDirection) {
            int min = Math.min(fromY, toY);
            int max = Math.max(fromY, toY);

            //Check if there is a piece in the way
            for (int i = min + 1; i < max; i++) {
                Position position = board.getPosition(fromX, i);
                if (!position.isEmpty()) {
                    throw new InvalidMovementException("There is a piece in the way");
                }
            }

            return true;

        } else throw new InvalidMovementException("Invalid movement");
    }
}
