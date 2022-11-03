package game.movement;

public class Coordinate {
    private final int column;
    private final int row;

    public Coordinate(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int column() {
        return column;
    }

    public int row() {
        return row;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Coordinate other)) return false;
        return other.column == column && other.row == row;
    }

    @Override
    public int hashCode() {
        return column * 31 + row;
    }

}
