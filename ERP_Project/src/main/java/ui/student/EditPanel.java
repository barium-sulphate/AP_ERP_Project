package ui.student;

import service.SectionService;
import service.EnrollmentService;
import domain.Section;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class EditPanel extends JPanel {

    public EditPanel(MainFrame frame, int studentId) {

        setLayout(new BorderLayout());

        SectionService sectionService = new SectionService();
        EnrollmentService enrollmentService = new EnrollmentService();

        List<Section> allSections = sectionService.getAllSections();
        List<Integer> current = enrollmentService.getAllForStudent(studentId);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 1));

        java.util.List<JCheckBox> boxes = new ArrayList<>();

        for (Section s : allSections) {
            JCheckBox box = new JCheckBox(
                    "Section " + s.getSectionId() + "   " +
                            s.getDay() + " " + s.getStart() + "-" + s.getEnd() +
                            "   Room " + s.getRoom()
            );
            box.setSelected(current.contains(s.getSectionId()));
            box.putClientProperty("section_id", s.getSectionId());

            listPanel.add(box);
            boxes.add(box);
        }

        // Scrollable
        JScrollPane scroll = new JScrollPane(listPanel);
        add(scroll, BorderLayout.CENTER);

        // Save button (top right)
        JButton save = new JButton("Save");
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.add(save);
        add(top, BorderLayout.NORTH);

        JButton back = new JButton("Back");
        back.addActionListener(e -> frame.showScreen("student"));
        add(back, BorderLayout.SOUTH);
        // Save logic
        save.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to save your selections?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) return;

            List<Integer> selected = new ArrayList<>();

            for (JCheckBox box : boxes) {
                if (box.isSelected()) {
                    selected.add((Integer) box.getClientProperty("section_id"));
                }
            }

            enrollmentService.saveSelections(studentId, selected);

            JOptionPane.showMessageDialog(this, "Saved!");
        });
    }
}
