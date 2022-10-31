package validator.victory;

import enums.Colour;
import enums.Name;
import game.board.component.Position;
import interfaces.Board;
import interfaces.VictoryValidator;

import java.util.ArrayList;
import java.util.List;

public class ClassicVictoryValidator implements VictoryValidator {

    public boolean victory(boolean whiteTurn, Board board) {

        Colour colour = whiteTurn ? Colour.WHITE : Colour.BLACK;
        Colour enemyColour = whiteTurn ? Colour.BLACK : Colour.WHITE;
        Position kingPosition = kingPosition(enemyColour, board);
        List<Position> myPieces = myPieces(colour, board);

        return true;
    }

    private List<Position> myPieces(Colour colour, Board board) {
        List<Position> toReturn = new ArrayList<>();
        for (Position position : board.getPositions()) {
            if (position.getPiece().getColour() == colour) toReturn.add(position);
        }
        return toReturn;
    }

    private Position kingPosition(Colour colour, Board board){

        List<Position> positions = board.getPositions();

        for (Position position : positions) {
            if (position.getPiece().getColour() == colour && position.getPiece().getName() == Name.KING) return position;
        }
        return null;
    }

}
