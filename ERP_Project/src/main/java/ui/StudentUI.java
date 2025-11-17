package ui;

import javax.swing.JPanel;

public class StudentUI extends javax.swing.JFrame {
    public StudentUI() {
        setTitle("Student Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
    }
}
