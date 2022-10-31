package factory;

import interfaces.VictoryValidator;
import validator.victory.ClassicVictoryValidator;

public class VictoryValidatorFactory {

    public static VictoryValidator ClassicVictoryValidator() {
        return new ClassicVictoryValidator();
    }
}
