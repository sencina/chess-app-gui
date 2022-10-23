package game.board;

import game.board.component.Position;
import game.board.component.piece.EmptyPiece;
import interfaces.Board;
import interfaces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RectangularBoard implements Board {


    private List<Position> positions;
    private int x;
    private int y;

    //Returns Empty Board
    public RectangularBoard(int x, int y) {

        Position[] array = new Position[x*y];

        int positionArray = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                array[positionArray] = new Position(i,j, new EmptyPiece());
                positionArray++;
            }
        }

        this.positions = Arrays.asList(array);
        this.x = x;
        this.y = y;

    }

    public RectangularBoard(int x, int y, List<Position> positions){
        this(x,y);
        for (Position position : positions) {
            updatePosition(getPosition(position.getCol(),position.getRow()), position.getPiece());
        }
    }

    @Override
    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public Position getPosition(int x, int y) {

        for (Position position : getPositions()) {

            if (position.getCol() == x && position.getRow() == y) return position;

        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public Position updatePosition(Position position, Piece piece) {
        int index = getPositions().indexOf(position);
        Position prev = getPositions().get(index);
        getPositions().set(index,position.updatePosition(piece));
        return prev;
    }

    @Override
    public Piece checkPosition(Position position) {
        return position.getPiece();
    }

    @Override
    public boolean isOccupied(Position position) {
        return !position.isEmpty();
    }

    @Override
    public int getRowSize() {
        return y;
    }

    @Override
    public int getColumnSize() {
        return x;
    }

    @Override
    public List<Position> getPieces() {

        List<Position> toReturn = new ArrayList<>();

        for (Position position : getPositions()) {
            if (!position.isEmpty()) toReturn.add(position);
        }

        return toReturn;

    }


}
