package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GamesHelper {
    static int gameRound = 0;
    static Random random = new Random();

    public static int getRandomNumber() {
        int low = 1;
        int high = 100;
        return random.nextInt(high - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static String handleGameInputAndReturnAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        var answer = scanner.next();
        System.out.println("Your answer: " + answer);

        return answer;
    }
}
