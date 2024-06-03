package hexlet.code.models;

public class GameModel {
    public String gameQuestion;
    public String gameAnswer;
    public String playerAnswer;

    public GameModel(String gameQuestion, String gameAnswer, String playerAnswer) {
        this.gameQuestion = gameQuestion;
        this.gameAnswer = gameAnswer;
        this.playerAnswer = playerAnswer;
    }
}
