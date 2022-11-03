package validation.movementValidor.core;



import game.exceptions.InvalidMovementException;
import game.movement.Movement;
import game.status.GameStatus;
import validation.movementValidor.AbstractValidator;

public class CaptureValidator extends AbstractValidator {

    private final boolean capture;

    public CaptureValidator(boolean capture) {
        this.capture = capture;
    }

    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        boolean hasFinalPiece = status.board().positions().get(movement.to()) != null;
        if (hasFinalPiece && capture) return checkValidators(movement, status)
;
        else if (!hasFinalPiece && !capture) return checkValidators(movement, status)
;
        throw new InvalidMovementException();
    }
}
