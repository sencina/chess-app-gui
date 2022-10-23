package adapter;

import edu.austral.dissis.chess.gui.*;
import enums.Colour;
import enums.Name;
import game.movements.Movement;
import interfaces.Board;
import interfaces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public static BoardSize adaptBoard(Board board){
        return new BoardSize(board.getRowSize(), board.getColumnSize());
    }

    public static Position adaptPosition(game.board.component.Position position){
        return new Position(position.getRow() +1 , position.getCol() +1);
    }

    public static List<ChessPiece> adaptPieces(List<game.board.component.Position> positions){

        List<ChessPiece> toReturn = new ArrayList<>(positions.size());

        for (game.board.component.Position position : positions) {
            Piece piece = position.getPiece();
            if (!piece.isEmpty()) toReturn.add(new ChessPiece(piece.getId(),adaptColour(piece.getColour()),adaptPosition(position), adaptName(piece.getName())));
        }

        return toReturn;
    }

    private static String getPieceIdFromPoisition(game.board.component.Position position){
        return (position.getCol() + 1) +""+ (position.getRow()+1);
    }

    private static PlayerColor adaptColour(Colour colour){
        if (colour == Colour.BLACK) return PlayerColor.BLACK;
        else return PlayerColor.WHITE;
    }

    private static String adaptName(Name name){

        return switch (name) {
            case PAWN -> "pawn";
            case ROOK -> "rook";
            case KNIGHT -> "knight";
            case BISHOP -> "bishop";
            case QUEEN -> "queen";
            case KING -> "king";
            default -> "empty";
        };
    }

    public static Movement toMovement(Move move, Board board){

        game.board.component.Position fromPosition = board.getPosition(move.getFrom().getColumn() - 1, move.getFrom().getRow() -1);
        game.board.component.Position toPosition = board.getPosition(move.getTo().getColumn() -1, move.getTo().getRow() -1);

        return new Movement(fromPosition, toPosition);

    }

}
