/*
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String AUTH_URL = "jdbc:mysql://localhost:3306/auth_db";
    private static final String ERP_URL  = "jdbc:mysql://localhost:3306/erp_db";
    private static final String USER = "appuser";
    private static final String PASS = "password123";

    public static Connection getAuthConnection() throws SQLException {
        return DriverManager.getConnection(AUTH_URL, USER, PASS);
    }

    public static Connection getERPConnection() throws SQLException {
        return DriverManager.getConnection(ERP_URL, USER, PASS);
    }
}
*/

package data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static Properties loadProps(String filename) {
        try {
            Properties props = new Properties();
            InputStream in = DBConnection.class.getClassLoader().getResourceAsStream(filename);

            if (in == null) {
                throw new RuntimeException("Could not find: " + filename);
            }

            props.load(in);
            return props;
        } catch (Exception e) {
            throw new RuntimeException("Error loading " + filename, e);
        }
    }

    public static Connection getAuthConnection() {
        try {
            Properties p = loadProps("auth.properties");
            return DriverManager.getConnection(
                    p.getProperty("db.url"),
                    p.getProperty("db.user"),
                    p.getProperty("db.password")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getERPConnection() {
        try {
            Properties p = loadProps("erp.properties");
            return DriverManager.getConnection(
                    p.getProperty("db.url"),
                    p.getProperty("db.user"),
                    p.getProperty("db.password")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
