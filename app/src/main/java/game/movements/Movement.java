package game.movements;

import game.board.component.Position;
import interfaces.MovementValidator;

public class Movement {

    private Position from;
    private Position to;

    public Movement(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

}
