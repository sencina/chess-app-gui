package validator.path;

import exception.InvalidMovementException;
import game.board.component.Position;
import game.movements.Movement;
import interfaces.Board;

public class ComposedPathValidator extends AbstractPathValidator{


    public ComposedPathValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public boolean validate(Movement movement, Board board) throws InvalidMovementException {


        int fromX = movement.getFrom().getCol();
        int fromY = movement.getFrom().getRow();
        int toX = movement.getTo().getCol();
        int toY = movement.getTo().getRow();

        int diffX = Math.abs(fromX - toX);
        int diffY = Math.abs(fromY - toY);

        int directionX = fromX < toX ? 1 : -1;
        int directionY = fromY < toY ? 1 : -1;

        boolean inLimit = (diffX + diffY) == limit && diffX != 0 && diffY != 0;

        if (inLimit) {

            //Check if there is a piece in the way (x path)
            boolean validPath = jumper || checkPath(movement.getFrom(),movement.getTo(),true,board) || checkPath(movement.getFrom(),movement.getTo(),false,board);

            if (validPath) return true;
            else throw new InvalidMovementException("There is a piece in the way");

        }

        throw new InvalidMovementException("Invalid movement");
    }

    private boolean checkPath(Position from, Position to, boolean x, Board board) {

        if (x){
            int minX = Math.min(from.getCol(), to.getCol());
            int maxX = Math.max(from.getCol(), to.getCol());

            for (int i = minX + 1; i < maxX; i++) {
                Position position = board.getPosition(i, from.getRow());
                if (!position.isEmpty()) {
                    return false;
                }
            }

            int minY = Math.min(from.getRow(), to.getRow());
            int maxY = Math.max(from.getRow(), to.getRow());
            boolean directionY = from.getRow() > to.getRow();

            for (int i = minY + 1; i <= maxY; i++) {
                Position position = board.getPosition(directionY ? maxX : minX , i);
                if (!position.isEmpty()) {
                    return false;
                }
            }

        } else {

            int minY = Math.min(from.getRow(), to.getRow());
            int maxY = Math.max(from.getRow(), to.getRow());

            for (int i = minY + 1; i <= maxY; i++) {
                Position position = board.getPosition(from.getCol(), i);
                if (!position.isEmpty()) {
                    return false;
                }
            }

            int minX = Math.min(from.getCol(), to.getCol());
            int maxX = Math.max(from.getCol(), to.getCol());
            boolean directionX = from.getCol() > to.getCol();

            for (int i = minX + 1; i < maxX; i++) {
                Position position = board.getPosition(i, directionX ? maxY : minY);
                if (!position.isEmpty()) {
                    return false;
                }
            }

        }

        return true;

    }
}
