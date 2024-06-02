package hexlet.code.models;

public class GameModel {
    public String gameNumber;
    public String gameIntro;
    public String gameQuestion;
    public String gameAnswer;
    public String playerName;
    public String playerAnswer;

    public GameModel(String gameNumber, String gameIntro, String gameQuestion, String gameAnswer, String playerName, String playerAnswer) {
        this.gameNumber = gameNumber;
        this.gameIntro = gameIntro;
        this.gameQuestion = gameQuestion;
        this.gameAnswer = gameAnswer;
        this.playerName = playerName;
        this.playerAnswer = playerAnswer;
    }
}
