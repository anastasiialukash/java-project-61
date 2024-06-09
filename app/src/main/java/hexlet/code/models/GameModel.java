package hexlet.code.models;

public final class GameModel {
    private String gameQuestion;
    private String gameAnswer;
    private String playerAnswer;

    public GameModel(String gameQuestion, String gameAnswer, String playerAnswer) {
        this.gameQuestion = gameQuestion;
        this.gameAnswer = gameAnswer;
        this.playerAnswer = playerAnswer;
    }

    public String getGameQuestion() {
        return gameQuestion;
    }

    public String getGameAnswer() {
        return gameAnswer;
    }

    public String getPlayerAnswer() {
        return playerAnswer;
    }
}
