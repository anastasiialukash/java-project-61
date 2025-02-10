package hexlet.code;

import java.util.Map;
import java.util.Scanner;


public final class GameEngine {

    private int gameRound = 0;
    private static final int MAX_ROUNDS = 3;

    public void runGame(String mainGameQuestion, Map<String, String> gameQuestionsAndAnswers) {
        String playerName = greet();
        showGameIntro(mainGameQuestion);

        int rightAnswerCount = 0;

        for (Map.Entry<String, String> entry : gameQuestionsAndAnswers.entrySet()) {
            if (gameRound >= MAX_ROUNDS) {
                break;
            }
            String gamerAnswer = handleGameInputAndReturnAnswer(entry.getKey());
            boolean isValid = isValidResult(gamerAnswer, entry.getValue(), playerName);
            gameRound += 1;
            if (isValid) {
                rightAnswerCount += 1;
            }
        }

        if (rightAnswerCount == MAX_ROUNDS) {
            System.out.println("Congratulations, " + playerName + "!");
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
            gameRound = MAX_ROUNDS;
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
