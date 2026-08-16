/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package listeners;

import data.DatabaseConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Web application lifecycle listener.
 *
 * @author Compu City
 */
public class DatabaseListener implements ServletContextListener {

    ServletContext context = null;
    Connection connection = null;

    @Override

    public void contextInitialized(ServletContextEvent sce) {
        connection = DatabaseConnection.connect();
        context = sce.getServletContext();
        context.setAttribute("db connection", connection);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
