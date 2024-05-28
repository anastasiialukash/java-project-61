package hexlet.code.games;

import java.util.Random;

public class GamesHelper {
    public static int getRandomNumber() {
        int low = 1;
        int high = 100;
        Random random = new Random();
        return random.nextInt(high - low) + low;
    }
}
