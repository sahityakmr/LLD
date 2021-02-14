package chess.piece;

import chess.enums.Color;
import chess.enums.PieceType;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color, PieceType.PAWN);
    }
}
