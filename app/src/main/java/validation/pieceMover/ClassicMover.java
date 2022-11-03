package validation.pieceMover;

import game.board.Board;
import game.movement.Movement;
import game.status.GameStatus;
import validation.movementValidor.MovementValidator;
import game.exceptions.InvalidMovementException;

import java.util.Set;

public class ClassicMover implements Mover{

    private final Set<MovementValidator> andMovementValidators;

    private final Set<MovementValidator> orMovementValidator;

    public ClassicMover(Set<MovementValidator> andMovementValidators, Set<MovementValidator> orMovementValidator) {
        this.andMovementValidators = andMovementValidators;
        this.orMovementValidator = orMovementValidator;
    }

    @Override
    public boolean tryMove(Movement movement, GameStatus status) throws Exception {
        for (MovementValidator andMovementValidator : andMovementValidators) {
            if (!andMovementValidator.validate(movement, status)) return false;
        }

        for (MovementValidator movementValidator : orMovementValidator) {
            try{
                if (movementValidator.validate(movement, status)) {
                    status.board().movePiece(Set.of(movement), status.board().positions());
                    return true;
                }
            }catch (Exception e){
                continue;
            }
        }
        throw new InvalidMovementException();
    }
}
