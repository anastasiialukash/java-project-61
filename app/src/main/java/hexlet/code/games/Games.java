package hexlet.code.games;

import java.util.Scanner;

public class Games {
    static int counter = 0;

    public static void isEven(String gamerName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int rightAnswerCount = 0;

        while (counter < 3) {
            int number = GamesHelper.getRandomNumber();
            String correctAnswer = isEvenNumber(number);
            System.out.println("Question: " + number);
            var answer = scanner.next();
            System.out.println("Your answer: " + answer);
            validateResult(answer, correctAnswer, gamerName);
            counter += 1;
            rightAnswerCount += 1;
        }

        if (rightAnswerCount == 3) {
            System.out.println("Congratulations, " + gamerName + "!");
        }
    }

    public static String isEvenNumber(int number) {
        if (number % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
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
}
