package Model;

import java.util.List;

@SuppressWarnings("unused")
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int dimension;
    private GameStatus gameStatus;
    private String winner;
    private int nextPlayerIndex;
}
