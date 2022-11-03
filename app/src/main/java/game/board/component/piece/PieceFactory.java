package game.board.component.piece;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import validation.pieceMover.Mover;

import static validation.pieceMover.MoverFactory.*;

public class PieceFactory {

    private static int id;

    public static Piece createPawn(PlayerColor color) {
        return new Piece(color, PieceType.PAWN, Integer.toString(id++), pawnMover(color));
    }

    public static Piece createRook(PlayerColor color) {
        return new Piece(color, PieceType.ROOK, Integer.toString(id++), rookMover());
    }

    public static Piece createKnight(PlayerColor color) {
        return new Piece(color, PieceType.KNIGHT, Integer.toString(id++), knightMover());
    }

    public static Piece createBishop(PlayerColor color) {
        return new Piece(color, PieceType.BISHOP, Integer.toString(id++), bishopMover());
    }

    public static Piece createQueen(PlayerColor color) {
        return new Piece(color, PieceType.QUEEN, Integer.toString(id++), queenMover());
    }

    public static Piece createKing(PlayerColor color) {
        return new Piece(color, PieceType.KING, Integer.toString(id++), kingMover());
    }


//    public static Piece createArchBishop(PlayerColor color) {
//        return new Piece(color, PieceType.ARCHBISHOP, Integer.toString(id++));
//    }
//
//    public static Piece createChancellor(PlayerColor color) {
//        return new Piece(color, PieceType.CHANCELLOR, Integer.toString(id++));
//    }

}
