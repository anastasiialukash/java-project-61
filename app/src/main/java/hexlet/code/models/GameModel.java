package hexlet.code.models;

public final class GameModel {
    private final String gameQuestion;
    private final String gameAnswer;
    private final String playerAnswer;

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
