package game.board.component.piece;

import enums.Colour;
import enums.Name;
import interfaces.MovementValidator;
import interfaces.Piece;
import validator.movement.EmptyMovementValidator;

public class EmptyPiece implements Piece {

    private MovementValidator movementValidator;

    public EmptyPiece() {
        this.movementValidator = new EmptyMovementValidator();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public MovementValidator getMovementValidator() {
        return movementValidator;
    }

    @Override
    public Colour getColour() {
        return Colour.EMPTY;
    }

    @Override
    public Name getName() {
        return Name.EMPTY;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Empty piece has no id");
    }
}

