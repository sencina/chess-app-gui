package game.board.component;
import game.board.component.piece.EmptyPiece;
import interfaces.Piece;
public class Position implements Comparable<Position> {

    private final int col;
    private final int row;
    private Piece piece;

    public Position(int row, int column, Piece piece) {
        this.col = row;
        this.row = column;
        this.piece = piece;
    }

    public Position(int row, int column) {
        this(row, column, new EmptyPiece());
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isEmpty(){
        return piece.isEmpty();
    }

    public Position updatePosition(Piece piece){
        this.piece = piece;
        return this;
    }

    public Position emptyPosition(){
        return updatePosition(new EmptyPiece());
    }

    @Override
    public int compareTo(Position o) {
        if (this.col == o.col && this.row == o.row && this.piece.equals(o.piece)) return 0;
        return 1;
    }
}
