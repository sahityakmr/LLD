package chess.piece;

import chess.enums.Color;
import chess.enums.PieceType;

public abstract class Piece {
    private final Color color;
    private final PieceType pieceType;

    private boolean killed;

    public Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    public Color getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
