package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.models.GameModel;

import java.util.Objects;

public final class GameEngine {

    private int gameRound = 0;
    private final int maxRounds = 3;
    private final int maxRightAnswers = 3;
    private final EvenGame evenGame = new EvenGame();
    private final Calculator calculator = new Calculator();
    private final GCD calculatorGCD = new GCD();
    private final Progression progression = new Progression();
    private final Prime prime = new Prime();
    private final Cli cli = new Cli();

    public void runGame(String gameNumber, String playerName) {
        if (Objects.equals(gameNumber, "1") || Objects.equals(gameNumber, "0")) {
            cli.exit();
        } else {
            String gameIntro = getGameIntro(gameNumber);

            showGameIntro(gameIntro);

            int rightAnswerCount = 0;

            while (gameRound < maxRightAnswers) {
                GameModel gameModel = getGameModel(gameNumber);
                assert gameModel != null;
                boolean isValid = isValidResult(gameModel.getPlayerAnswer(), gameModel.getGameAnswer(), playerName);
                gameRound += 1;
                if (isValid) {
                    rightAnswerCount += 1;
                }
            }

            if (rightAnswerCount == maxRightAnswers) {
                System.out.println("Congratulations, " + playerName + "!");
            }

            gameRound = 0;
        }
    }

    private String getGameIntro(String gameNumber) {
        return switch (gameNumber) {
            case "2" -> "Answer 'yes' if the number is even, otherwise answer 'no'.";
            case "3" -> "What is the result of the expression?";
            case "4" -> "Find the greatest common divisor of given numbers.";
            case "5" -> "What number is missing in the progression?";
            case "6" -> "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
            default -> null;
        };
    }

    private GameModel getGameModel(String gameNumber) {
        return switch (gameNumber) {
            case "2" -> evenGame.isEven();
            case "3" -> calculator.calc();
            case "4" -> calculatorGCD.calculateGCD();
            case "5" -> progression.getArithmeticProgression();
            case "6" -> prime.isPrime();
            default -> null;
        };
    }

    private void showGameIntro(String gameIntro) {
        System.out.println(gameIntro);
    }

    private boolean isValidResult(String gamerAnswer, String correctAnswer, String name) {
        if (gamerAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is the wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n",
                    gamerAnswer, correctAnswer, name);
            gameRound = maxRounds;
            return false;
        }
    }
}
