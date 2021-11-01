package by.tms.web.servlet.servlet;

import by.tms.entity.User;
import by.tms.service.ChangeService;

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
        String newName = req.getParameter("name");

        User user = (User) req.getSession().getAttribute("user");

        if(checkNameForNull(newName)){
            changeName(user.getId(), newName);
            resp.getWriter().println("Name changed successfully");
            resp.getWriter().println("New name " + user.getName());
            resp.sendRedirect("/");
        }else {
            resp.getWriter().println("Incorrect values entered");
            resp.sendRedirect("/");
        }
    }

    private boolean checkNameForNull(String password){
        return password != null && password.isEmpty();
    }

    private void changeName(int id, String newName){
        ChangeService changeService = new ChangeService();
        changeService.nameChange(id, newName);
    }
}
