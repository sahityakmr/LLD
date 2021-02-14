package chess;

import chess.piece.Piece;

public class Spot {

    // this is set as final as we don't want anyone c=to change position of a spot.
    // we don't want setters too
    private final int row;
    private final int col;

    private Piece piece;

    public Spot(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public Spot(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty(){
        return piece == null;
    }
}
