package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.CalcServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalcServiceImp calc = new CalcServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");


        String result =operation + " = " + getValue(num1, num2, operation);
        User user = (User) req.getSession().getAttribute("user");
        addCalculatedResultInMemory(user.getId(), result);
//        resp.getWriter().println(result);
    }

    private  void addCalculatedResultInMemory(int userId, String result){
        calc.addResultInMemory(userId, result);
    }

    private double getValue(String num1, String num2, String operation) {

        switch (operation){
            case "sum" :{
                return calc.sum(num1, num2);
            }
            case "sub" : {
                return calc.sub(num1, num2);
            }
            case "mul" : {
                return calc.mul(num1, num2);
            }
            case "div" : {
                return calc.div(num1, num2);
            }
        }
        return 0;
    }
}


