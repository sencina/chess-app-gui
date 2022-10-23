package game.board.component.piece;

import enums.Colour;
import enums.Name;
import interfaces.MovementValidator;

public class Piece implements interfaces.Piece {

    private Colour colour;
    private Name name;
    private MovementValidator movementValidator;

    private String id;

    public Piece(String id, Name name, Colour colour, MovementValidator movementValidator) {
        this.id = id;
        this.colour = colour;
        this.name = name;
        this.movementValidator = movementValidator;
    }

    public Colour getColour() {
        return colour;
    }

    public Name getName() {
        return name;
    }

    public MovementValidator getMovementValidator() {
        return movementValidator;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
