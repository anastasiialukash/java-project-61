package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.GameModel;

public final class Progression {
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 11;
    private static final int MAX_NUMBER = 100;
    private Cli cli = new Cli();

    public GameModel getArithmeticProgression() {
        int progressionLength = GamesHelper.getRandomNumberWithinRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int indexOfMissedElement = GamesHelper.getRandomNumberWithinRange(0, progressionLength - 1);
        int[] sequence = getSequence(progressionLength);
        String question = prepareQuestion(sequence, indexOfMissedElement);
        String answer = cli.handleGameInputAndReturnAnswer(question);

        return new GameModel(question, Integer.toString(sequence[indexOfMissedElement]), answer);
    }

    private int[] getSequence(int progressionLength) {
        int[] sequence = new int[progressionLength];
        int firstElement = GamesHelper.getRandomNumberWithinRange(1, MAX_NUMBER);
        int step = GamesHelper.getRandomNumberWithinRange(1, MIN_PROGRESSION_LENGTH);
        sequence[0] = firstElement;

        for (int i = 1; i < progressionLength; i++) {
            sequence[i] = sequence[i - 1] + step;
        }

        return sequence;
    }

    private String prepareQuestion(int[] sequence, int index) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sequence.length; i++) {
            if (i == index) {
                if (index == 0) {
                    result.append("..");
                } else {
                    result.append(" ..");
                }
            } else {
                if (i == 0) {
                    result.append(sequence[i]);
                } else {
                    result.append(" ").append(sequence[i]);
                }
            }
        }

        return result.toString();
    }
}
