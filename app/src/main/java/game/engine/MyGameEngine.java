package game.engine;

import adapter.Adapter;
import edu.austral.dissis.chess.gui.*;
import game.board.BoardFactory;
import game.movement.Movement;
import game.status.GameStatus;
import game.turnManager.ClassicTurnManager;
import org.jetbrains.annotations.NotNull;

public class MyGameEngine implements GameEngine {

    private GameStatus status = new GameStatus(new ClassicTurnManager(), BoardFactory.createClassicBoasrd());

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        Movement movement = Adapter.movement(move);
        try {
            status.board().positions().get(movement.from()).mover().tryMove(movement,status);
            return new NewGameState(Adapter.pieces(status.board()), status.turnManager().nextTurn());
        } catch (Exception e) {
            return new InvalidMove(e.getMessage());
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(Adapter.boardSize(8,8),Adapter.pieces(status.board()), PlayerColor.WHITE);
    }
}
