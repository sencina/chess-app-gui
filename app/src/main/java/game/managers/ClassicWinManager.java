package game.managers;

import edu.austral.dissis.chess.gui.GameOver;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.PlayerColor;
import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;
import validation.pieceMover.Mover;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClassicWinManager implements GameManager {
    @Override
    public MoveResult evaluateMovement(Movement movement, GameStatus status) {
        PlayerColor originalTurn  = status.turnManager().getTurn() == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
        GameStatus clone = status.clone();
        Map<Coordinate, Piece> positions = clone.board().positions();
        Set<Coordinate> coordinates = getCoordinates(positions, clone.turnManager().getTurn());
        for (Coordinate coordinate : coordinates) {
            for (int i = 0; i < clone.board().columns(); i++) {
                for (int j = 0; j < clone.board().rows(); j++) {
                    Set<Mover> movers = positions.get(coordinate).mover();
                    for (Mover mover1 : movers) {
                        try {
                            if (mover1.tryMove(new Movement(coordinate, new Coordinate(i, j)), clone)) {
                            return null;
                            }
                        }catch (Exception ignored){
                        }
                    }
                }

            }
        }
        return new GameOver(originalTurn);
    }

    private Set<Coordinate> getCoordinates(Map<Coordinate, Piece> positions, PlayerColor color) {
        Set<Coordinate> coordinates = new HashSet<>();
        for (Coordinate position : positions.keySet()) {
            if (positions.get(position).color() == color) coordinates.add(position);
        }
        return coordinates;
    }

}
