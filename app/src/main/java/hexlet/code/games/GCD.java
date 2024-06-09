package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.GameModel;

public class GCD {
    public GCD() { }

    private Cli cli = new Cli();

    public GameModel calculateGCD() {
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();
        String question = firstNumber + " " + secondNumber;
        int correctAnswer = findGCD(firstNumber, secondNumber);
        String answer = cli.handleGameInputAndReturnAnswer(question);

        return new GameModel(question, Integer.toString(correctAnswer), answer);
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
}
