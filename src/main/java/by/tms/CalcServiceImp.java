package by.tms;

public class CalcServiceImp implements CalcService{

    @Override
    public String sum(String num1, String num2) {
        if (checkValue(num1,num2)){
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double sum = number1 + number2;
            return String.valueOf(sum);
        }else {
            return null;
        }
    }

    @Override
    public String sub(String num1, String num2) {
        if (checkValue(num1,num2)){
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double sub = number1 - number2;
            return String.valueOf(sub);
        }else {
            return null;
        }
    }

    @Override
    public String mul(String num1, String num2) {
        if (checkValue(num1,num2)){
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double mul = number1 * number2;
            return String.valueOf(mul);
        }else {
            return null;
        }
    }

    @Override
    public String div(String num1, String num2) {
        if (checkValue(num1,num2)){
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double div = number1 / number2;
            return String.valueOf(div);
        }else {
            return null;
        }
    }

    private boolean checkValue(String num1, String num2) {
        boolean checkNum1 = num1.matches("[\\d]+");
        boolean checkNum2 = num2.matches("[\\d]+");
        return checkNum1 && checkNum2;
    }
}
