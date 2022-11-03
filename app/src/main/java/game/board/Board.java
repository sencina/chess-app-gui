package game.board;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Board {

    int rows();
    int columns();
    boolean movePiece(Set<Movement> movements, Map<Coordinate, Piece> positions);
    Map<Coordinate, Piece> positions();
    boolean isInsideBoard(Coordinate coordinate);

    List<Map<Coordinate, Piece>> history();
}
