package validation.pieceMover;

import game.board.Board;
import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;

import java.util.List;
import java.util.Map;

public interface Mover {

    boolean tryMove(Movement movement, GameStatus status) throws Exception;
}
