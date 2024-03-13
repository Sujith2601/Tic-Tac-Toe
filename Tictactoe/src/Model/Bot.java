package Model;

public class Bot extends Player{
    private DifficultyLevel difficutyLevel;

    public Bot(String name, char symbol, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(name, symbol, playerType);
        this.difficutyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficutyLevel() {
        return difficutyLevel;
    }

    public void setDifficutyLevel(DifficultyLevel difficutyLevel) {
        this.difficutyLevel = difficutyLevel;
    }
}
