package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.GameEngine.MAX_ROUNDS;

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

    private String[] getQuestionAndAnswer() {
        int progressionLength = GamesHelper.getRandomNumberWithinRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int firstElement = GamesHelper.getRandomNumberWithinRange(1, MAX_NUMBER);
        int step = GamesHelper.getRandomNumberWithinRange(1, MIN_PROGRESSION_LENGTH);
        int indexOfMissedElement = GamesHelper.getRandomNumberWithinRange(0, progressionLength - 1);

        String[] sequence = generateSequence(progressionLength, firstElement, step, indexOfMissedElement);
        String answer = sequence[indexOfMissedElement];
        String question = String.join(" ", sequence).replace(answer, "..");
        return new String[]{question, answer};
    }

    private String[] generateSequence(int progressionLength, int firstElement, int step, int indexOfMissedElement) {
        String[] sequence = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            sequence[i] = String.valueOf(firstElement + (i * step));
        }

        return sequence;
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < MAX_ROUNDS; i++) {
            String[] questionAndAnswer = getQuestionAndAnswer();
            questionsAndAnswers.put(questionAndAnswer[0], questionAndAnswer[1]);
        }

        return questionsAndAnswers;
    }
}
