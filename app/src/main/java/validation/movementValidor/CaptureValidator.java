package validation.movementValidor;



import game.board.component.piece.Piece;
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
        Piece toPiece = status.board().positions().get(movement.to());
        boolean hasFinalPiece = toPiece != null;
        if (hasFinalPiece && toPiece.color() != status.turnManager().getTurn() && capture) return checkValidators(movement, status)
;
        else if (!hasFinalPiece && !capture) return checkValidators(movement, status)
;
        throw new InvalidMovementException();
    }
}
