package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;


public final class EvenGame {

    public void isEven(String gamerName) {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(gamerName, mainQuestion, questionsAndAnswers);
    }

    public String isEvenNumber(int number) {
        if (number % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();
        int thirdNumber = GamesHelper.getRandomNumber();

        String firstAnswer = isEvenNumber(firstNumber);
        String secondAnswer = isEvenNumber(secondNumber);
        String thirdAnswer = isEvenNumber(thirdNumber);

        questionsAndAnswers.put(String.valueOf(firstNumber), firstAnswer);
        questionsAndAnswers.put(String.valueOf(secondNumber), secondAnswer);
        questionsAndAnswers.put(String.valueOf(thirdNumber), thirdAnswer);

        return questionsAndAnswers;
    }
}
