package Controller;

import java.util.List;

import Model.Game;
import Model.GameStatus;
import Model.Move;
import Model.Player;

public class GameController {

    public Game startGame(List<Player> players, int dimension) {
        Game game = Game.getBuilder().setDimension(dimension).setPlayers(players).build();
        return game;
    }

    public void undo() {

    }

    public void executeNextMove(Move move) {

    }

    public void displayBoard(Game game) {
        game.getBoard().display();
    }

    public Player getWinner() {
        return null;
    }

    public GameStatus getGameStatus() {
        return null;
    }

}
