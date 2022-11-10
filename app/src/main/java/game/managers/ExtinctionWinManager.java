package game.managers;

import edu.austral.dissis.chess.gui.GameOver;
import edu.austral.dissis.chess.gui.InvalidMove;
import edu.austral.dissis.chess.gui.MoveResult;
import game.movement.Movement;
import game.status.GameStatus;

public class ExtinctionWinManager implements GameManager {

    @Override
    public MoveResult evaluateMovement(Movement movement, GameStatus status) {

        GameStatus aux = status.clone();
        if (status.board().getCoordinatesOfPiecesByColour(aux.turnManager().getTurn()).size() == 0) {
            return new GameOver(status.turnManager().nextTurn());
        } else return null;


    }

}
