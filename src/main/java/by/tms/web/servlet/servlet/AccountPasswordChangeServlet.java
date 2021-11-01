package by.tms.web.servlet.servlet;

import by.tms.entity.User;
import by.tms.service.ChangeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/change_password", name = "AccountPasswordChangeServlet")
public class AccountPasswordChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/password_change.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newPassword = req.getParameter("password");

        User user = (User) req.getSession().getAttribute("user");

        if(checkPasswordForNull(newPassword)){
            chanrePassword(user.getId(), newPassword);
            resp.getWriter().println("Password changed successfully");
            resp.sendRedirect("/");
        }else {
            resp.getWriter().println("New password not entered");
            resp.sendRedirect("/change_password");
        }
    }

    private void chanrePassword(int id, String newPassword){
        ChangeService changeService = new ChangeService();
        changeService.passwordChange(id, newPassword);
    }

    private boolean checkPasswordForNull(String password){
        return password != null && password.isEmpty();
    }

}
