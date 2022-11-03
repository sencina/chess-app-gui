package validation.movementValidor;

import edu.austral.dissis.chess.gui.Move;
import game.movement.Movement;
import game.status.GameStatus;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractValidator implements MovementValidator {
    
    private final Set<MovementValidator> validators = new HashSet<>();
    
    public AbstractValidator addMovementValidator(MovementValidator movementValidator){
        validators.add(movementValidator);
        return this;
    }
    
    public boolean checkValidators(Movement movement, GameStatus status) throws Exception {
        for (MovementValidator validator : validators) {
            validator.validate(movement, status);
        }
        return true;
    }
    
    
}
