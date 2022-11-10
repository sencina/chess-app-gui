package factory;

import edu.austral.dissis.chess.gui.PlayerColor;
import enums.PieceType;
import game.board.component.piece.Piece;

import java.util.Set;

import static factory.MoverFactory.*;

public class PieceFactory {

    private static int id;

    public static Piece createPawn(PlayerColor color) {
        return new Piece(color, PieceType.PAWN, Integer.toString(id++),
                Set.of(pawnMover(color)));
    }

    public static Piece createRook(PlayerColor color) {
        return new Piece(color, PieceType.ROOK, Integer.toString(id++), Set.of(rookMover()));
    }

    public static Piece createKnight(PlayerColor color) {
        return new Piece(color, PieceType.KNIGHT, Integer.toString(id++), Set.of(knightMover()));
    }

    public static Piece createBishop(PlayerColor color) {
        return new Piece(color, PieceType.BISHOP, Integer.toString(id++), Set.of(bishopMover()));
    }

    public static Piece createQueen(PlayerColor color) {
        return new Piece(color, PieceType.QUEEN, Integer.toString(id++), Set.of(queenMover()));
    }

    public static Piece createKing(PlayerColor color) {
        return new Piece(color, PieceType.KING, Integer.toString(id++), Set.of(kingMover()));
    }


    public static Piece createArchBishop(PlayerColor color) {
        return new Piece(color, PieceType.ARCHBISHOP, Integer.toString(id++), Set.of(archbishopMover()));
    }

    public static Piece createChancellor(PlayerColor color) {
        return new Piece(color, PieceType.CHANCELLOR, Integer.toString(id++), Set.of(chancellorMover()));
    }

}
