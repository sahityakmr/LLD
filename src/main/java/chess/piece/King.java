package chess.piece;

import chess.enums.Color;
import chess.enums.PieceType;

public class King extends Piece{
    public King(Color color) {
        super(color, PieceType.KING);
    }
}
