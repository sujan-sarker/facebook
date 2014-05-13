package util;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.sql.DriverManager.*;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class DbConnectionManager {

    private static String userName;
    private static String password;
    private static String dbms;
    private static String serverName;
    private static String portNumber;
    private static Properties prop;


    public static Connection getConnection() {
        try {
            prop = ProFileManager.loadProperties("propfile/db.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        userName = prop.getProperty("userName");
        password = prop.getProperty("password");
        dbms = prop.getProperty("dbms");
        serverName = prop.getProperty("serverName");
        portNumber = prop.getProperty("portNumber");
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        try {
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" +
                            serverName +
                            ":" + portNumber + "/",
                    connectionProps);
            //System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }


}
