package hexlet.code.games;

import hexlet.code.StartPage;
import hexlet.code.models.GameModel;

import java.util.Random;
import java.util.Scanner;

public class GamesHelper {
    static int counter = 0;
    static Random random = new Random();

    public static int getRandomNumber() {
        int low = 1;
        int high = 100;
        return random.nextInt(high - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static void showGameIntro(String gameIntro){
        System.out.println(gameIntro);
    }

    public static String handleGameInputAndReturnAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        var answer = scanner.next();
        System.out.println("Your answer: " + answer);

        return answer;
    }

    public static void validateResult(String gamerAnswer, String correctAnswer, String name) {
        if (gamerAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is the wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!\n",
                    gamerAnswer, correctAnswer, name);
            counter = 3;
        }
    }

    public static void runGame(GameModel gameModel) {
        GamesHelper.showGameIntro(gameModel.gameIntro);

        int rightAnswerCount = 0;

        while (GamesHelper.counter < 3) {
            StartPage.selectGame(gameModel.gameNumber, gameModel.playerName);
            GamesHelper.validateResult(gameModel.playerAnswer, gameModel.gameAnswer, gameModel.playerName);
            GamesHelper.counter += 1;
            rightAnswerCount += 1;
        }

        if (rightAnswerCount == 3) {
            System.out.println("Congratulations, " + gameModel.playerName + "!");
        }
    }
}
