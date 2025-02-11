package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;

import java.util.HashMap;
import java.util.Map;

public final class Calculator {
    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int MAX_NUMBER = 100;

    public void calc() {
        GameEngine gameEngine = new GameEngine();
        String mainQuestion = "What is the result of the expression?";
        Map<String, String> questionsAndAnswers = getQuestionsAndAnswers();
        gameEngine.runGame(mainQuestion, questionsAndAnswers);
    }

    private String calcResult(int firstOperand, int secondOperand, String operation) {
        return switch (operation) {
            case "-" -> String.valueOf(firstOperand - secondOperand);
            case "+" -> String.valueOf(firstOperand + secondOperand);
            case "*" -> String.valueOf(firstOperand * secondOperand);
            default -> null;
        };
    }

    private String[] prepareExpression() {
        final char[] operators = {'+', '-', '*'};

        int firstNumber = GamesHelper.getRandomNumber(MAX_NUMBER);
        int secondNumber = GamesHelper.getRandomNumber(MAX_NUMBER);

        String firstOperand = String.valueOf(Math.max(firstNumber, secondNumber));
        String secondOperand = String.valueOf(Math.min(firstNumber, secondNumber));

        int indexOperator = GamesHelper.getRandomNumberWithinRange(0, operators.length - 1);
        String operator = String.valueOf(operators[indexOperator]);

        return new String[]{firstOperand, secondOperand, operator};
    }

    private String getQuestion(String[] question) {
        return question[0] + " " + question[2] + " " + question[1];
    }

    private String getAnswer(String[] question) {
        int firstOperand = Integer.parseInt(question[0]);
        int secondOperand = Integer.parseInt(question[1]);
        return calcResult(firstOperand, secondOperand, question[2]);
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] expression = prepareExpression();
            String question = getQuestion(expression);
            String answer = getAnswer(expression);
            questionsAndAnswers.put(question, answer);
        }
        return questionsAndAnswers;
    }
}
