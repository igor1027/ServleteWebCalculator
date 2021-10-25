package by.tms.servlet;

import by.tms.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    RegistrationService registrationService = new RegistrationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       String username = req.getParameter("username");
       String password = req.getParameter("password");

       if (checkNewUser(username)){
          createNewUser(name,username,password);
       }else {
           resp.getWriter().println("Error while creating user (Username is already taken)");
       }
    }

    public void createNewUser(String name,String username, String password){
        RegistrationService.createUser(name,username,password);
    }

    public boolean checkNewUser(String username){
        return registrationService.checkUsername(username);
    }
}
