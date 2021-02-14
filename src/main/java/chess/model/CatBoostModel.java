package chess.model;

import chess.ChessModel;
import chess.Move;

import java.time.Instant;

public class CatBoostModel extends ChessModel {
    private Move getMoveFromModel() {
        // call actual model
        return new Move(1, 1, 1, 1, Instant.now());
    }
}
