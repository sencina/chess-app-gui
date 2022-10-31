package interfaces;

import game.movements.Movement;

public interface MovementValidator {

    public boolean validate(Movement movement, Board board);

}
