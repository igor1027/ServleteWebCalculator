package by.tms.web.servlet.servlet;

import by.tms.entity.User;
import by.tms.service.CalcServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(value = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalcServiceImp calc = new CalcServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/pages/calcul.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String operation = req.getParameter("operation");
        String num2 = req.getParameter("num2");


        String result = String.valueOf(getValue(num1, num2, operation));
        User user = (User) req.getSession().getAttribute("user");
        addCalculatedResultInMemory(num1, operation, num2, result, user.getId());
        LinkedList<String> listOperation = getOperation(user.getId());
        req.setAttribute("listOperation", listOperation);
        getServletContext().getRequestDispatcher("/pages/calcul.jsp").forward(req,resp);
//        resp.sendRedirect("/calc");
        //        resp.getWriter().println(result);

    }

    private  void addCalculatedResultInMemory(String num1, String operation, String num2, String result, int id){
        calc.saveResultInMemory(num1, operation, num2, result, id);
    }

    private LinkedList<String> getOperation (int id){
        return calc.showOperation(id);
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


