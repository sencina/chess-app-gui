package factory;

import enums.Colour;
import enums.Name;
import game.manager.MoveManager;
import interfaces.MovementValidator;
import validator.CheckValidator;
import validator.Validator;
import validator.capture.CaptureValidator;
import validator.capture.PawnCaptureValidator;
import validator.data.NameColour;
import validator.path.*;

import java.util.HashMap;
import java.util.Map;

public class MoveManagerFactory {

    public static MoveManager createClassicMoveManager() {

        Map<NameColour, MovementValidator> map = new HashMap<>();

        map.put(new NameColour(Name.PAWN, Colour.WHITE), new Validator(new StraightPathValidator(false,1,-1), new PawnCaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.PAWN, Colour.BLACK), new Validator(new StraightPathValidator(false,1,1), new PawnCaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.ROOK, Colour.WHITE), new Validator(new CrossPathValidator(false,8,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.ROOK, Colour.BLACK), new Validator(new CrossPathValidator(false,8,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.KNIGHT, Colour.WHITE), new Validator(new ComposedPathValidator(true,3,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.KNIGHT, Colour.BLACK), new Validator(new ComposedPathValidator(true,3,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.BISHOP, Colour.WHITE), new Validator(new DiagonalPathValidator(false,8,-1), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.BISHOP, Colour.BLACK), new Validator(new DiagonalPathValidator(false,8,1), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.QUEEN, Colour.WHITE), new Validator(new TriDirectionalPathValidator(false,8,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.QUEEN, Colour.BLACK), new Validator(new TriDirectionalPathValidator(false,8,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.KING, Colour.WHITE), new Validator(new TriDirectionalPathValidator(false,1,0), new CaptureValidator(), new CheckValidator()));
        map.put(new NameColour(Name.KING, Colour.BLACK), new Validator(new TriDirectionalPathValidator(false,1,0), new CaptureValidator(), new CheckValidator()));

        return new MoveManager(map);
    }
}
