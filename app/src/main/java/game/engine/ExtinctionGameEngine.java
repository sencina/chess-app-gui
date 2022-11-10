package game.engine;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.*;
import factory.BoardFactory;
import factory.ManagerFactory;
import game.managers.ClassicTurnManager;
import game.managers.GameManager;
import game.movement.Movement;
import game.status.GameStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExtinctionGameEngine implements GameEngine {

    private final GameStatus status = new GameStatus(new ClassicTurnManager(), BoardFactory.createExtinctionBoard());
    private final List<GameManager> managers;

    public ExtinctionGameEngine() {
        this.managers = ManagerFactory.extinctionManager();
    }


    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Movement movement = Adapter.movement(move);
        MoveResult moveResult = new InvalidMove("Error");
        for (GameManager manager : managers) {
            MoveResult moveResult1 = manager.evaluateMovement(movement, status);
            if (moveResult1 == null) continue;
            else moveResult = moveResult1;
        }
        return moveResult;
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(new BoardSize(8,8),Adapter.pieces(status.board()), PlayerColor.WHITE);
    }
}
