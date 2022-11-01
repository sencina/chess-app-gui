package validator.check;

import enums.Colour;
import enums.Name;
import exception.InvalidMovementException;
import game.board.component.Position;
import game.board.component.piece.EmptyPiece;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

import java.util.ArrayList;
import java.util.List;

public class CheckValidator implements MovementValidator {


    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {

        Colour movementColour = movement.getFrom().getPiece().getColour();
        Colour oppositeColour = movementColour == Colour.WHITE ? Colour.BLACK : Colour.WHITE;

        Board boardAux = board.clone();
        List<Position> enemyPositions = getEnemyPositions(boardAux, oppositeColour);
        Position kingPosition = getKingPosition(boardAux, movementColour);
        boardAux.updatePosition(movement.getTo(), movement.getFrom().getPiece());
        boardAux.updatePosition(movement.getFrom(), new EmptyPiece());
        for (Position enemyPosition : enemyPositions) {
            if (enemyPosition.getPiece().movementValidator().validate(new Movement(enemyPosition, kingPosition), boardAux)) return true;
        }
        return false;
    }

    private List<Position> getEnemyPositions(Board board, Colour colour) {
        List<Position> enemyPositions = new ArrayList<>();
        for (Position position : board.getPieces()) {
            if (position.getPiece().getColour() == colour) {
                enemyPositions.add(position);
            }
        }
        return enemyPositions;
    }

    private Position getKingPosition(Board board, Colour colour) {
        for (Position position : board.getPieces()) {
            if (position.getPiece().getColour() == colour && position.getPiece().getName() == Name.KING) {
                return position;
            }
        }
        return null;
    }

}

