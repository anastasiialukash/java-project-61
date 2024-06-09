package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.GameModel;

public class Prime {

    public Prime() { }

    Cli cli = new Cli();

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
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

}
