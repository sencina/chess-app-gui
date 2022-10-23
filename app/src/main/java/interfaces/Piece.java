package interfaces;

import enums.Colour;
import enums.Name;

public interface Piece {

    public boolean isEmpty();

    public MovementValidator getMovementValidator();

    public Colour getColour();

    public Name getName();

    public String getId();
}
