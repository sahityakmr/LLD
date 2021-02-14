package chess.model;

import chess.*;
import chess.enums.Color;
import chess.enums.GameState;
import chess.piece.Piece;
import chess.enums.PieceType;
import chess.player.HumanPlayer;
import chess.player.Player;
import chess.utils.ChessUtils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static chess.utils.ChessUtils.getTestMoves;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private GameState currentState;
    private ArrayList<Move> gameMoves;
    private boolean enableLogging;
    private List<ChessModel> chessModels;
    private int level;

    public Game(Board board, Player player1, Player player2) {
        gameMoves = new ArrayList<Move>();
        currentState = GameState.NEW;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public static void main(String[] args) {
        Board board = Board.getInstance();

        Player varnika = new HumanPlayer(Color.WHITE, "Varnika");
        Player sahitya = new HumanPlayer(Color.BLACK, "Sahitya");

        Game game = new Game(board, varnika, sahitya);
        game.setEnableLogging(true);
        game.setLevel(3);
        game.gameMoves = getTestMoves();
        game.chessModels = Collections.singletonList(new CatBoostModel());
        // game.replayGame();
        game.startGamePlay(ChessUtils.getAppropriateModel(game.chessModels, game.level));
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private void replayGame() {
        for (int i = 0; i < gameMoves.size(); i++) {
            printMoveDesc(gameMoves.get(i));
        }
    }

    private void printMoveDesc(Move move) {
        movePlayer(move);
    }

    private void movePlayer(Move move) {
        Spot oldSpot = board.getSpots()[move.getFromRow()][move.getFromCol()];
        Spot newSpot = board.getSpots()[move.getToRow()][move.getToCol()];

        if (!newSpot.isEmpty() && newSpot.getPiece().getPieceType() == PieceType.KING) {
            // log player won
            currentState = GameState.ENDED;
        }

        Piece pieceInvolvedInThisMove = oldSpot.getPiece();
        oldSpot.setPiece(null);
        newSpot.setPiece(pieceInvolvedInThisMove);

        if (enableLogging)
            logMove(pieceInvolvedInThisMove, move);
    }

    private void logMove(Piece piece, Move move) {
        System.out.printf("%s %s moved from %d, %d to %d, %d at %s%n",
                piece.getColor().toString(),
                piece.getPieceType().toString(),
                move.getFromRow(),
                move.getFromCol(),
                move.getToRow(),
                move.getToCol(),
                ZonedDateTime.ofInstant(move.getInstant(), ZoneId.of("UTC")));
    }

    private void startGamePlay(ChessModel chessModel) {
        if (player1.getColor() == player2.getColor()) {
            throw new RuntimeException("PLayer's are cheating!");
        }

        Player currentPlayer = ChessUtils.getFirstPlayer(player1, player2);
        currentState = GameState.IN_PROGRESS;

        while (currentState == GameState.IN_PROGRESS) {
            Move moveFromModel = currentPlayer.play();
            movePlayer(moveFromModel);
            currentPlayer = ChessUtils.togglePlayer(currentPlayer, player1, player2);
        }
    }

    public boolean isEnableLogging() {
        return enableLogging;
    }

    public void setEnableLogging(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }
}
