package data;

import domain.Section;
import java.sql.*;
        import java.util.*;

public class SectionRepository {

    public List<Section> getSectionsForCourse(int courseId) {
        List<Section> list = new ArrayList<>();

        String sql = """
            SELECT section_id, course_id, instructor_id,
                   day, start_time, end_time, room,
                   capacity, semester, year
            FROM sections
            WHERE course_id = ?
        """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Section(
                        rs.getInt("section_id"),
                        rs.getInt("course_id"),
                        rs.getInt("instructor_id"),
                        rs.getString("day"),
                        rs.getTime("start_time").toLocalTime(),
                        rs.getTime("end_time").toLocalTime(),
                        rs.getString("room"),
                        rs.getInt("capacity"),
                        rs.getString("semester"),
                        rs.getInt("year")
                ));
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }
    public List<Section> getAllSections() {
        List<Section> list = new ArrayList<>();

        String sql = """
        SELECT section_id, course_id, instructor_id, day,
               start_time, end_time, room, capacity, semester, year
        FROM sections
    """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Section(
                        rs.getInt("section_id"),
                        rs.getInt("course_id"),
                        rs.getInt("instructor_id"),
                        rs.getString("day"),
                        rs.getTime("start_time").toLocalTime(),
                        rs.getTime("end_time").toLocalTime(),
                        rs.getString("room"),
                        rs.getInt("capacity"),
                        rs.getString("semester"),
                        rs.getInt("year")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }
    public Section getSectionById(int sectionId) {
        String sql = """
        SELECT section_id, course_id, instructor_id, day,
               start_time, end_time, room, capacity, semester, year
        FROM sections
        WHERE section_id=?
    """;

        try (Connection conn = DBConnection.getERPConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, sectionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Section(
                        rs.getInt("section_id"),
                        rs.getInt("course_id"),
                        rs.getInt("instructor_id"),
                        rs.getString("day"),
                        rs.getTime("start_time").toLocalTime(),
                        rs.getTime("end_time").toLocalTime(),
                        rs.getString("room"),
                        rs.getInt("capacity"),
                        rs.getString("semester"),
                        rs.getInt("year")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }

        return null;
    }

}
