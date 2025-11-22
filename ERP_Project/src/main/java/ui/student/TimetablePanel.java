package ui.student;

import domain.Section;
import service.EnrollmentService;
import service.SectionService;
import ui.MainFrame;

import javax.swing.*;
        import java.awt.*;
        import java.util.List;

public class TimetablePanel extends JPanel {

    public TimetablePanel(MainFrame frame, int studentId) {

        setLayout(new BorderLayout());

        EnrollmentService enrollmentService = new EnrollmentService();
        SectionService sectionService = new SectionService();

        List<Integer> enrolledSectionIds = enrollmentService.getAllForStudent(studentId);
        List<Section> allSections = sectionService.getAllSections();

        // Filter only enrolled sections
        java.util.List<Section> timetable = new java.util.ArrayList<>();
        for (Section s : allSections) {
            if (enrolledSectionIds.contains(s.getSectionId())) {
                timetable.add(s);
            }
        }

        // Table columns
        String[] columns = {"Day", "Start", "End", "Course", "Section", "Room"};

        // Prepare table data
        String[][] data = new String[timetable.size()][6];
        int i = 0;

        for (Section s : timetable) {
            data[i][0] = s.getDay();
            data[i][1] = s.getStart().toString();
            data[i][2] = s.getEnd().toString();
            data[i][3] = String.valueOf(s.getCourseId());
            data[i][4] = String.valueOf(s.getSectionId());
            data[i][5] = s.getRoom();
            i++;
        }

        JTable table = new JTable(data, columns);
        table.setRowHeight(28);
        table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Back button
        JButton back = new JButton("Back");
        back.addActionListener(e -> frame.showScreen("student"));
        add(back, BorderLayout.SOUTH);
        /*
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.add(back);

        add(bottom, BorderLayout.SOUTH);
         */
        System.out.println("Student ID = " + studentId);
    }
}
