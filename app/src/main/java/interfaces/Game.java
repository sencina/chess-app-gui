package interfaces;

import game.board.component.Position;
import game.movements.Movement;
import game.player.Player;

import java.util.List;

public interface Game {

    //Return old board after update
    public Board updateBoard(Board board);

    public List<Position> getPieces();

    public Board getBoard();

    public void makeMove(Movement movement) throws Exception;

    public boolean whiteTurn();

}
