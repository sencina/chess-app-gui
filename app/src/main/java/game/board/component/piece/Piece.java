package game.board.component.piece;

import enums.Colour;
import enums.Name;

public class Piece implements interfaces.Piece {

    private final Colour colour;
    private final Name name;
    private final String id;

    public Piece(String id, Name name, Colour colour) {
        this.id = id;
        this.colour = colour;
        this.name = name;
    }

    public Colour getColour() {
        return colour;
    }

    public Name getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean equals(interfaces.Piece piece) {
        return this.id.equals(piece.getId());
    }

    @Override
    public interfaces.Piece clone() {
        return new Piece(id, name, colour);
    }
}
