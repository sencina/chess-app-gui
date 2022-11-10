package game.engine;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.*;
import factory.BoardFactory;
import game.managers.*;
import game.movement.Movement;
import game.status.GameStatus;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static factory.PieceFactory.createQueen;

public class MyGameEngine implements GameEngine {

    private final GameStatus status = new GameStatus(new ClassicTurnManager(), BoardFactory.createClassicBoard());
    private final List<GameManager> managers;


    //classic game engine
    public MyGameEngine() {
        List<GameManager> managers = new ArrayList<>();
        managers.add(new MoveGameManager());
        managers.add(new PromotionManager(createQueen(PlayerColor.WHITE)));
        managers.add(new ClassicWinManager());
        this.managers = managers;
    }

    public MyGameEngine(List<GameManager> managers) {
        this.managers = managers;
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
        return new InitialState(Adapter.boardSize(status.board().columns(),status.board().rows()),Adapter.pieces(status.board()), PlayerColor.WHITE);
    }
}
