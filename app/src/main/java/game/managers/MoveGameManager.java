package game.managers;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.InvalidMove;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.NewGameState;
import game.movement.Movement;
import game.status.GameStatus;
import validation.pieceMover.Mover;

import java.util.Set;

public class MoveGameManager implements GameManager {
    @Override
    public MoveResult evaluateMovement(Movement movement, GameStatus status) {
        try {
            Set<Mover> movers = status.board().positions().get(movement.from()).mover();
            for (Mover mover : movers) {
                mover.tryMove(movement,status);
            }
            return new NewGameState(Adapter.pieces(status.board()), status.turnManager().nextTurn());
        } catch (Exception e) {
            return new InvalidMove(e.getMessage());
        }
    }
}
