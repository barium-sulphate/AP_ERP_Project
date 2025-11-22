package ui.student;

import ui.MainFrame;

import javax.swing.*;
        import java.awt.*;

public class StudentPanel extends JPanel {

    public StudentPanel(MainFrame frame) {
        setLayout(new GridLayout(7, 1, 10, 10));

        JButton btnCatalog = new JButton("Course Catalog");
        JButton btnEdit = new JButton("Edit Section");
        JButton btnTimetable = new JButton("My Timetable");
        JButton btnGrades = new JButton("My Grades");
        JButton btnTranscript = new JButton("Download Transcript");
        JButton btnLogout = new JButton("Logout");

        add(btnCatalog);
        add(btnEdit);
        add(btnTimetable);
        add(btnGrades);
        add(btnTranscript);
        add(btnLogout);
        btnCatalog.addActionListener(e -> frame.showScreen("catalog"));
        btnLogout.addActionListener(e -> frame.showScreen("login"));
        btnEdit.addActionListener(e -> frame.showScreen("edit"));
        btnTimetable.addActionListener(e -> frame.showScreen("timetable"));

    }
}
