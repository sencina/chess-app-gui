package game.managers;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.InvalidMove;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.NewGameState;
import edu.austral.dissis.chess.gui.PlayerColor;
import game.board.component.piece.Piece;
import game.managers.GameManager;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;

import java.util.Map;

public class PromotionManager implements GameManager {

    private final Piece to;

    public PromotionManager(Piece to) {
        this.to = to;
    }

    @Override
    public MoveResult evaluateMovement(Movement movement, GameStatus status) {
        try {
            if (movement.to().row() == status.board().rows() - 1 || movement.to().row() == 0) {
                status.board().movePiece(createMap(movement, status));
                return new NewGameState(Adapter.pieces(status.board()), status.turnManager().getTurn());
            }else return null;
        }catch (Exception e){
            return new InvalidMove("Test");
        }

    }

    private Map<Coordinate, Piece> createMap(Movement movement, GameStatus status){
        Map<Coordinate, Piece> updatePositions = status.board().positions();
        PlayerColor piece = PlayerColor.WHITE == status.turnManager().getTurn() ? PlayerColor.BLACK : PlayerColor.WHITE;
        updatePositions.put(movement.to(), new Piece(piece,
                to.type(),
                updatePositions.get(movement.to()).id(),
                to.mover()
        ));
        return updatePositions;
    }
}
