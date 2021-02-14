package chess.player;

import chess.Color;
import chess.Move;

import java.time.Instant;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(Color color) {
        super(color);
    }

    public HumanPlayer(Color color, String playerName) {
        super(color, playerName);
    }

    @Override
    public Move play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey "+ this.getPlayerName() +", Input fromRow, toRow, fromCol, toCol");
        return new Move(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), Instant.now());
    }
}
