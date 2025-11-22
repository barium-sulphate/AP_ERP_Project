package data;

import domain.Course;
import java.sql.*;
import java.util.*;

public class CourseRepository {

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();

        String sql = "SELECT course_id, code, title, credits FROM courses";

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("code"),
                        rs.getString("title"),
                        rs.getInt("credits")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
