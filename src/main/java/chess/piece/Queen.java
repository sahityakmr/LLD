package chess.piece;

import chess.enums.Color;
import chess.enums.PieceType;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color, PieceType.QUEEN);
    }
}
