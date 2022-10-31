package game.manager;

import enums.Colour;

public class TurnManager implements interfaces.TurnManager {

    private boolean isWhiteTurn;

    public TurnManager() {
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
