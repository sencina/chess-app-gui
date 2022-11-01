package game;

import exception.InvalidMovementException;
import game.board.component.piece.EmptyPiece;
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
    private final TurnManager turnManager;
    private final PromotionManager promotionManager;
    private final MoveManager moveManager;

    public Game(TurnManager trunManager,Board board, VictoryValidator victoryValidator, PromotionManager promotionManager, MoveManager moveManager) {
        this.board = board;
        this.victoryValidator = victoryValidator;
        this.turnManager = trunManager;
        this.promotionManager= promotionManager;
        this.moveManager = moveManager;
    }

    @Override
    public void makeMove(Movement movement) throws InvalidMovementException {
        if (moveManager.movePiece(movement, board, turnManager.getTurn())) {
            if (board.isOccupied(movement.getTo())) {
                board.updatePosition(movement.getTo(), new EmptyPiece());
            }
            board.updatePosition(movement.getTo(), movement.getFrom().getPiece());
            board.updatePosition(movement.getFrom(), new EmptyPiece());
            turnManager.updateTurn();
        }
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
