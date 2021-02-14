package chess;

import chess.player.Player;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class ChessModel {
    static boolean mlModelConfigured;

    public Move getBestMove(Board board, Player player) {
        return mlModelConfigured ? getMoveFromModel() : randomMoveGenerator();
    }

    private Move getMoveFromModel() {
        // call actual model
        return new Move(0, 0, 0, 0, Instant.now());
    }

    private Move randomMoveGenerator() {
        List<Integer> moveNums = new ArrayList<>();
        IntStream.range(0, 7).distinct().limit(4).forEach(moveNums::add);
        return new Move(moveNums.get(0), moveNums.get(1), moveNums.get(2), moveNums.get(3), Instant.now());
    }
}
