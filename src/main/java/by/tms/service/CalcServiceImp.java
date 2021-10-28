package by.tms.service;

import by.tms.repository.CalculatorRepository;
import by.tms.service.inf.CalcService;

public class CalcServiceImp implements CalcService {

    @Override
    public double sum(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return number1 + number2;

    }

    @Override
    public double sub(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return number1 - number2;

    }

    @Override
    public double mul(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return number1 * number2;
    }

    @Override
    public double div(String num1, String num2) {
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        return number1 / number2;
    }

    public  void addResultInMemory(int userId, String result){
      CalculatorRepository.addOperation(userId, result);
    }

}
