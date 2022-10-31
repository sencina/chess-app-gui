package game.manager;

import exception.InvalidMovementException;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.data.NameColour;

import java.util.Map;

public class MoveManager {

    private final Map<NameColour, MovementValidator> validatorMap;

    public MoveManager(Map<NameColour, MovementValidator> validatorMap) {
        this.validatorMap = validatorMap;
    }

    public boolean movePiece(Movement movement, Board board) throws InvalidMovementException {

        NameColour nameColour = new NameColour(movement.getFrom().getPiece().getName(), movement.getFrom().getPiece().getColour());
        if (validatorMap.containsKey(nameColour)){
            return validatorMap.get(nameColour).validate(movement, board);
        }

        throw new InvalidMovementException("Invalid movement");
    }

}
