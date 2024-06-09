package hexlet.code.models;

public final class ExpressionModel {
    private final int firstOperand;
    private final int secondOperand;
    private final String operation;

    public ExpressionModel(int operandOne, int operandTwo, String operationSign) {
        this.firstOperand = operandOne;
        this.secondOperand = operandTwo;
        this.operation = operationSign;
    }

    @Override
    public String toString() {
        return this.firstOperand + " " + this.operation + " " + this.secondOperand;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public String getOperation() {
        return operation;
    }
}
