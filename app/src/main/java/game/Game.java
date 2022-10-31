package game;

import exception.InvalidMovementException;
import game.manager.MoveManager;
import game.manager.PromotionManager;
import game.movements.Movement;
import interfaces.Board;
import interfaces.TurnManager;
import interfaces.VictoryValidator;
import java.util.Stack;

public class Game implements interfaces.Game {

    private Board board;
    private final VictoryValidator victoryValidator;
    private Stack<Movement> movements;
    private final TurnManager turnManager;
    private final PromotionManager promotionManager;
    private final MoveManager moveManager;

    public Game(TurnManager trunManager,Board board, VictoryValidator victoryValidator, PromotionManager promotionManager, MoveManager moveManager) {
        this.board = board;
        this.victoryValidator = victoryValidator;
        this.movements = new Stack<>();
        this.turnManager = trunManager;
        this.promotionManager= promotionManager;
        this.moveManager = moveManager;
    }

    @Override
    public void makeMove(Movement movement) throws InvalidMovementException {

        //moveManager.movePiece(movement,board);
    }

    private void addMovement(Movement movement){
        movements.push(movement);
    }

    @Override
    public Board updateBoard(Board board) {

        Board oldBoard = getBoard();
        this.board = board;
        return oldBoard;
    }

    @Override
    public Board getBoard(){
        return board;
    }

    @Override
    public TurnManager turnManager() {
        return turnManager;
    }

}
