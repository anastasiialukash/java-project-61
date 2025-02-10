package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.GamesHelper;
import hexlet.code.models.ExpressionModel;

import java.util.HashMap;
import java.util.Map;

public final class Calculator {
    private static final int RANGE_LIMIT = 4;
    private static final int PLUS_ID = 1;
    private static final int MINUS_ID = 2;
    private static final int MULTIPLY_ID = 3;

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

    private ExpressionModel prepareExpression() {
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();

        int firstOperandInt = Math.max(firstNumber, secondNumber);
        int secondOperandInt = Math.min(firstNumber, secondNumber);

        String operation = getRandomOperation(GamesHelper.getRandomNumberWithinRange(1, RANGE_LIMIT));

        return new ExpressionModel(firstOperandInt, secondOperandInt, operation);
    }

    private String getRandomOperation(int key) {
        Map<Integer, String> operations = new HashMap<>();
        operations.put(PLUS_ID, "+");
        operations.put(MINUS_ID, "-");
        operations.put(MULTIPLY_ID, "*");

        return operations.get(key);
    }

    private String getAnswer(ExpressionModel expression) {
        return calcResult(expression.getFirstOperand(), expression.getSecondOperand(), expression.getOperation());
    }

    private Map<String, String> getQuestionsAndAnswers() {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        ExpressionModel firstExpression = prepareExpression();
        ExpressionModel secondExpression = prepareExpression();
        ExpressionModel thirdExpression = prepareExpression();

        String firstAnswer = getAnswer(firstExpression);
        String secondAnswer = getAnswer(secondExpression);
        String thirdAnswer =  getAnswer(thirdExpression);

        questionsAndAnswers.put(firstExpression.toString(), firstAnswer);
        questionsAndAnswers.put(secondExpression.toString(), secondAnswer);
        questionsAndAnswers.put(thirdExpression.toString(), thirdAnswer);

        return questionsAndAnswers;
    }
}
