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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");


//        String result =operation + " = " + getValue(num1, num2, operation);
//        User user = (User) req.getSession().getAttribute("user");
//        addResultInMemory(user.getId(), result);
//        resp.getWriter().println(result);
    }

    private double getValue(String num1, String num2, String operation) {
        CalcServiceImp calcs = new CalcServiceImp();

        switch (operation){
            case "sum" :{
                return calcs.sum(num1, num2);
            }
            case "sub" : {
                return calcs.sub(num1, num2);
            }
            case "mul" : {
                return calcs.mul(num1, num2);
            }
            case "div" : {
                return calcs.div(num1, num2);
            }
        }
        return 0;
    }
}


