/*
package ui;

import ui.student.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private int currentStudentId = -1;   // store logged-in student
    CardLayout cl = new CardLayout();
    JPanel container = new JPanel(cl);


    public void setCurrentStudent(int id) {
        this.currentStudentId = id;
    }

    public MainFrame() {
        setTitle("University ERP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(new LoginPanel(this), "login");
        container.add(new StudentPanel(this), "student");
        container.add(new CourseCatalogPanel(this), "catalog");
        container.add(new EditPanel(this, currentStudentId), "edit");
        container.add(new TimetablePanel(this, currentStudentId), "timetable");

        add(container, BorderLayout.CENTER);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void showScreen(String name) {
        cl.show(container, name);
    }
}
*/
package ui;

import ui.student.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private int currentUserId = -1;
    private String currentRole = null;

    private final CardLayout cl = new CardLayout();
    private final JPanel container = new JPanel(cl);

    public MainFrame() {
        setTitle("University ERP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(new LoginPanel(this), "login");
        container.add(new StudentPanel(this), "student");
        container.add(new CourseCatalogPanel(this), "catalog");

        // DO NOT add edit/timetable until login happens
        add(container, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void setLoggedInUser(int userId, String role) {
        this.currentUserId = userId;
        this.currentRole = role;

        // add role-specific panels NOW
        if (role.equals("STUDENT")) {
            container.add(new EditPanel(this, userId), "edit");
            container.add(new TimetablePanel(this, userId), "timetable");
        }

    }

    public void showScreen(String name) {
        cl.show(container, name);
    }
}

