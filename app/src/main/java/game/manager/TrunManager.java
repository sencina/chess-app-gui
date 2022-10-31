package game.manager;

import enums.Colour;
import interfaces.TurnManager;

public class TrunManager implements TurnManager {

    private boolean isWhiteTurn;

    public TrunManager() {
        isWhiteTurn = true;
    }

    @Override
    public void updateTurn() {
        isWhiteTurn = !isWhiteTurn;
    }

    @Override
    public Colour getTurn() {
        return isWhiteTurn ? Colour.WHITE : Colour.BLACK;
    }


}
