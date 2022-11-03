package game.turnManager;

import edu.austral.dissis.chess.gui.PlayerColor;

public class ClassicTurnManager implements TurnManager{

    private PlayerColor turn = PlayerColor.WHITE;


    public PlayerColor nextTurn() {
        turn = turn == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
        return turn;
    }

    public PlayerColor getTurn() {
        return turn;
    }
}

