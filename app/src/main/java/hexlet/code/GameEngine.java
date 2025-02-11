package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public final class GameEngine {

    private int gameRound = 0;
    private static final int MAX_ROUNDS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void runGame(String mainGameQuestion, Map<String, String> gameQuestionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name: ");

        String playerName = SCANNER.next();
        System.out.println("Hello, " + playerName + "!");

        System.out.println(mainGameQuestion);

        int rightAnswerCount = 0;

        for (Map.Entry<String, String> entry : gameQuestionsAndAnswers.entrySet()) {
            String question = entry.getKey();
            String correctAnswer = entry.getValue();

            if (gameRound >= MAX_ROUNDS) {
                break;
            }

            System.out.println("Question: " + question);
            var answer = SCANNER.next();
            System.out.println("Your answer: " + answer);

            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
                rightAnswerCount += 1;
            } else {
                System.out.printf("'%s' is the wrong answer ;(. "
                                + "Correct answer was '%s'.\nLet's try again, %s!\n",
                        answer, correctAnswer, playerName);
                gameRound = MAX_ROUNDS;
            }

            gameRound += 1;
        }

        if (rightAnswerCount == MAX_ROUNDS) {
            System.out.println("Congratulations, " + playerName + "!");
        }

        gameRound = 0;
        SCANNER.close();
    }
}
