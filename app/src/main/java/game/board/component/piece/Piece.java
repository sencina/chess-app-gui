package game.board.component.piece;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import validation.pieceMover.Mover;

public class Piece {

    private final PlayerColor color;
    private final PieceType type;
    private final String id;
    private final Mover mover;

    public Piece(PlayerColor color, PieceType type, String id, Mover mover) {
        this.color = color;
        this.type = type;
        this.id = id;
        this.mover = mover;
    }

    public PlayerColor color() {
        return color;
    }

    public PieceType type() {
        return type;
    }

    public String id() {
        return id;
    }

    public Mover mover() {
        return mover;
    }

    public Piece copy() {
        return new Piece(color, type, id, mover);
    }
}
