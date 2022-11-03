package game.board;

import edu.austral.dissis.chess.gui.PlayerColor;
import game.board.component.piece.Piece;
import game.board.component.piece.PieceFactory;
import game.movement.Coordinate;
import validation.pieceMover.MoverFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardFactory {

    public static Board createClassicBoasrd() {
        Map<Coordinate, Piece> positions = new HashMap<>();

        for (int i = 0; i < 8; i++) {
           positions.put(new Coordinate(i, 1), PieceFactory.createPawn(PlayerColor.BLACK));
           positions.put(new Coordinate(i, 6), PieceFactory.createPawn(PlayerColor.WHITE));
        }

        positions.put(new Coordinate(0, 0), PieceFactory.createRook(PlayerColor.BLACK));
        positions.put(new Coordinate(7, 0), PieceFactory.createRook(PlayerColor.BLACK));
        positions.put(new Coordinate(0, 7), PieceFactory.createRook(PlayerColor.WHITE));
        positions.put(new Coordinate(7, 7), PieceFactory.createRook(PlayerColor.WHITE));

        positions.put(new Coordinate(1, 0), PieceFactory.createKnight(PlayerColor.BLACK));
        positions.put(new Coordinate(6, 0), PieceFactory.createKnight(PlayerColor.BLACK));
        positions.put(new Coordinate(1, 7), PieceFactory.createKnight(PlayerColor.WHITE));
        positions.put(new Coordinate(6, 7), PieceFactory.createKnight(PlayerColor.WHITE));

        positions.put(new Coordinate(2, 0), PieceFactory.createBishop(PlayerColor.BLACK));
        positions.put(new Coordinate(5, 0), PieceFactory.createBishop(PlayerColor.BLACK));
        positions.put(new Coordinate(2, 7), PieceFactory.createBishop(PlayerColor.WHITE));
        positions.put(new Coordinate(5, 7), PieceFactory.createBishop(PlayerColor.WHITE));

        positions.put(new Coordinate(3, 0), PieceFactory.createQueen(PlayerColor.BLACK));
        positions.put(new Coordinate(3, 7), PieceFactory.createQueen(PlayerColor.WHITE));

        positions.put(new Coordinate(4, 0), PieceFactory.createKing(PlayerColor.BLACK));
        positions.put(new Coordinate(4, 7), PieceFactory.createKing(PlayerColor.WHITE));

        List<Map<Coordinate, Piece>> history = new ArrayList<>();
        history.add(positions);

        return new RectangularBoard(8, 8, history);

    }
}
