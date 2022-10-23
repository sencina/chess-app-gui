package game.board.component;
import interfaces.Piece;
public class Position implements Comparable<Position> {

    private int col;
    private int row;
    private Piece piece;

    public Position(int xCord, int yCord, Piece piece) {
        this.col = xCord;
        this.row = yCord;
        this.piece = piece;
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

    @Override
    public int compareTo(Position o) {
        if (this.col == o.col && this.row == o.row){
            return 0;
        }
        return 1;
    }
}
