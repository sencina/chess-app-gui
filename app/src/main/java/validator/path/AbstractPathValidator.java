package validator.path;

import interfaces.MovementValidator;

public abstract class AbstractPathValidator implements MovementValidator {

    protected final boolean jumper;
    protected final int limit;
    protected final int direction;


    protected AbstractPathValidator(boolean jumper, int limit, int direction) {
        this.jumper = jumper;
        this.limit = limit;
        this.direction = direction;
    }
}
