package game.status;

import game.board.Board;
import game.engine.GameManager;
import game.turnManager.TurnManager;

public class GameStatus {

    private final TurnManager turnManager;
    private final Board board;

    public GameStatus(TurnManager turnManager, Board board) {
        this.turnManager = turnManager;
        this.board = board;
    }

    public TurnManager turnManager() {
        return turnManager;
    }

    public Board board() {
        return board;
    }

    public GameStatus clone() {
        return new GameStatus(turnManager.clone(), board.clone());
    }
}
