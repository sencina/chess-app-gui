package validator.movement.piece;

import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.movement.AbstractValidator;
import validator.movement.DiagonalMovementValidator;
import validator.movement.StraightMovementValidator;
import validator.movement.response.ValidatorResponse;

public class PawnMovementValidator extends AbstractValidator {


    private final MovementValidator forwardValidator;
    private final MovementValidator firstMoveValidator;
    private final MovementValidator captureValidator;
    private int count;

    public PawnMovementValidator(int direction) {
        super(false, 1, direction);
        this.count = 0;
        this.forwardValidator = new StraightMovementValidator(false, 1, direction);
        this.firstMoveValidator = new StraightMovementValidator(false, 2, direction);
        this.captureValidator = new DiagonalMovementValidator(false, 1, direction);
    }

    private void incrementCount(){
        count++;
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {

        Position to = movement.getTo();

        if(count == 0){
            if(firstMoveValidator.validate(movement,board).isValid()){
                incrementCount();
                return new ValidatorResponse(true);
            }
        }
        else{
            if(to.isEmpty()){
                incrementCount();
                return forwardValidator.validate(movement,board);
            }
            else{
                incrementCount();
                return captureValidator.validate(movement,board);
            }
        }

        return forwardValidator.validate(movement,board);
    }
}
