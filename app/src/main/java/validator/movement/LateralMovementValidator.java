package validator.movement;

import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;
import validator.movement.response.ValidatorResponse;

public class LateralMovementValidator extends AbstractValidator {

    public LateralMovementValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    public LateralMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {
        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = Math.abs(fromX - toX) <= getLimit() && Math.abs(fromY - toY) <= getLimit();
        boolean direction = getDirection() == (toX-fromX)/Math.abs(fromX - toX) || getDirection() == 0;

        if (fromY == toY && inLimit && direction) {
            int min = Math.min(fromX, toX);
            int max = Math.max(fromX, toX);

            //Check if there is a piece in the way
            for (int i = min + 1; i < max && !isJumper(); i++) {
                Position position = board.getPosition(i, fromY);
                if (!position.isEmpty()) {
                    return new ValidatorResponse(false);
                }
            }

            return validatePosition(movement,board);

        } else return new ValidatorResponse(false);
    }
}
