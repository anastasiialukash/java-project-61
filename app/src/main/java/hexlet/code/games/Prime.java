package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.GameEngine.MAX_ROUNDS;


public final class Prime {
    private static final int SMALL_PRIME_LIMIT = 3;
    private static final int FIRST_ODD_PRIME = 5;
    private static final int DIVISOR_STEP = 6;
    private static final int MAX_NUMBER = 100;

    public void isPrime() {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(mainQuestion, questionsAndAnswers);
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
        for (int i = 0; i < MAX_ROUNDS; i++) {
            int question = GamesHelper.getRandomNumber(MAX_NUMBER);
            String answer = isPrimeNumber(question) ? "yes" : "no";
            questionsAndAnswers.put(String.valueOf(question), answer);
        }

        return questionsAndAnswers;
    }
}
