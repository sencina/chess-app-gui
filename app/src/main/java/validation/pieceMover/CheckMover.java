package validation.pieceMover;

import game.movement.Movement;
import game.status.GameStatus;

public interface CheckMover {

    public boolean tryMoveWithoutAnd(Movement movement, GameStatus status) throws Exception;
    }
