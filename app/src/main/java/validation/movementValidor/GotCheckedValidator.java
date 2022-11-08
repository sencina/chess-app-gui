package validation.movementValidor;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import game.board.Board;
import game.board.component.piece.Piece;
import game.exceptions.InvalidMovementException;
import game.movement.Coordinate;
import game.movement.Movement;
import game.status.GameStatus;
import validation.pieceMover.Mover;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GotCheckedValidator implements MovementValidator{

    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        //clono el estado
        GameStatus clone = status.clone();
        Map<Coordinate, Piece> positions = clone.board().positions();
        tryMoveWithoutAnd(movement, clone, positions);

        Coordinate kingCoordinate = status.board().getPositionOfPiece(PieceType.KING, status.turnManager().getTurn());

        PlayerColor enemyColor = status.turnManager().getTurn() == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;

        Set<Coordinate> coordinates = getCoordinates(positions, enemyColor);

        for (Coordinate coordinate : coordinates) {
            if (!tryMoveWithoutAnd(new Movement(coordinate, kingCoordinate), clone, positions)) continue;
            throw new InvalidMovementException();
        }
        return true;
    }


    private Set<Coordinate> getCoordinates(Map<Coordinate, Piece> positions,PlayerColor color) {
        Set<Coordinate> coordinates = new HashSet<>();
        for (Coordinate position : positions.keySet()) {
            if (positions.get(position).color() == color) coordinates.add(position);
        }
        return coordinates;
    }

    private boolean tryMoveWithoutAnd(Movement movement, GameStatus clone, Map<Coordinate, Piece> positions) throws Exception {
        try {
            Coordinate from = movement.from();
            Set<Mover> moverSet = positions.get(from).mover();
            for (Mover mover : moverSet) {
                mover.tryMoveWithoutAnd(movement, clone);
            }
            clone.turnManager().nextTurn();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
