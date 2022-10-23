package adapter;

import edu.austral.dissis.chess.gui.ChessPiece;
import game.board.component.Position;
import interfaces.Game;
import interfaces.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter{

    private Game game;

    public GameAdapter(Game game) {
        this.game = game;
    }

    public List<ChessPiece> getPieces() {

        return Adapter.adaptPieces(game.getPieces());

    }

}
