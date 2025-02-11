package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;


public final class EvenGame {

    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_QUESTIONS = 3;

    public void isEven() {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(mainQuestion, questionsAndAnswers);
    }

    public boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int question = GamesHelper.getRandomNumber(MAX_NUMBER);
            String answer = isEvenNumber(question) ? "yes" : "no";
            questionsAndAnswers.put(String.valueOf(question), answer);
        }

        return questionsAndAnswers;
    }
}
