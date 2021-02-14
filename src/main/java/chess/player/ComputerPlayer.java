package chess.player;

import chess.Board;
import chess.ChessModel;
import chess.Color;
import chess.Move;

public class ComputerPlayer extends Player {
    private ChessModel chessModel;

    public ComputerPlayer(Color color, ChessModel chessModel) {
        super(color);
        this.chessModel = chessModel;
    }

    @Override
    public Move play() {
        return chessModel.getBestMove(Board.getInstance(), this);
    }
}
