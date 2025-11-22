package ui.student;

import ui.MainFrame;
import data.CourseRepository;
import domain.Course;
import service.CourseService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CourseCatalogPanel extends JPanel {

    public CourseCatalogPanel(MainFrame frame) {
        setLayout(new BorderLayout());

        CourseService service = new CourseService();
        List<Course> list = service.getCatalog();

        String[] cols = {"Code", "Title", "Credits"};
        Object[][] data = new Object[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            Course c = list.get(i);
            data[i][0] = c.getCode();
            data[i][1] = c.getTitle();
            data[i][2] = c.getCredits();
        }

        JTable table = new JTable(data, cols);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.addActionListener(e -> frame.showScreen("student"));
        add(back, BorderLayout.SOUTH);
    }
}