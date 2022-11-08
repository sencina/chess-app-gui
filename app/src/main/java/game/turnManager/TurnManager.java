package game.turnManager;

import edu.austral.dissis.chess.gui.PlayerColor;

public interface TurnManager {

    PlayerColor getTurn();
    PlayerColor nextTurn();

    TurnManager clone();
}
