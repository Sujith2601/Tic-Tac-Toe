package Strategy;

import Model.Board;
import Model.Cell;
import Model.Player;

public interface GameWinningStrategy {

    boolean checkWinner(Board board, Player currentPlayer, Cell cell);
    
}
