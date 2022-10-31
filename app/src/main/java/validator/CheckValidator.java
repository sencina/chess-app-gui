package validator;

import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class CheckValidator implements MovementValidator {

    @Override
    public boolean validate(Movement movement, Board board) {
        return false;
    }
}

