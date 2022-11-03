package validation.movementValidor;



import game.movement.Movement;
import game.status.GameStatus;

public class ColorValidator extends AbstractValidator
 {
    @Override
    public boolean validate(Movement movement, GameStatus status) throws Exception {
        if (status.board().positions().get(movement.from()).color() == status.turnManager().getTurn()) return true;
        else throw new Exception("Not your turn");
    }
}
