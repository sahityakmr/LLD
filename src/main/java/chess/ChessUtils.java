package chess;

import chess.player.Player;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static chess.Constants.*;

public class ChessUtils {

    public static int getPawnRow(Color color) {
        if (color == Color.WHITE) {
            return WHITE_PAWN_ROW;
        } else {
            return BLACK_PAWN_ROW;
        }
    }

    public static int getRankedRow(Color color) {
        if (color == Color.WHITE) {
            return WHITE_RANKED_ROW;
        } else {
            return BLACK_RANKED_ROW;
        }
    }

    public static Player getFirstPlayer(Player player1, Player player2) {
        if (player1.getColor() == Color.WHITE)
            return player1;
        return player2;
    }

    public static Player togglePlayer(Player currentPlayer, Player player1, Player player2) {
        if (currentPlayer == player1)
            return player2;
        return player1;
    }

    public static ArrayList<Move> getTestMoves() {
        ArrayList<Move> moves = new ArrayList<>();

        Move move1 = new Move(6, 4, 4, 4, Instant.now());

        //waitFor(300);
        Move move2 = new Move(1, 4, 3, 4, Instant.now());

        //waitFor(500);
        Move move3 = new Move(7, 5, 5, 3, Instant.now());

        //waitFor(2000);
        Move move4 = new Move(0, 3, 1, 4, Instant.now());

        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        moves.add(move4);
        return moves;
    }

    public static void waitFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ChessModel getAppropriateModel(List<ChessModel> chessModels, int level) {
        // return model according to level
        return chessModels.get(0);
    }
}
