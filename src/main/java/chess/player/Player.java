package chess.player;

import chess.Color;
import chess.Move;

import java.time.Instant;

public abstract class Player {
    private final Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Move play() {
        return new Move(0, 0, 0, 0, Instant.now());
    }
}
