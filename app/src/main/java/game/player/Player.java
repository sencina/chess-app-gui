package game.player;

import enums.Colour;
import game.board.component.Position;
import game.board.component.piece.EmptyPiece;
import game.movements.Movement;
import interfaces.Board;
import interfaces.Piece;
import validator.movement.response.ValidatorResponse;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Colour colour;
    private List<Piece> capturedPieces;

    public Player(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
        this.capturedPieces = new ArrayList<>();
    }

    public Board movePiece(Movement movement, Board board) throws Exception {
        ValidatorResponse response = movement.getValidator().validate(movement, board);
        if (response.isValid()) {
            Position from = movement.getFrom();
            Position to = movement.getTo();
            Piece piece = from.getPiece();
            board.updatePosition(from, new EmptyPiece());
            board.updatePosition(to, piece);
            addCapturedPiece(response.getPieces());
            return board;
        }

        throw new IllegalArgumentException("Invalid movement");
    }

    private List<Piece> addCapturedPiece(List<Piece> pieces){

        this.capturedPieces.addAll(pieces);
        return this.capturedPieces;

    }

}
