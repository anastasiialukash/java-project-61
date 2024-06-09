package hexlet.code;

import java.util.Random;

public final class GamesHelper {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 100;

    public static int getRandomNumber() {
        int low = 1;
        return random.nextInt(MAX_NUMBER - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
