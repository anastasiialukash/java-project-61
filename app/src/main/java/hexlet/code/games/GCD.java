package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

public final class GCD {
    private static final int MAX_NUMBER = 100;
    private static final int NUMBER_OF_QUESTIONS = 3;

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

    private int[] getNumbers() {
        int firstNumber = GamesHelper.getRandomNumber(MAX_NUMBER);
        int secondNumber = GamesHelper.getRandomNumber(MAX_NUMBER);
        return new int[] {firstNumber, secondNumber};
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int[] pair = getNumbers();
            String question = pair[0] + " " + pair[1];
            String answer = String.valueOf(findGCD(pair[0], pair[1]));
            questionsAndAnswers.put(question, answer);
        }

        return questionsAndAnswers;
    }
}
