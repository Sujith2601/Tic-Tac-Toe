import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.GameController;
import Model.PlayerType;
import Model.Bot;
import Model.DifficultyLevel;
import Model.Game;
import Model.GameStatus;
import Model.Player;

public class TTT {
    public static void main(String[] args) throws Exception {

        List<Player> players = new ArrayList<>();

        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of the board: ");
        int dimension = sc.nextInt();

        System.out.println("Will you require a bot y/n: ");
        String isBotRequired = sc.next();

        int totalNumberOfPlayers = dimension - 1;

        if(isBotRequired == "y") {

            totalNumberOfPlayers -= 1;

            System.out.println("Enter your bot name:");
            String name = sc.next();

            System.out.println("Enter your bot's symbol: ");
            String symbol = sc.next();

            players.add(new Bot(name, symbol.charAt(0), PlayerType.BOT, DifficultyLevel.EASY));

        }

        for(int i=0;i<totalNumberOfPlayers;i++) {

            System.out.println("Enter the name of Player: ");
            String name = sc.next();

            System.out.println("Enter symbol: ");
            String symbol = sc.next();

            players.add(new Player(name, symbol.charAt(0), PlayerType.HUMAN));

        }

        Game game = gameController.startGame(players, dimension);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {

            System.out.println("This is the current board: ");
            gameController.displayBoard(game);

            System.out.println("Do you want to undo y/n: ");
            String isUndo = sc.next();

            if(isUndo.equals("y")) {
                gameController.undo(game);
            } else {
                gameController.executeNextMove(game);
            }

            if(gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
                System.out.println("Winner of Game is: "+ gameController.getWinner());
            } else {
                System.out.println("Game is tied.");
            }

        }

        sc.close();

    }
}
