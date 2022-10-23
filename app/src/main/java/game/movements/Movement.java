package game.movements;

import game.board.component.Position;
import interfaces.MovementValidator;

public class Movement {

    private Position from;
    private Position to;
    private MovementValidator movementValidator;

    public Movement(Position from, Position to) {
        this.from = from;
        this.to = to;
        this.movementValidator = getFrom().getPiece().getMovementValidator();
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    public MovementValidator getValidator() {
        return movementValidator;
    }
}
