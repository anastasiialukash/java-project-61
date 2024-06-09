package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.GamesHelper;
import hexlet.code.models.ExpressionModel;
import hexlet.code.models.GameModel;

import java.util.HashMap;
import java.util.Map;

public final class Calculator {
    private static final int RANGE_LIMIT = 4;
    private static final int PLUS_ID = 1;
    private static final int MINUS_ID = 2;
    private static final int MULTIPLY_ID = 3;

    private final Cli cli = new Cli();

    public GameModel calc() {
        ExpressionModel expression = prepareExpression();
        String correctAnswer = calcResult(expression.getFirstOperand(), expression.getSecondOperand(),
                expression.getOperation());
        String answer = cli.handleGameInputAndReturnAnswer(expression.toString());

        return new GameModel(expression.toString(), correctAnswer, answer);
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
}
