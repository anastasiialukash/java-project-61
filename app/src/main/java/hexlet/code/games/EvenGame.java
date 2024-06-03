package hexlet.code.games;

import hexlet.code.models.GameModel;

public class EvenGame {

    public static GameModel isEven() {
        int number = GamesHelper.getRandomNumber();
        String correctAnswer = isEvenNumber(number);
        String answer = GamesHelper.handleGameInputAndReturnAnswer(Integer.toString(number));

        return new GameModel(Integer.toString(number), correctAnswer, answer);
    }

    public static String isEvenNumber(int number) {
        if (number % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
