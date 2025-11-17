package auth;

import data.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;
import java.io.*;

public class AuthService {
    public static String login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT role, password_hash FROM users_auth WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                String hash = rs.getString("password_hash");
                if(PasswordHasher.checkPassword(password,hash)){
                    return role;
                }
                /*
                if (BCrypt.checkpw(password, hash)) {
                    return role; // success
                }
                 */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // failure
    }
}
