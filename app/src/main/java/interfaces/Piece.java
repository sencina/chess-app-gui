package interfaces;

import enums.Colour;
import enums.Name;
import interfaces.property.Cloneable;

public interface Piece extends Cloneable<Piece> {

    public boolean isEmpty();

    public Colour getColour();

    public Name getName();

    public String getId();

    boolean equals(Piece piece);
}
