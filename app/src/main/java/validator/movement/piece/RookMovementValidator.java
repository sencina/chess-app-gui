package validator.movement.piece;

import edu.austral.dissis.chess.gui.Move;
import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;
import interfaces.Piece;
import validator.movement.AbstractValidator;
import validator.movement.LateralMovementValidator;
import validator.movement.StraightMovementValidator;
import validator.movement.response.ValidatorResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RookMovementValidator extends AbstractValidator {

    private final MovementValidator lateralValidator;
    private final MovementValidator verticalValidator;

    public RookMovementValidator() {
        super(false, 8);
        this.lateralValidator = new LateralMovementValidator(false, 8, 0);
        this.verticalValidator = new StraightMovementValidator(false, 8, 0);
    }

    @Override
    public ValidatorResponse validate(Movement movement, Board board) {

        if (movement.getFrom().getCol() == movement.getTo().getCol()) {
            return verticalValidator.validate(movement, board);
        } else if (movement.getFrom().getRow() == movement.getTo().getRow()) {
            return lateralValidator.validate(movement, board);
        } else {
            return new ValidatorResponse(false);
        }
    }
}
