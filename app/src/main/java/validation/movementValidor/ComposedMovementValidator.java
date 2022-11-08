package validation.movementValidor;



import game.exceptions.InvalidMovementException;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;
import validation.movementValidor.AbstractValidator;

public class ComposedMovementValidator extends AbstractValidator {

    private final int columns;
    private final int rows;

    public ComposedMovementValidator(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        Coordinate newCoord = new Coordinate(movement.from().column() + columns, movement.from().row() + rows);
        if (!movement.to().equals(newCoord)) throw new InvalidMovementException();
        if (status.board().positions().get(newCoord) == null) return checkValidators(movement, status)
;
        else if (status.board().positions().get(newCoord).color() != status.board().positions().get(movement.from()).color())return checkValidators(movement, status)
;
        else throw new InvalidMovementException();
    }
}
