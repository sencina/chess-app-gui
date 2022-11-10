package factory;

import edu.austral.dissis.chess.gui.PlayerColor;
import game.managers.*;

import java.util.ArrayList;
import java.util.List;

import static factory.PieceFactory.createQueen;

public class ManagerFactory {

    public static List<GameManager> checkMateManager(){
        List<GameManager> managers = new ArrayList<>();
        managers.add(new MoveGameManager());
        managers.add(new PromotionManager(createQueen(PlayerColor.WHITE)));
        managers.add(new ClassicWinManager());
        return managers;
    }

    public static List<GameManager> extinctionManager(){
        List<GameManager> managers = new ArrayList<>();
        managers.add(new MoveGameManager());
        managers.add(new ExtinctionWinManager());
        return managers;
    }



}
