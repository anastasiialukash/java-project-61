package hexlet.code.games;

import hexlet.code.models.GameModel;

public class GameEngine {
    public static void runGame(String gameNumber, String playerName) {
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

    private static String getGameIntro(String gameNumber) {
        return switch (gameNumber) {
            case "2" -> "Answer 'yes' if the number is even, otherwise answer 'no'.";
            case "3" -> "What is the result of the expression?";
            default -> null;
        };
    }

    private static GameModel getGameModel(String gameNumber) {
        if (gameNumber.equals("2")) {
            return EvenGame.isEven();
        } else if (gameNumber.equals("3")) {
            return Calculator.calc();
        }
        return null;
    }

    private static void showGameIntro(String gameIntro) {
        System.out.println(gameIntro);
    }

    private static boolean isValidResult(String gamerAnswer, String correctAnswer, String name) {
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
