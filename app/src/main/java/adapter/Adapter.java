package adapter;

import edu.austral.dissis.chess.gui.BoardSize;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.Move;
import edu.austral.dissis.chess.gui.Position;
import game.board.Board;
import game.board.component.piece.Piece;
import game.movement.Coordinate;
import game.movement.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adapter {

    public static BoardSize boardSize(int column, int row){
        return new BoardSize(column,row);
    }

    public static List<ChessPiece> pieces(Board board){

        List<ChessPiece> pieces = new ArrayList<>();

        Map<Coordinate, Piece> map = board.positions();
        for (Coordinate coordinate : map.keySet()) {
            Piece piece = map.get(coordinate);
            pieces.add(new ChessPiece(piece.id(),piece.color(),position(coordinate),piece.type().toString().toLowerCase()));
        }

        return pieces;
    }

    private static Position position(Coordinate coordinate){
        return new Position(coordinate.row()+1,coordinate.column()+1);
    }

    public static Movement movement(Move move) {
        return new Movement(new Coordinate(move.getFrom().getColumn()-1,move.getFrom().getRow()-1),new Coordinate(move.getTo().getColumn()-1,move.getTo().getRow()-1));
    }
}
