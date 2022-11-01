package validator.path;

import exception.InvalidMovementException;
import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;

public class LateralPathValidator extends AbstractPathValidator{


    protected LateralPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = Math.abs(fromX - toX) <= limit && Math.abs(fromY - toY) <= limit;
        boolean inDirection = direction == (toX-fromX)/Math.abs(fromX - toX) || direction == 0;

        if (fromY == toY && inLimit && inDirection) {
            int min = Math.min(fromX, toX);
            int max = Math.max(fromX, toX);

            //Check if there is a piece in the way
            for (int i = min + 1; i < max && !jumper; i++) {
                Position position = board.getPosition(i, fromY);
                if (!position.isEmpty()) {
                    throw new InvalidMovementException("There is a piece in the way");
                }
            }

            return true;

        } throw new InvalidMovementException("Invalid movement");
    }
}
