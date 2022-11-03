package validation.movementValidor;


import game.exceptions.OutOfBoardException;
import game.movement.Movement;
import game.status.GameStatus;

public class InBoardValidator extends AbstractValidator {

    @Override
    public boolean validate(Movement movement, GameStatus status) throws OutOfBoardException {

        if(movement.from().column() < 0 || movement.from().column() > status.board().columns() || movement.from().row() < 0 || movement.from().row() > status.board().rows()) throw new OutOfBoardException();
        else return true;
    }
}
