package by.tms.servlet;

import by.tms.entity.User;
import by.tms.repository.UserRepositoryFunction;

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

        getServletContext().getRequestDispatcher("/pages/name_change.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String changePassword = req.getParameter("password");

        User user = (User) req.getSession().getAttribute("user");

        if(changePassword != null){
            UserRepositoryFunction.changePassword((int) user.getId(),changePassword);
            resp.getWriter().println("Password changed successfully");
        }
    }
}
