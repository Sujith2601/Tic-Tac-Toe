package Model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private String winner;
    private int nextPlayerIndex;

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static class GameBuilder {

        private int dimension;
        private List<Player> players;

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean isValid() throws IllegalArgumentException {

            if(this.dimension<3) throw new IllegalArgumentException();

            if(players.size()!=dimension-1) throw new IllegalArgumentException();

            return true;
        }

        public Game build() {

            Game game = new Game();

            this.isValid();

            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setPlayers(players);
            game.setNextPlayerIndex(0);
            
            return game;
            
        }
    }
}
