package by.tms.entity;

public class CalculatorHistory {
    String num1;
    String operation;
    String num2;
    String result;

    public CalculatorHistory(String num1, String operation, String num2, String result) {
        this.num1 = num1;
        this.operation = operation;
        this.num2 = num2;
        this.result = result;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
