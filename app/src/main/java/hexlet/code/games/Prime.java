package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.GameModel;

public final class Prime {
    private static final int SMALL_PRIME_LIMIT = 3;
    private static final int FIRST_ODD_PRIME = 5;
    private static final int DIVISOR_STEP = 6;

    private final Cli cli = new Cli();

    public GameModel isPrime() {
        int number = GamesHelper.getRandomNumber();
        String correctAnswer = isPrimeNumber(number) ? "yes" : "no";
        String answer = cli.handleGameInputAndReturnAnswer(Integer.toString(number));

        return new GameModel(Integer.toString(number), correctAnswer, answer);
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

}
