package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.GameModel;

public final class EvenGame {
    private Cli cli = new Cli();

    public GameModel isEven() {
        int number = GamesHelper.getRandomNumber();
        String correctAnswer = isEvenNumber(number);
        String answer = cli.handleGameInputAndReturnAnswer(Integer.toString(number));

        return new GameModel(Integer.toString(number), correctAnswer, answer);
    }

    public String isEvenNumber(int number) {
        if (number % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
