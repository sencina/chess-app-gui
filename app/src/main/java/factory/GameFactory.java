package factory;

import enums.Name;
import game.Game;
import game.manager.PromotionManager;
import game.manager.TurnManager;
import validator.Validator;
import validator.capture.CaptureValidator;
import validator.check.CheckValidator;
import validator.path.TriDirectionalPathValidator;

import java.util.HashSet;
import java.util.List;

public class GameFactory {

    public static Game classicGame() {
        return new Game(new TurnManager(),BoardFactory.createRectangularClassicBoard(),VictoryValidatorFactory.ClassicVictoryValidator(),new PromotionManager(BoardFactory.createRectangularClassicBoard(), Name.PAWN,Name.QUEEN,new Validator(new HashSet<>(List.of(new TriDirectionalPathValidator(false,8,0), new CaptureValidator())))), new CheckValidator());
    }
}
