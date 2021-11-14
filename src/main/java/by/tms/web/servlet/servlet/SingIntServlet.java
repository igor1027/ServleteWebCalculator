package by.tms.web.servlet.servlet;

import by.tms.entity.User;
import by.tms.service.AuthorizacionServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/authorization", name = "SingIntServlet")
public class SingIntServlet extends HttpServlet {

    private final AuthorizacionServiceImp sing = new AuthorizacionServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkValueForNullString(username,password)){
            if(accontDataVerification(username, password)){
                User user = getUser(username);
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/");
            }else {
                req.setAttribute("message", "Wrong password");
            }
        }else {
            req.setAttribute("message", "User not found!");
            getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req,resp);
        }
    }

    private boolean accontDataVerification(String username, String password){
        if(sing.checkUsername(username)){
           return sing.chechkPassword(username,password);
        }
        return false;
    }

    private User getUser (String username){
        return sing.gettingUser(username);
    }

    private boolean checkValueForNullString(String username, String password) {
        if (username != null && password != null) {
            return!username.isEmpty() && !password.isEmpty();
        }
        return false;
    }
}
