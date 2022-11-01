package game.manager;

import enums.Colour;
import enums.Name;
import game.board.component.piece.Piece;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class PromotionManager {

    private Board board;
    private final Name promotionPiece;
    private final Name promoteToPiece;

    public PromotionManager(Board board, Name promotionPiece, Name promoteToPiece, MovementValidator movementValidator) {
        this.board = board;
        this.promotionPiece = promotionPiece;
        this.promoteToPiece = promoteToPiece;
    }

    public void promotePiece(Movement movement){

        if (movement.getTo().isEmpty()) return;
        interfaces.Piece piece = movement.getTo().getPiece();
        if (movement.getTo().getPiece().getName() == promotionPiece){
            if (piece.getColour() == Colour.WHITE){
                if (movement.getTo().getRow() == 0) movement.getTo().updatePosition(new Piece(piece.getId(), promoteToPiece, piece.getColour(),piece.movementValidator()));
            }
            else {
                if (movement.getTo().getRow() == board.getRowSize()-1) movement.getTo().updatePosition(new Piece(piece.getId(), promoteToPiece, piece.getColour(),piece.movementValidator()));
            }
        }
    }
}
