package by.tms.web.servlet.servlet;

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
//       String name = req.getParameter("name");
//       String username = req.getParameter("username");
//       String password = req.getParameter("password");
//
//       if (checkNewUser(username)){
//          createNewUser(name,username,password);
//       }else {
//           resp.getWriter().println("Error while creating user (Username is already taken)");
//       }
        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (checkValueForNull(name,username,password)){
            if (checkNewUser(username)){
                createNewUser(name,username,password);
                resp.sendRedirect("/");
            }else {
                resp.getWriter().println("Error while creating user (Username is already taken)");
            }
        }else {
            resp.getWriter().println("You have not entered values in the fields");
            resp.sendRedirect("/registration");
        }

    }

    public void createNewUser(String name, String username, String password){
        RegistrationService.createUser(name,username,password);
    }

    public boolean checkNewUser(String username){
        return registrationService.checkUsername(username);
    }

    private boolean checkValueForNull(String name, String username, String password) {
        if (name != null && username != null && password != null) {
            return !name.isEmpty() && !username.isEmpty() && !password.isEmpty();
        }
        return false;
    }
}
