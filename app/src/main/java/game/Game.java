package game;

import exception.InvalidMovementException;
import game.board.component.piece.EmptyPiece;
import game.manager.PromotionManager;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import interfaces.TurnManager;
import interfaces.VictoryValidator;

public class Game implements interfaces.Game {

    private Board board;
    private final VictoryValidator victoryValidator;
    private final TurnManager turnManager;
    private final PromotionManager promotionManager;

    private final MovementValidator checkValidate;
    public Game(TurnManager trunManager,Board board, VictoryValidator victoryValidator, PromotionManager promotionManager, MovementValidator checkValidate) {
        this.board = board;
        this.victoryValidator = victoryValidator;
        this.turnManager = trunManager;
        this.promotionManager= promotionManager;
        this.checkValidate = checkValidate;
    }

    @Override
    public void makeMove(Movement movement) throws InvalidMovementException {
        if (turnManager.getTurn() == movement.getFrom().getPiece().getColour() && movement.getFrom().getPiece().movementValidator().validate(movement, board)) {
//            if (checkValidate.validate(movement,board)) throw new InvalidMovementException("You are in check");
            if (board.isOccupied(movement.getTo())) {
                board.updatePosition(movement.getTo(), new EmptyPiece());
            }
            board.updatePosition(movement.getTo(), movement.getFrom().getPiece());
            board.updatePosition(movement.getFrom(), new EmptyPiece());
            promotionManager.promotePiece(movement);
            turnManager.updateTurn();
            }
        else throw new InvalidMovementException("Invalid movement");
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
