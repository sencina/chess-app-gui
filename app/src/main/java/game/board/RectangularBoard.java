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
    public boolean movePiece(Map<Coordinate, Piece> updatePositions) {
        history.add(updatePositions);
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

    @Override
    public Board clone() {
        return new RectangularBoard(columns, rows, cloneHistory());
    }

    private List<Map<Coordinate,Piece>> cloneHistory() {

        List<Map<Coordinate, Piece>> cloneHistory = new ArrayList<>();
        for (Map<Coordinate, Piece> positions: history) {
            Map<Coordinate, Piece> clonePositions = new HashMap<>();
            for (Coordinate position: positions.keySet()) {
                clonePositions.put(position, positions.get(position).copy());
            }
            cloneHistory.add(clonePositions);
        }
        return cloneHistory;
    }

    @Override
    public Coordinate getPositionOfPiece(PieceType type, PlayerColor color) {
        Map<Coordinate, Piece> positions = positions();
        for (Coordinate position: positions.keySet()) {
            Piece piece = positions.get(position);
            if (piece.type() == type && piece.color() == color) return position;
        }
        return null;
    }
}
