package validator.movement.response;

import interfaces.Piece;

import java.util.Collections;
import java.util.List;

public class ValidatorResponse {

    private boolean valid;
    private List<Piece> pieces;

    public ValidatorResponse(boolean valid) {
        this.valid = valid;
        this.pieces = Collections.emptyList();
    }

    public ValidatorResponse(boolean valid, List<Piece> pieces) {
        this.valid = valid;
        this.pieces = pieces;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isEmpty() {
        return pieces.isEmpty();
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
