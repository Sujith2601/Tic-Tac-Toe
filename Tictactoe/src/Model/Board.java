package Model;

import java.util.*;

public class Board {
    private List<List<Cell>> board;

    public Board(int dimension) {
        board = new ArrayList<>();
        for(int i=0;i<dimension;i++) {
            board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void display() {
        for(int i=0;i<this.board.size();i++) {
            for(int j=0;j<this.board.size();j++) {
                if (this.board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("| " + this.board.get(i).get(j).getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

}
