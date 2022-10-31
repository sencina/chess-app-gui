package interfaces;

import game.board.component.Position;
import interfaces.property.Cloneable;

import java.util.List;


public interface Board extends Cloneable<Board> {

    //Returns all the positions of the board
    public List<Position> getPositions();

    //Returns the position of the board
    public Position getPosition(int x, int y);

    //Updates the position of the board, returns previous Position
    public Position updatePosition(Position position, Piece piece);

    //Checks the position of the board
    public Piece checkPosition(Position position);

    //Checks if the position is occupied
    public  boolean isOccupied(Position position);

    public int getRowSize();

    public int getColumnSize();

    public List<Position> getPieces();

    public List<Position> getCopyPosition();

}
