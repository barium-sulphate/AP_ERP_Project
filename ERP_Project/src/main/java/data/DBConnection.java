package data;

import java.sql.*;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("auth.properties")) {
            Properties props = new Properties();
            props.load(input);

            url = props.getProperty("auth.db.url");
            user = props.getProperty("auth.db.user");
            password = props.getProperty("auth.db.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

