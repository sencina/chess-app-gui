package interfaces;

import game.board.component.Position;
import game.movements.Movement;

import java.util.List;

public interface Game {

    //Return old board after update
    public Board updateBoard(Board board);
    public Board getBoard();
    public void makeMove(Movement movement) throws Exception;
    public TurnManager turnManager();
}
