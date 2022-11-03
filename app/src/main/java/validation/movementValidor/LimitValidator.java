package validation.movementValidor;



import game.movement.Movement;
import game.exceptions.InvalidMovementException;
import game.status.GameStatus;

public class LimitValidator extends AbstractValidator {

    private final int limit;

    public LimitValidator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        if (Math.abs(movement.from().column() - movement.to().column()) <= limit
        && Math.abs(movement.from().row() - movement.to().row()) <= limit) return true;
        else throw new InvalidMovementException("Off limits");
    }
}
