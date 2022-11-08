package validation.pieceMover;

import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;
import validation.movementValidor.MovementValidator;
import game.exceptions.InvalidMovementException;

import java.util.Map;
import java.util.Set;

public class ClassicMover implements Mover, CheckMover {


    private final Set<MovementValidator> preconditionsValidators;
    private final Set<MovementValidator> andMovementValidators;

    private final Set<MovementValidator> orMovementValidator;



    public ClassicMover(Set<MovementValidator> preconditionsValidators, Set<MovementValidator> andMovementValidators, Set<MovementValidator> orMovementValidator) {
        this.preconditionsValidators = preconditionsValidators;
        this.andMovementValidators = andMovementValidators;
        this.orMovementValidator = orMovementValidator;
    }

    @Override
    public boolean tryMove(Movement movement, GameStatus status) throws Exception {
        if (checkPreconditionValidators(movement, status)) return false;

        if (checkAndValidators(movement, status)) return false;

        if (checkOrValidatorsAndMove(movement, status)) return true;
        throw new InvalidMovementException();
    }

    @Override
    public boolean tryMoveWithoutAnd(Movement movement, GameStatus status) throws Exception {
        if (checkPreconditionValidators(movement, status)) return false;

        if (checkOrValidatorsAndMove(movement, status)) return true;
        throw new InvalidMovementException();
    }

    private boolean checkPreconditionValidators(Movement movement, GameStatus status) throws Exception {
        for (MovementValidator preconditionsValidator : preconditionsValidators) {
            if (!preconditionsValidator.validate(movement, status)) return true;
        }
        return false;
    }

    private boolean checkAndValidators(Movement movement, GameStatus status) throws Exception {
        for (MovementValidator andMovementValidator : andMovementValidators) {
            if (!andMovementValidator.validate(movement, status)) return true;
        }
        return false;
    }

    private boolean checkOrValidatorsAndMove(Movement movement, GameStatus status) {
        for (MovementValidator movementValidator : orMovementValidator) {
            try{
                if (movementValidator.validate(movement, status)) {
                    status.board().movePiece(createMap(movement, status));
                    return true;
                }
            }catch (Exception e){
                continue;
            }
        }
        return false;
    }

    private Map<Coordinate, Piece> createMap(Movement movement, GameStatus status){
        Map<Coordinate, Piece> updatePositions = status.board().positions();
        updatePositions.put(movement.to(), status.board().positions().get(movement.from()));
        updatePositions.remove(movement.from());
        return updatePositions;
    }
}
