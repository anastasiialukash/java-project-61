package hexlet.code.games;

import hexlet.code.models.GameModel;

public class GameEngine {

    EvenGame evenGame = new EvenGame();
    Calculator calculator = new Calculator();

    public GameEngine() { }

    public void runGame(String gameNumber, String playerName) {
        String gameIntro = getGameIntro(gameNumber);
        showGameIntro(gameIntro);

        int rightAnswerCount = 0;

        while (GamesHelper.gameRound < 3) {
            GameModel gameModel = getGameModel(gameNumber);
            assert gameModel != null;
            boolean isValid = isValidResult(gameModel.playerAnswer, gameModel.gameAnswer, playerName);
            GamesHelper.gameRound += 1;
            if (isValid) {
                rightAnswerCount += 1;
            }
        }

        if (rightAnswerCount == 3) {
            System.out.println("Congratulations, " + playerName + "!");
        }

        GamesHelper.gameRound = 0;
    }

    private String getGameIntro(String gameNumber) {
        return switch (gameNumber) {
            case "2" -> "Answer 'yes' if the number is even, otherwise answer 'no'.";
            case "3" -> "What is the result of the expression?";
            default -> null;
        };
    }

    private GameModel getGameModel(String gameNumber) {
        if (gameNumber.equals("2")) {
            return evenGame.isEven();
        } else if (gameNumber.equals("3")) {
            return calculator.calc();
        }
        return null;
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
            GamesHelper.gameRound = 3;
            return false;
        }
    }
}
