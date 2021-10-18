package by.tms;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operation = req.getParameter("operation");

        if (num1 != null && num2 != null && operation != null) {
            String value = getValue(num1, num2, operation);

            if (value != null) {
                resp.getWriter().println("Operation = " + value);
            }  else {
                resp.getWriter().println("Invalid data entered");
            }

        } else {
            resp.getWriter().println("Invalid data entered");
        }
    }

    private String getValue(String num1, String num2, String operation) {
        CalcServiceImp calcs = new CalcServiceImp();

        if (operation.equals("sum")) {
            return calcs.sum(num1, num2);
        }
        if (operation.equals("sub")) {
            return calcs.sub(num1, num2);

        }
        if (operation.equals("mul")) {
            return calcs.mul(num1, num2);
        }
        if (operation.equals("div")) {
            return calcs.div(num1, num2);
        }
        return null;
    }
}


