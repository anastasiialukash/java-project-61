package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.GameEngine.MAX_ROUNDS;

public final class GCD {
    private static final int MAX_NUMBER = 100;

    public void calculateGCD() {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "Find the greatest common divisor of given numbers.";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(mainQuestion, questionsAndAnswers);
    }

    private int findGCD(int firstNumber, int secondNumber) {
        if (firstNumber == secondNumber) {
            return firstNumber;
        } else {
            int result = Math.min(firstNumber, secondNumber);
            while (result > 0) {
                if (firstNumber % result == 0 && secondNumber % result == 0) {
                    break;
                }
                result--;
            }
            return result;
        }
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < MAX_ROUNDS; i++) {
            int firstNumber = GamesHelper.getRandomNumber(MAX_NUMBER);
            int secondNumber = GamesHelper.getRandomNumber(MAX_NUMBER);
            String question = firstNumber + " " + secondNumber;
            String answer = String.valueOf(findGCD(firstNumber, secondNumber));
            questionsAndAnswers.put(question, answer);
        }

        return questionsAndAnswers;
    }
}
