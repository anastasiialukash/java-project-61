package hexlet.code.models;

public final class GameModel {
    private final String gameQuestion;
    private final String gameAnswer;
    private final String playerAnswer;

    public GameModel(String question, String answer, String inputAnswer) {
        this.gameQuestion = question;
        this.gameAnswer = answer;
        this.playerAnswer = inputAnswer;
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
