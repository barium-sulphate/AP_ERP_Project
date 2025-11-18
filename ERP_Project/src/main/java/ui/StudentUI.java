package ui;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StudentUI extends javax.swing.JFrame {
    public StudentUI() {
        setTitle("Student Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));

        JButton btnCatalog = new JButton("Course Catalog");
        JButton btnRegister = new JButton("Register for a Section");
        JButton btnDrop = new JButton("Drop a Section");
        JButton btnTimetable = new JButton("My Timetable");
        JButton btnGrades = new JButton("My Grades");
        JButton btnTranscript = new JButton("Download Transcript");
        JButton btnLogout = new JButton("Logout");

        panel.add(btnCatalog);
        panel.add(btnRegister);
        panel.add(btnDrop);
        panel.add(btnTimetable);
        panel.add(btnGrades);
        panel.add(btnTranscript);
        panel.add(btnLogout);

        add(panel);

//       btnCatalog.addActionListener(e -> new CourseCatalogScreen().setVisible(true));

//       btnRegister.addActionListener(e -> new RegisterScreen().setVisible(true));

//       btnDrop.addActionListener(e -> new DropSectionScreen().setVisible(true));

//       btnTimetable.addActionListener(e -> new TimetableScreen().setVisible(true));

//       btnGrades.addActionListener(e -> new GradesScreen().setVisible(true));

    }
}
