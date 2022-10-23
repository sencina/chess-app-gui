package validator.movement;

import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;
import validator.movement.response.ValidatorResponse;

public class DiagonalMovementValidator extends AbstractValidator {

    public DiagonalMovementValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    public DiagonalMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {

        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        boolean inLimit = Math.abs(fromX - toX) <= getLimit() && Math.abs(fromY - toY) <= getLimit();

        if (Math.abs(fromX - toX) == Math.abs(fromY - toY) && inLimit) {

            int min = Math.min(fromX, toX);
            int max = Math.max(fromX, toX);

            int directionX = (toX - fromX) / Math.abs(max - min);
            int directionY = (toY - fromY) / Math.abs(max - min);

            for (int i = min + 1; i < max; i++) {
                Position position = board.getPosition(i, fromY + (i - min) * directionY);
                if (!position.isEmpty()) {
                    return new ValidatorResponse(false);
                }
            }

            return validatePosition(movement,board);

        } else return new ValidatorResponse(false);
    }
}
