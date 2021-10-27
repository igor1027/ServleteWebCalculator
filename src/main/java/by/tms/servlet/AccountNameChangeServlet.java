package by.tms.servlet;

import by.tms.entity.User;
import by.tms.repository.UserRepositoryFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/change_username", name = "AccountNameChangeServlet")
public class AccountNameChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/name_change.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String changeName = req.getParameter("name");

//        User user = (User) req.getSession().getAttribute("user");
        User user = (User) req.getAttribute("user");

        if(checkNameForNullString(changeName)){
            UserRepositoryFunction.changeName((int) user.getId(),changeName);
            resp.getWriter().println("Name changed successfully");
            resp.getWriter().println("New name" + user.getName());
        }else {
            resp.getWriter().println("Incorrect values entered");
        }
    }

    private boolean checkNameForNullString(String changeName) {
        if (changeName != null) {
            return!changeName.isEmpty();
        }
        return false;
    }
}
