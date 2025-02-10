package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

public final class GCD {
    public GCD() { }

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
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();
        return new int[] {firstNumber, secondNumber};
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        int[] firstPair = getNumbers();
        int[] secondPair = getNumbers();
        int[] thirdPair = getNumbers();

        String firstQuestion = firstPair[0] + " " + firstPair[1];
        String secondQuestion = secondPair[0] + " " + secondPair[1];
        String thirdQuestion = thirdPair[0] + " " + thirdPair[1];

        int firstAnswer = findGCD(firstPair[0], firstPair[1]);
        int secondAnswer = findGCD(secondPair[0], secondPair[1]);
        int thirdAnswer = findGCD(thirdPair[0], thirdPair[1]);

        questionsAndAnswers.put(firstQuestion, String.valueOf(firstAnswer));
        questionsAndAnswers.put(secondQuestion, String.valueOf(secondAnswer));
        questionsAndAnswers.put(thirdQuestion, String.valueOf(thirdAnswer));

        return questionsAndAnswers;
    }
}
