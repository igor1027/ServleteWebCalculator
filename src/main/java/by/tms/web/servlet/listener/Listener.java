package by.tms.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }
}
