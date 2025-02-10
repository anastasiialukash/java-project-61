package hexlet.code;

import java.util.Map;
import java.util.Scanner;


public final class GameEngine {

    private int gameRound = 0;

    public void runGame(String mainGameQuestion, Map<String, String> gameQuestionsAndAnswers) {
        String gamerName = greet();
        showGameIntro(mainGameQuestion);

        int rightAnswerCount = 0;

        int maxRightAnswers = 3;
        for (Map.Entry<String, String> entry : gameQuestionsAndAnswers.entrySet()) {
            if (gameRound >= maxRightAnswers) {
                break;
            }
            String gamerAnswer = handleGameInputAndReturnAnswer(entry.getKey());
            boolean isValid = isValidResult(gamerAnswer, entry.getValue(), gamerName);
            gameRound += 1;
            if (isValid) {
                rightAnswerCount += 1;
            }
        }

        if (rightAnswerCount == maxRightAnswers) {
            System.out.println("Congratulations, " + gamerName + "!");
        }

        gameRound = 0;
    }

    public static String greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name: ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");

        return name;
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
            gameRound = 3;
            return false;
        }
    }

    public static String handleGameInputAndReturnAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        var answer = scanner.next();
        System.out.println("Your answer: " + answer);

        return answer;
    }
}
