package Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Board;
import Model.Cell;
import Model.Player;

public class Oof1WinningStrategy implements GameWinningStrategy{

    List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList<>();
    HashMap<Character, Integer> leftTopDiagonal = new HashMap<>();
    HashMap<Character, Integer> rightTopDiagonal = new HashMap<>();

    public Oof1WinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col) {
        //Check if the cell is lying on top left diagonal.
        return row == col;
    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int dimension) {
        //Check if the cell is lying on top right diagonal.
        return row + col == dimension - 1;
    }

    @Override
    public boolean checkWinner(Board board, Player currentPlayer, Cell cell) {

        char symbol = currentPlayer.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = board.getBoard().size();

        //Increment the symbol count for the row, col and diagonal (if index lies on diagonal).
        if (!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol,
                rowSymbolCounts.get(row).get(symbol) + 1);

        if (!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol,
                colSymbolCounts.get(col).get(symbol) + 1);


        if (isCellOnTopLeftDiagonal(row, col)) {
            if (!leftTopDiagonal.containsKey(symbol)) {
                leftTopDiagonal.put(symbol, 0);
            }
            leftTopDiagonal.put(symbol,
                    leftTopDiagonal.get(symbol) + 1);
        }

        if (isCellOnTopRightDiagonal(row, col, dimension)) {
            if (!rightTopDiagonal.containsKey(symbol)) {
                rightTopDiagonal.put(symbol, 0);
            }
            rightTopDiagonal.put(symbol,
                    rightTopDiagonal.get(symbol) + 1);
        }

        if (rowSymbolCounts.get(row).get(symbol) == dimension ||
            colSymbolCounts.get(col).get(symbol) == dimension) {
            return true;
        }

        if (isCellOnTopLeftDiagonal(row, col)) {
            return leftTopDiagonal.get(symbol) == dimension;
        }

        if (isCellOnTopRightDiagonal(row, col, dimension)) {
            return leftTopDiagonal.get(symbol) == dimension;
        }

        return false;

    }

}
