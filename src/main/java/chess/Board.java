package chess;

import chess.piece.*;

import static chess.Constants.*;

public class Board {

    private final Spot[][] spots;

    public Board() {
        spots = new Spot[BOARD_SIZE][BOARD_SIZE];
        resetBoard();
    }

    private void resetBoard() {
        initializeAllSpots();
        initializePlayerSet(Color.WHITE);
        initializePlayerSet(Color.BLACK);
    }

    private void initializeAllSpots() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                spots[row][col] = new Spot(row, col);
            }
        }
    }

    private void initializePlayerSet(Color color) {
        initializePawn(color);
        initializeRankedPieces(color);
    }

    private void initializePawn(Color color) {
        setPawnOnRow(color, ChessUtils.getPawnRow(color));
    }

    private void initializeRankedPieces(Color color) {
        int rankedRow = ChessUtils.getRankedRow(color);

        // setting rooks
        spots[rankedRow][0].setPiece(new Rook(color));
        spots[rankedRow][7].setPiece(new Rook(color));

        // setting knight
        spots[rankedRow][1].setPiece(new Knight(color));
        spots[rankedRow][6].setPiece(new Knight(color));

        // setting bishops
        spots[rankedRow][2].setPiece(new Bishop(color));
        spots[rankedRow][5].setPiece(new Bishop(color));

        // setting king
        spots[rankedRow][3].setPiece(new King(color));

        // setting queen
        spots[rankedRow][4].setPiece(new Queen(color));
    }

    private void setPawnOnRow(Color color, int row) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            spots[row][col].setPiece(new Pawn(color));
        }
    }

    public Spot[][] getSpots() {
        return spots;
    }
}
