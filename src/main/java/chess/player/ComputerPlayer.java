package chess.player;

import chess.ChessModel;
import chess.Color;

public class ComputerPlayer extends Player {
    private ChessModel chessModel;

    public ComputerPlayer(Color color, ChessModel chessModel) {
        super(color);
        this.chessModel = chessModel;
    }
}
