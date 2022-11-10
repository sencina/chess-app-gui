package validation.movementValidor;



import game.exceptions.InvalidMovementException;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;


/*
*
* Regenerar lo inmutable tod0 el tiempo
*
* Recomendacion: tenemos que transformar las diferencias del modelo y aplicar los cambios que deberia aplicar
*
*
* */
public class UnidirectionalMovementValidator extends AbstractValidator {

    private final int columns;
    private final int rows;

    public UnidirectionalMovementValidator(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }


    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        Coordinate coordinateToEvaluate = new Coordinate(movement.from().column() + columns, movement.from().row() + rows);
        while (!coordinateToEvaluate.equals(movement.to()) && status.board().isInsideBoard(coordinateToEvaluate)) {
            if (status.board().positions().get(coordinateToEvaluate) != null) throw new InvalidMovementException();
            coordinateToEvaluate = new Coordinate(coordinateToEvaluate.column() + columns, coordinateToEvaluate.row() + rows);
        }
        if (!status.board().isInsideBoard(coordinateToEvaluate)) throw new InvalidMovementException();
        if (status.board().positions().get(coordinateToEvaluate) != null &&
                status.board().positions().get(coordinateToEvaluate).color() == status.board().positions().get(movement.from()).color()) throw new InvalidMovementException();
        return checkValidators(movement, status);
    }
}
