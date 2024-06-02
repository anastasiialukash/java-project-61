package hexlet.code.models;

public class ExpressionModel {
    public int firstOperand;
    public int secondOperand;
    public String operation;

    public ExpressionModel(int firstOperand, int secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    @Override
    public String toString(){
        return this.firstOperand + " " + this.operation + " " + this.secondOperand;
    }
}
