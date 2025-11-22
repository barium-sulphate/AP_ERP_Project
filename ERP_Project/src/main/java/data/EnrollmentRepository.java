package data;

import java.sql.*;
import java.util.*;

public class EnrollmentRepository {

    public boolean isAlreadyEnrolled(int student, int section) {
        String sql = """
            SELECT 1 FROM enrollments
            WHERE student_id=? AND section_id=? AND status='ENROLLED'
        """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, student);
            ps.setInt(2, section);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
    public void enroll(int studentId, int sectionId) {
        String sql = """
        INSERT INTO enrollments (student_id, section_id, status)
        VALUES (?, ?, 'ENROLLED')
        ON DUPLICATE KEY UPDATE status='ENROLLED';
    """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, sectionId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drop(int studentId, int sectionId) {
        String sql = """
        UPDATE enrollments SET status='DROPPED'
        WHERE student_id=? AND section_id=?
    """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, sectionId);
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Integer> getAllForStudent(int studentId) {
        List<Integer> list = new ArrayList<>();

        String sql = """
        SELECT section_id
        FROM enrollments
        WHERE student_id=? AND status='ENROLLED'
    """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("section_id"));
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }

}
