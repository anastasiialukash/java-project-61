package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.models.GameModel;

public class ArithmeticProgression {
    Cli cli = new Cli();

    public GameModel getArithmeticProgression() {
        int progressionLength = GamesHelper.getRandomNumberWithinRange(5, 11);
        int indexOfMissedElement = GamesHelper.getRandomNumberWithinRange(0, progressionLength - 1);
        int[] sequence = getSequence(progressionLength);
        String question = prepareQuestion(sequence, indexOfMissedElement);
        String answer = cli.handleGameInputAndReturnAnswer(question);

        return new GameModel(question, Integer.toString(sequence[indexOfMissedElement]), answer);
    }

    private int[] getSequence(int progressionLength) {
        int[] sequence = new int[progressionLength];
        int firstElement = GamesHelper.getRandomNumberWithinRange(1, 100);
        int step = GamesHelper.getRandomNumberWithinRange(1, 5);
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
                result.append(" .. ");
            } else {
                result.append(" ").append(sequence[i]).append(" ");
            }
        }

        return result.toString();
    }
}
