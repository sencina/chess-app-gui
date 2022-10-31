package game.board.component.piece;

import enums.Colour;
import enums.Name;
import interfaces.MovementValidator;
import interfaces.Piece;

public class EmptyPiece implements Piece {


    public EmptyPiece() {

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
    public Piece clone() {
        return new EmptyPiece();
    }
}

