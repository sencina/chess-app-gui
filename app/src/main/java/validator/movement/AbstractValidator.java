package validator.movement;

import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import validator.movement.response.ValidatorResponse;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractValidator implements MovementValidator {

    private boolean jumper;
    private int limit;
    private int direction;

    public AbstractValidator(boolean jumper, int limit, int direction) {
        this.jumper = jumper;
        this.limit = limit;
        this.direction = direction;
    }
    public AbstractValidator(boolean jumper, int limit) {
        this(jumper,limit,0);
    }

    protected ValidatorResponse validatePosition(Movement movement, Board board){
        if (!board.isOccupied(movement.getTo())) {
            return new ValidatorResponse(true);
        } else if (board.isOccupied(movement.getTo()) && movement.getTo().getPiece().getColour() != movement.getFrom().getPiece().getColour()) {
            return new ValidatorResponse(true, new ArrayList<>(Collections.singleton(board.getPosition(movement.getTo().getCol(), movement.getTo().getRow()).getPiece())));}
       return new ValidatorResponse(false);
    }

    protected boolean isJumper() {
        return jumper;
    }

    protected int getLimit() {
        return limit;
    }

    protected int getDirection() {
        return direction;
    }
}
