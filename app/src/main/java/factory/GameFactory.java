package factory;

import enums.Name;
import game.Game;
import game.manager.MoveManager;
import game.manager.PromotionManager;
import game.manager.TrunManager;

public class GameFactory {

    public static Game classicGame() {
        return new Game(new TrunManager(),BoardFactory.createRectangularClassicBoard(),VictoryValidatorFactory.ClassicVictoryValidator(),new PromotionManager(BoardFactory.createRectangularClassicBoard(), Name.PAWN,Name.QUEEN),new MoveManager());
    }
}
