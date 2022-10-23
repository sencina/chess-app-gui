package game;

import enums.Colour;
import enums.Name;
import game.board.RectangularBoard;
import game.board.component.Position;
import game.board.component.piece.Piece;
import game.movements.Movement;
import game.player.Player;
import interfaces.Board;
import interfaces.Game;
import interfaces.VictoryValidator;
import validator.movement.ComposedMovementValidator;
import validator.movement.DiagonalMovementValidator;
import validator.movement.StraightMovementValidator;
import validator.movement.TriDirectionalMovementValidator;
import validator.movement.piece.PawnMovementValidator;
import validator.movement.piece.RookMovementValidator;
import validator.victory.ClassicVictoryValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClassicGame implements Game {

    private List<Player> players;
    private Board board;
    private VictoryValidator victoryValidator;
    private Stack<Movement> movements;

    private boolean whiteTurn;

    public ClassicGame(List<Player> players, Board board, VictoryValidator victoryValidator) {
        this.players = players;
        this.board = board;
        this.victoryValidator = victoryValidator;
        this.movements = new Stack<>();
        this.whiteTurn = true;
    }

    public ClassicGame(){

        List<game.board.component.Position> positions = new ArrayList<>();

        // Pawn
        for (int i = 0; i < 8; i++) {
            positions.add(new game.board.component.Position(i,6, new game.board.component.piece.Piece(i+""+6,Name.PAWN,Colour.WHITE,new PawnMovementValidator(-1))));
            positions.add(new game.board.component.Position(i,1, new game.board.component.piece.Piece(i+""+1,Name.PAWN,Colour.BLACK,new PawnMovementValidator(1))));
        }

        //Rook
        positions.add(new game.board.component.Position(0,7, new game.board.component.piece.Piece("07",Name.ROOK,Colour.WHITE,new RookMovementValidator())));
        positions.add(new game.board.component.Position(7,7, new game.board.component.piece.Piece("77",Name.ROOK,Colour.WHITE,new RookMovementValidator())));
        positions.add(new game.board.component.Position(0,0, new game.board.component.piece.Piece("00",Name.ROOK,Colour.BLACK,new RookMovementValidator())));
        positions.add(new game.board.component.Position(7,0, new game.board.component.piece.Piece("70",Name.ROOK,Colour.BLACK,new RookMovementValidator())));

        //Knight
        positions.add(new game.board.component.Position(1,7, new game.board.component.piece.Piece("17",Name.KNIGHT,Colour.WHITE,new ComposedMovementValidator(true,3))));
        positions.add(new game.board.component.Position(6,7, new game.board.component.piece.Piece("67",Name.KNIGHT,Colour.WHITE,new ComposedMovementValidator(true,3))));
        positions.add(new game.board.component.Position(1,0, new game.board.component.piece.Piece("10",Name.KNIGHT,Colour.BLACK,new ComposedMovementValidator(true,3))));
        positions.add(new game.board.component.Position(6,0, new game.board.component.piece.Piece("60",Name.KNIGHT,Colour.BLACK,new ComposedMovementValidator(true,3))));

        //Bishop
        positions.add(new game.board.component.Position(2,7, new game.board.component.piece.Piece("27",Name.BISHOP,Colour.WHITE,new DiagonalMovementValidator(false,8,0))));
        positions.add(new game.board.component.Position(5,7, new game.board.component.piece.Piece("57",Name.BISHOP,Colour.WHITE,new DiagonalMovementValidator(false,8,0))));
        positions.add(new game.board.component.Position(2,0, new game.board.component.piece.Piece("20",Name.BISHOP,Colour.BLACK,new DiagonalMovementValidator(false,8,0))));
        positions.add(new game.board.component.Position(5,0, new game.board.component.piece.Piece("50",Name.BISHOP,Colour.BLACK,new DiagonalMovementValidator(false,8,0))));

        //Queen
        positions.add(new game.board.component.Position(3,7, new game.board.component.piece.Piece("37",Name.QUEEN,Colour.WHITE,new TriDirectionalMovementValidator(false,8))));
        positions.add(new game.board.component.Position(3,0, new game.board.component.piece.Piece("30",Name.QUEEN,Colour.BLACK,new TriDirectionalMovementValidator(false,8))));

        //King
        positions.add(new game.board.component.Position(4,7, new game.board.component.piece.Piece("47",Name.KING,Colour.WHITE,new TriDirectionalMovementValidator(false,1))));
        positions.add(new game.board.component.Position(4,0, new game.board.component.piece.Piece("40",Name.KING,Colour.BLACK,new TriDirectionalMovementValidator(false,1))));


        List<Player> players = new ArrayList<>();

        players.add(new Player("Player 1",Colour.WHITE));
        players.add(new Player("Player 2",Colour.BLACK));

        this.board = new RectangularBoard(8,8,positions);
        this.players = players;
        this.movements = new Stack<>();
        this.victoryValidator = new ClassicVictoryValidator();

    }

    @Override
    public void makeMove(Movement movement) throws Exception {

        Player player = whiteTurn ? players.get(0) : players.get(1);
        if (whiteTurn && movement.getFrom().getPiece().getColour() != Colour.WHITE || !whiteTurn && movement.getFrom().getPiece().getColour() != Colour.BLACK) {
            throw new Exception("Not your turn");
        }
        Board board = player.movePiece(movement,getBoard());
        movements.push(movement);
        updateBoard(board);
        updateTurn();
    }

    @Override
    public boolean whiteTurn() {
        return whiteTurn;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public VictoryValidator getVictoryValidator() {
        return victoryValidator;
    }

    public void addMovement(Movement movement){
        movements.push(movement);
    }

    @Override
    public Board updateBoard(Board board) {

        Board oldBoard = getBoard();
        this.board = board;
        return oldBoard;
    }

    @Override
    public List<Position> getPieces() {

        return board.getPieces();

    }

    @Override
    public Board getBoard(){
        return board;
    }

    private void updateTurn(){
        whiteTurn = !whiteTurn;
    }

}
