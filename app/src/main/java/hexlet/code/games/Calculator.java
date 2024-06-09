package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.models.ExpressionModel;
import hexlet.code.models.GameModel;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public Calculator() { }
    Cli cli = new Cli();

    public GameModel calc() {
        ExpressionModel expression = prepareExpression();
        String correctAnswer = calcResult(expression.firstOperand, expression.secondOperand, expression.operation);
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

        String operation = getRandomOperation(GamesHelper.getRandomNumberWithinRange(1, 4));

        return new ExpressionModel(firstOperandInt, secondOperandInt, operation);
    }

    private String getRandomOperation(int key) {
        Map<Integer, String> operations = new HashMap<>();
        operations.put(1, "+");
        operations.put(2, "-");
        operations.put(3, "*");

        return operations.get(key);
    }
}
