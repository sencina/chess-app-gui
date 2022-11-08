package game.engine;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.*;
import game.board.BoardFactory;
import game.movement.Movement;
import game.status.GameStatus;
import game.turnManager.ClassicTurnManager;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static game.board.component.piece.PieceFactory.createQueen;

public class MyGameEngine implements GameEngine {

    private final GameStatus status = new GameStatus(new ClassicTurnManager(), BoardFactory.createClassicBoasrd());
    private final List<GameManager> managers;



    public MyGameEngine() {
        List<GameManager> managers = new ArrayList<>();
        managers.add(new MoveGameManager());
        managers.add(new PromotionManager(createQueen(PlayerColor.WHITE)));
        managers.add(new ClassicWinManager());
        this.managers = managers;
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Movement movement = Adapter.movement(move);
        MoveResult moveResult = new InvalidMove("something went wrong");
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
        return new InitialState(Adapter.boardSize(8,8),Adapter.pieces(status.board()), PlayerColor.WHITE);
    }
}
