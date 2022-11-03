package game.board;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;

import java.util.*;

public class RectangularBoard implements Board{

    private final int columns;
    private final int rows;

    private final List<Map<Coordinate, Piece>> history;

    public RectangularBoard(int columns, int rows, List<Map<Coordinate, Piece>> history) {
        this.columns = columns;
        this.rows = rows;
        this.history = history;
    }



    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }


    @Override
    public boolean isInsideBoard(Coordinate coordinate) {
        return coordinate.row() < rows
                && coordinate.row() >= 0
                && coordinate.column() < columns
                && coordinate.column() >= 0;
    }

    @Override
    public List<Map<Coordinate, Piece>> history() {
        return history;
    }


    @Override
    public boolean movePiece(Set<Movement> movements, Map<Coordinate, Piece> positions) {
        for (Movement movement : movements) {
            positions.put(movement.to(), positions.get(movement.from()));
            positions.remove(movement.from());
        }
        history.add(positions);
        return true;
    }

    @Override
    public Map<Coordinate, Piece> positions() {

        Map<Coordinate, Piece> copyPositions = new HashMap<>();
        Map<Coordinate, Piece> positions = history.get(history.size() - 1);
        for (Coordinate position: positions.keySet()) {
            copyPositions.put(position, positions.get(position).copy());
        }

        return copyPositions;

    }
}
