package game.board.component.piece;

import enums.Colour;
import enums.Name;
import interfaces.MovementValidator;
import interfaces.Piece;
import validator.EmptyPieceValidator;

public class EmptyPiece implements Piece {

    private final MovementValidator validator;
    public EmptyPiece() {
        this.validator = new EmptyPieceValidator();
    }

    @Override
    public boolean isEmpty() {
        return true;
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

    @Override
    public boolean equals(Piece piece) {
        return false;
    }

    @Override
    public MovementValidator movementValidator() {
        return validator;
    }

    @Override
    public Piece clone() {
        return new EmptyPiece();
    }
}

