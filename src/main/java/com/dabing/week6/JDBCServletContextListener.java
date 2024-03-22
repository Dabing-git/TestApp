package com.dabing.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    Connection con = null;

    //like main() in java - when run tomcat call this method
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //get driver,url,username, password --- from web.xml
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");//<param-name>driver</param-name>
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            //jdbc - get connection
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()--> " + con);// ok(java code)- ok(use config-in web.xml) -- ok -use( @webservlet )--> (use context) ok-- use mysql ( no need to change in java code )
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //set con in context - for all servlet /jsp
        context.setAttribute("con", con);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
