package hexlet.code.games;

import hexlet.code.models.GameModel;

public class EvenGame {

    public static void isEven(String gamerName) {
        GamesHelper.showGameIntro("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int rightAnswerCount = 0;

        while (GamesHelper.counter < 3) {
            int number = GamesHelper.getRandomNumber();
            String correctAnswer = isEvenNumber(number);
            String answer = GamesHelper.handleGameInputAndReturnAnswer(Integer.toString(number));
            GamesHelper.validateResult(answer, correctAnswer, gamerName);
            GamesHelper.counter += 1;
            rightAnswerCount += 1;
        }

        if (rightAnswerCount == 3) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
    }

    public static GameModel runEvenGame(String gamerName) {
        String gameIntro = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        int number = GamesHelper.getRandomNumber();
        String correctAnswer = isEvenNumber(number);
        String answer = GamesHelper.handleGameInputAndReturnAnswer(Integer.toString(number));

        return new GameModel("2", gameIntro, Integer.toString(number), correctAnswer, gamerName, answer);
    }

    public static String isEvenNumber(int number) {
        if (number % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
