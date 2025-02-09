package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;


public final class Prime {
    private static final int SMALL_PRIME_LIMIT = 3;
    private static final int FIRST_ODD_PRIME = 5;
    private static final int DIVISOR_STEP = 6;

    public void isPrime(String gamerName) {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(gamerName, mainQuestion, questionsAndAnswers);
    }

    public boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= SMALL_PRIME_LIMIT) {
            return true;
        }
        if (number % 2 == 0 || number % SMALL_PRIME_LIMIT == 0) {
            return false;
        }

        int i = FIRST_ODD_PRIME;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += DIVISOR_STEP;
        }

        return true;
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();
        int thirdNumber = GamesHelper.getRandomNumber();

        String firstAnswer = isPrimeNumber(firstNumber) ? "yes" : "no";
        String secondAnswer = isPrimeNumber(secondNumber) ? "yes" : "no";
        String thirdAnswer = isPrimeNumber(thirdNumber) ? "yes" : "no";

        questionsAndAnswers.put(String.valueOf(firstNumber), firstAnswer);
        questionsAndAnswers.put(String.valueOf(secondNumber), secondAnswer);
        questionsAndAnswers.put(String.valueOf(thirdNumber), thirdAnswer);

        return questionsAndAnswers;
    }
}
