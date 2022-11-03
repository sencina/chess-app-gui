package validation.movementValidor;



import game.movement.Movement;
import game.status.GameStatus;
import validation.movementValidor.MovementValidator;

import java.util.Set;

public class PreconditionValidator extends AbstractValidator {
    private final Set<MovementValidator> validators;

    public PreconditionValidator(Set<MovementValidator> validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        for (MovementValidator validator : validators) {
            if (!validator.validate(movement, status)) return false;
        }
        return true;
    }
}
