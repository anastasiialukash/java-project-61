package hexlet.code;

import java.util.Random;

public final class GamesHelper {

    static Random random = new Random();

    public static int getRandomNumber() {
        int low = 1;
        int high = 100;
        return random.nextInt(high - low) + low;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}