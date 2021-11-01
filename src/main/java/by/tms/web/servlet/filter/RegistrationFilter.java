package by.tms.web.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(servletNames = {""})
public class RegistrationFilter extends HttpFilter {



    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        String name = req.getParameter("name");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        if (checkValueForNull(name, username, password)){
//            chain.doFilter(req,res);
//        }else {
//            res.getWriter().println("Incorrect data entered");
//        }
    }
//
//    private boolean checkValueForNull(String name, String username, String password) {
//        if (name != null && username != null && password != null) {
//            return !name.isEmpty() && !username.isEmpty() && !password.isEmpty();
//        }
//        return false;
//    }
}
