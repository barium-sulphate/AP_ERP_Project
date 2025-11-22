package data;

import java.sql.*;

public class StudentRepository {
    public Integer getStudentId(int userId) {
        try (Connection conn = DBConnection.getERPConnection()) {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT user_id FROM students WHERE user_id=?"
            );
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    public Integer getStudentIdForUser(String username) {
        try (Connection conn = DBConnection.getAuthConnection()) {

            // Step 1: find user_id from auth_db
            PreparedStatement st = conn.prepareStatement(
                    "SELECT user_id FROM users_auth WHERE username = ?"
            );
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
