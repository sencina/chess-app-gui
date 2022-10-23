package validator.movement;

import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;
import validator.movement.response.ValidatorResponse;

public class StraightMovementValidator extends AbstractValidator{

    public StraightMovementValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    public StraightMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {

        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = fromX == toX && Math.abs(fromY - toY) <= getLimit();
        boolean direction = getDirection() == (toY-fromY)/Math.abs(fromY - toY) || getDirection() == 0;
        if (fromX == toX && inLimit && direction) {
            int min = Math.min(fromY, toY);
            int max = Math.max(fromY, toY);

            //Check if there is a piece in the way
            for (int i = min + 1; i < max && !isJumper(); i++) {
                Position position = board.getPosition(fromX, i);
                if (!position.isEmpty()) {
                    return new ValidatorResponse(false);
                }
            }

            return validatePosition(movement,board);

        } else return new ValidatorResponse(false);

    }


}
