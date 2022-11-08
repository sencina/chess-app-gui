package validation.pieceMover;

import edu.austral.dissis.chess.gui.PlayerColor;
import validation.movementValidor.*;
import validation.movementValidor.CaptureValidator;
import validation.movementValidor.ComposedMovementValidator;
import validation.movementValidor.UnidirectionalMovementValidator;

import java.util.HashSet;
import java.util.Set;

public class MoverFactory {

    public static Mover rookMover(){
        Set<MovementValidator> orMovementValidators = new HashSet<>();

        orMovementValidators.add(new UnidirectionalMovementValidator(0,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(0,-1));

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(), orMovementValidators);
    }

    public static Mover bishopMover(){
        Set<MovementValidator> orMovementValidators = new HashSet<>();

        orMovementValidators.add(new UnidirectionalMovementValidator(1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,-1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,-1));

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(), orMovementValidators);
    }

    public static Mover queenMover(){
        Set<MovementValidator> orMovementValidators = new HashSet<>();

        orMovementValidators.add(new UnidirectionalMovementValidator(1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,-1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,-1));

        orMovementValidators.add(new UnidirectionalMovementValidator(0,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(0,-1));

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(),orMovementValidators);
    }

    public static Mover kingMover(){
        Set<AbstractValidator> orMovementValidators = new HashSet<>();

        orMovementValidators.add(new UnidirectionalMovementValidator(1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,-1));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,-1));

        orMovementValidators.add(new UnidirectionalMovementValidator(0,1));
        orMovementValidators.add(new UnidirectionalMovementValidator(1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(-1,0));
        orMovementValidators.add(new UnidirectionalMovementValidator(0,-1));

        Set<MovementValidator> orMovementValidators1 = new HashSet<>();
        for (AbstractValidator orMovementValidator : orMovementValidators) {
            orMovementValidator.addMovementValidator(new LimitValidator(1));
            orMovementValidators1.add(orMovementValidator);
        }

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(), orMovementValidators1);
    }

    public static Mover knightMover(){
        Set<MovementValidator> orMovementValidators = new HashSet<>();

        orMovementValidators.add(new ComposedMovementValidator(1,2));
        orMovementValidators.add(new ComposedMovementValidator(-1,-2));
        orMovementValidators.add(new ComposedMovementValidator(-1,2));
        orMovementValidators.add(new ComposedMovementValidator(1,-2));

        orMovementValidators.add(new ComposedMovementValidator(2,1));
        orMovementValidators.add(new ComposedMovementValidator(-2,-1));
        orMovementValidators.add(new ComposedMovementValidator(-2,1));
        orMovementValidators.add(new ComposedMovementValidator(2,-1));

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(), orMovementValidators);
    }

    public static Mover pawnMover(PlayerColor color){

        Set<MovementValidator> orMovementValidators = new HashSet<>();

        int direction = color == PlayerColor.WHITE ? -1 : 1;

         orMovementValidators.add(new UnidirectionalMovementValidator(0,direction)
                 .addMovementValidator(new LimitValidator(1))
                 .addMovementValidator(new CaptureValidator(false)));

        orMovementValidators.add(new UnidirectionalMovementValidator(0,direction)
                .addMovementValidator(new LimitValidator(2))
                .addMovementValidator(new CaptureValidator(false))
                .addMovementValidator(new MoveQuantityValidator(0)));

        orMovementValidators.add(new UnidirectionalMovementValidator(1,direction)
                .addMovementValidator(new LimitValidator(1))
                .addMovementValidator(new CaptureValidator(true)));

        orMovementValidators.add(new UnidirectionalMovementValidator(-1,direction)
                .addMovementValidator(new LimitValidator(1))
                .addMovementValidator(new CaptureValidator(true)));

        return new ClassicMover(createPreconditionsValidators(), createDefaultAndValidators(),orMovementValidators);
    }

    private static Set<MovementValidator> createDefaultAndValidators(){

        Set<MovementValidator> andMovementValidators = new HashSet<>();
        andMovementValidators.add(new GotCheckedValidator());
        return andMovementValidators;
    }

    private static Set<MovementValidator> createPreconditionsValidators(){
        Set<MovementValidator> preconditionsValidators = new HashSet<>();

        preconditionsValidators.add(new InBoardValidator());
        preconditionsValidators.add(new InPlaceValidator());
        preconditionsValidators.add(new ColorValidator());

        return preconditionsValidators;
    }
}
