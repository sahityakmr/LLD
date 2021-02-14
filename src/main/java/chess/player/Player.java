package chess.player;

import chess.Color;
import chess.Move;

import java.time.Instant;
import java.util.UUID;

public abstract class Player {
    private final Color color;
    private String playerName;

    public Player(Color color) {
        this(color, UUID.randomUUID().toString());
    }

    public Player(Color color, String playerName) {
        this.color = color;
        this.playerName = playerName;
    }

    public Color getColor() {
        return color;
    }

    public Move play() {
        return new Move(0, 0, 0, 0, Instant.now());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
