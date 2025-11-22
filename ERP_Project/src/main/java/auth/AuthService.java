package auth;

import data.DBConnection;

import java.sql.*;

public class AuthService {
    public static AuthResult login(String username, String password) {
        try (Connection conn = DBConnection.getAuthConnection()) {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT user_id, role, password_hash FROM users_auth WHERE username=?"
            );
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            if (!rs.next()) return null;

            String hash = rs.getString("password_hash");
            if (!hash.equals(password)) return null;

            return new AuthResult(
                    rs.getInt("user_id"),
                    rs.getString("role")
            );

        } catch (Exception e) { e.printStackTrace(); }

        return null;
    }
    /*
    public static String login(String username, String password) {
        try (Connection conn = AuthDB.getConnection()) {
            System.out.println("DEBUG: Retrieved hash = ");
            String sql = "SELECT role, password_hash FROM users_auth WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                String hash = rs.getString("password_hash");
                if(password.equals(hash)){
                    return role;
                }
                if (BCrypt.checkpw(password, hash)) {
                    return role; // success
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // failure
    }
    */
}
