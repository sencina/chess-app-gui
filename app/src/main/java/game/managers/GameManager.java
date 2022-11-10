package game.managers;

import edu.austral.dissis.chess.gui.MoveResult;
import game.movement.Movement;
import game.status.GameStatus;

public interface GameManager {
    MoveResult evaluateMovement(Movement movement, GameStatus status);
}
