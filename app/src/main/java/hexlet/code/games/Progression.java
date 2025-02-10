package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

public final class Progression {
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 11;
    private static final int MAX_NUMBER = 100;

    public void getArithmeticProgression() {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "What number is missing in the progression?";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(mainQuestion, questionsAndAnswers);
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

    private String[] getQuestionAndAnswer() {
        int progressionLength = GamesHelper.getRandomNumberWithinRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int indexOfMissedElement = GamesHelper.getRandomNumberWithinRange(0, progressionLength - 1);
        int[] questionSequence = getSequence(progressionLength);
        String question = prepareQuestion(questionSequence, indexOfMissedElement);
        String answer = String.valueOf(questionSequence[indexOfMissedElement]);

        return new String[]{question, answer};
    }


    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        String[] firstPair = getQuestionAndAnswer();
        String[] secondPair = getQuestionAndAnswer();
        String[] thirdPair = getQuestionAndAnswer();

        questionsAndAnswers.put(firstPair[0], firstPair[1]);
        questionsAndAnswers.put(secondPair[0], secondPair[1]);
        questionsAndAnswers.put(thirdPair[0], thirdPair[1]);

        return questionsAndAnswers;
    }
}
