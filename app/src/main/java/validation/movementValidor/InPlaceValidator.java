package validation.movementValidor;




import game.exceptions.SamePositionException;
import game.movement.Movement;
import game.status.GameStatus;

public class InPlaceValidator extends AbstractValidator {

    @Override
    public boolean validate(Movement movement, GameStatus status) throws SamePositionException {
        if (movement.from().equals(movement.to())) throw new SamePositionException();
        return true;
    }
}
