package factory;

import enums.Colour;
import enums.Name;
import game.board.RectangularBoard;
import game.board.component.Position;
import interfaces.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {


    public static Board createEmptyRectangularBoard(int rows, int columns) {
        return new RectangularBoard(rows,columns);
    }

    public static Board createRectangularClassicBoard(){

        List<Position> positions = new ArrayList<>();
        // Pawn
        for (int i = 0; i < 8; i++) {
            positions.add(new game.board.component.Position(i,6, new game.board.component.piece.Piece(i+""+6, Name.PAWN, Colour.WHITE)));
            positions.add(new game.board.component.Position(i,1, new game.board.component.piece.Piece(i+""+1,Name.PAWN,Colour.BLACK)));
        }

        //Rook
        positions.add(new game.board.component.Position(0,7, new game.board.component.piece.Piece("07",Name.ROOK,Colour.WHITE)));
        positions.add(new game.board.component.Position(7,7, new game.board.component.piece.Piece("77",Name.ROOK,Colour.WHITE)));
        positions.add(new game.board.component.Position(0,0, new game.board.component.piece.Piece("00",Name.ROOK,Colour.BLACK)));
        positions.add(new game.board.component.Position(7,0, new game.board.component.piece.Piece("70",Name.ROOK,Colour.BLACK)));

        //Knight
        positions.add(new game.board.component.Position(1,7, new game.board.component.piece.Piece("17",Name.KNIGHT,Colour.WHITE)));
        positions.add(new game.board.component.Position(6,7, new game.board.component.piece.Piece("67",Name.KNIGHT,Colour.WHITE)));
        positions.add(new game.board.component.Position(1,0, new game.board.component.piece.Piece("10",Name.KNIGHT,Colour.BLACK)));
        positions.add(new game.board.component.Position(6,0, new game.board.component.piece.Piece("60",Name.KNIGHT,Colour.BLACK)));

        //Bishop
        positions.add(new game.board.component.Position(2,7, new game.board.component.piece.Piece("27",Name.BISHOP,Colour.WHITE)));
        positions.add(new game.board.component.Position(5,7, new game.board.component.piece.Piece("57",Name.BISHOP,Colour.WHITE)));
        positions.add(new game.board.component.Position(2,0, new game.board.component.piece.Piece("20",Name.BISHOP,Colour.BLACK)));
        positions.add(new game.board.component.Position(5,0, new game.board.component.piece.Piece("50",Name.BISHOP,Colour.BLACK)));

        //Queen
        positions.add(new game.board.component.Position(3,7, new game.board.component.piece.Piece("37",Name.QUEEN,Colour.WHITE)));
        positions.add(new game.board.component.Position(3,0, new game.board.component.piece.Piece("30",Name.QUEEN,Colour.BLACK)));

        //King
        positions.add(new game.board.component.Position(4,7, new game.board.component.piece.Piece("47",Name.KING,Colour.WHITE)));
        positions.add(new game.board.component.Position(4,0, new game.board.component.piece.Piece("40",Name.KING,Colour.BLACK)));

        return new RectangularBoard(8,8,positions);
    }
}
