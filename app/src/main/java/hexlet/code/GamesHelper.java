package hexlet.code;

import java.util.Random;

public final class GamesHelper {

    private static Random random = new Random();
    private final static int MAX_NUMBER = 100;

    public static int getRandomNumber() {
        int low = 1;
        int high = MAX_NUMBER;
        return random.nextInt(high - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
