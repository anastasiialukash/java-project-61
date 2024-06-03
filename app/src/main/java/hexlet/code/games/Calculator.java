package hexlet.code.games;

import hexlet.code.models.ExpressionModel;
import hexlet.code.models.GameModel;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public static GameModel calc() {
        ExpressionModel expression = prepareExpression();
        String correctAnswer = calcResult(expression.firstOperand, expression.secondOperand, expression.operation);
        String answer = GamesHelper.handleGameInputAndReturnAnswer(expression.toString());

        return new GameModel(expression.toString(), correctAnswer, answer);
    }

    private static String calcResult(int firstOperand, int secondOperand, String operation) {
        return switch (operation) {
            case "-" -> String.valueOf(firstOperand - secondOperand);
            case "+" -> String.valueOf(firstOperand + secondOperand);
            case "*" -> String.valueOf(firstOperand * secondOperand);
            default -> null;
        };
    }

    private static ExpressionModel prepareExpression() {
        int firstNumber = GamesHelper.getRandomNumber();
        int secondNumber = GamesHelper.getRandomNumber();

        int firstOperandInt = Math.max(firstNumber, secondNumber);
        int secondOperandInt = Math.min(firstNumber, secondNumber);

        String operation = getRandomOperation(GamesHelper.getRandomNumberWithinRange(1, 4));

        return new ExpressionModel(firstOperandInt, secondOperandInt, operation);
    }

    private static String getRandomOperation(int key) {
        Map<Integer, String> operations = new HashMap<>();
        operations.put(1, "+");
        operations.put(2, "-");
        operations.put(3, "*");

        return operations.get(key);
    }
}
