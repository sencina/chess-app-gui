package factory;

import enums.Name;
import game.Game;
import game.manager.MoveManager;
import game.manager.PromotionManager;
import game.manager.TurnManager;

public class GameFactory {

    public static Game classicGame() {
        return new Game(new TurnManager(),BoardFactory.createRectangularClassicBoard(),VictoryValidatorFactory.ClassicVictoryValidator(),new PromotionManager(BoardFactory.createRectangularClassicBoard(), Name.PAWN,Name.QUEEN),MoveManagerFactory.createClassicMoveManager());
    }
}
