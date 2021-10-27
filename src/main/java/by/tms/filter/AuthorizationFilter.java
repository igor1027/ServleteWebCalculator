package by.tms.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(servletNames = {"SingIntServlet"})
public class AuthorizationFilter extends HttpFilter {
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        if (checkValueForNull(username,password)){
//            chain.doFilter(req,res);
//        }else {
//            res.getWriter().println("No values entered");
//        }
//    }
//
//    private boolean checkValueForNull(String username, String password) {
//        if (username != null && password != null) {
//            return !username.isEmpty() && !password.isEmpty();
//        }
//        return false;
//    }
}
