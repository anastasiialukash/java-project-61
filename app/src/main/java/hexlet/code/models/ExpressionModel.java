package hexlet.code.models;

public final class ExpressionModel {
    private int firstOperand;
    private int secondOperand;
    private String operation;

    public ExpressionModel(int firstOperand, int secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
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
