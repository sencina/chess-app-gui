package game.turnManager;

import edu.austral.dissis.chess.gui.PlayerColor;

public class ClassicTurnManager implements TurnManager{

    private PlayerColor turn = PlayerColor.WHITE;

    public ClassicTurnManager(PlayerColor turn) {
        this.turn = turn;
    }

    public ClassicTurnManager() {
    }

    public PlayerColor nextTurn() {
        turn = turn == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
        return turn;
    }

    @Override
    public TurnManager clone() {
        return new ClassicTurnManager(turn);
    }

    public PlayerColor getTurn() {
        return turn;
    }
}

