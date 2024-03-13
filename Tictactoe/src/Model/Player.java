package Model;

import java.util.Scanner;

public class Player {

    private char symbol;
    private String name;
    private PlayerType playerType;

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove() {

        Scanner sc = new Scanner(System.in);
        
        System.out.println(name + "'s move: Enter the row where you want to make move");
        int row = sc.nextInt();

        System.out.println(name + "'s move: Enter the col where you want to make move");
        int col = sc.nextInt();

        sc.close();

        return new Move(this, new Cell(row, col));

    }
}
