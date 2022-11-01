package validator.check;

import game.movements.Movement;
import interfaces.Board;
import interfaces.MovementValidator;

public class CheckValidator implements MovementValidator {

    @Override
    public boolean validate(Movement movement, Board board) {
        //Necesito saber que colo resta moviendo
        //voy al board y busco el color de la pieza que mueve
        //este es el color que esta moviendo ahora, agarro las piezas del color opuesto de una pieza del tablero
        //busco la posicion del rey del color que mueve (from)
        //agarro las piezas del color opuesto en una lista y valido si ninguna puede llegar al rey
        // si uno es true, entonces esta en jaque
        return false;
    }

}

