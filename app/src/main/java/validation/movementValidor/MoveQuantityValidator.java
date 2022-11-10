package validation.movementValidor;

import game.board.component.piece.Piece;
import game.exceptions.InvalidMovementException;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;

import java.util.List;
import java.util.Map;

public class MoveQuantityValidator extends AbstractValidator {

    private final int limit;

    public MoveQuantityValidator(int limit) {
        this.limit = limit;
    }


    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        List<Map<Coordinate, Piece>> history = status.board().history();
        int count = 0;
        Piece piece = history.get(history.size() - 1).get(movement.from());
        Coordinate lastCoordinate = movement.from();
        for (int i = history.size() - 1; i >= 0; i--) { // historial a la -1
            if (history.get(i).get(lastCoordinate).equals(piece)) continue;
            for (Coordinate coordinate : history.get(i).keySet()) {
                if (history.get(i).get(coordinate).equals(piece)){
                    lastCoordinate = coordinate;
                    piece = history.get(i).get(lastCoordinate);
                    count++;
                }
            }
        }
        if (count <= limit) return true;
        else throw new InvalidMovementException();
    }
}

