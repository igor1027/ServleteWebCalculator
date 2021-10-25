package by.tms.servlet;

import by.tms.entity.User;
import by.tms.service.AuthorizacionServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/singint", name = "SingIntServlet")
public class SingIntServlet extends HttpServlet {

    private final AuthorizacionServiceImp sing = new AuthorizacionServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(accontDataVerification(username, password)){
            User user = getUser(username);
            req.getSession().setAttribute("user", user);
            resp.getWriter().println("You are logged into your account");
        }else {
            resp.getWriter().println("Username or password entered incorrectly");
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
}
