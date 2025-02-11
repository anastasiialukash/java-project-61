package hexlet.code;

import java.util.Random;

public final class GamesHelper {

    private static final Random RANDOM = new Random();

    public static int getRandomNumber(int maxNumber) {
        int low = 1;
        return RANDOM.nextInt(maxNumber - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
