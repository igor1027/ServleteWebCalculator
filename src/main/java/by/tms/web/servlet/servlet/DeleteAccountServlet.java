package by.tms.web.servlet.servlet;

import by.tms.entity.User;
import by.tms.service.DeleteAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/deleted_account", name = "DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/deleted.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        deleteAccount(user.getId());
        resp.getWriter().println("Account deleted");
        req.getSession().invalidate();
    }

    private void deleteAccount(int id){
        DeleteAccountService deleteAccountService = new DeleteAccountService();
        deleteAccountService.deletedUser(id);
    }
}
