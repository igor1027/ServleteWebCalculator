package by.tms.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
