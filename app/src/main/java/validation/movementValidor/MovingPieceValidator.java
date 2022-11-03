package validation.movementValidor;

import game.exceptions.NoPieceException;
import game.movement.Movement;
import game.status.GameStatus;


public class MovingPieceValidator extends AbstractValidator {

    @Override
    public boolean validate(Movement movement, GameStatus status) throws NoPieceException {
        if (status.board().positions().containsKey(movement.from())) return true;
        else throw new NoPieceException();
    }
}
