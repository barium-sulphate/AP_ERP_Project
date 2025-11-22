/*
package ui;

import auth.AuthResult;
import auth.AuthService;
import javax.swing.*;

public class LoginPanel extends JPanel {

    public LoginPanel(MainFrame frame) {

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JLabel statusLabel = new JLabel("");

        add(userLabel); add(userText);
        add(passLabel); add(passText);
        add(loginButton); add(statusLabel);
        /*
        loginButton.addActionListener(e -> {
            String role = AuthService.login(
                    userText.getText(),
                    new String(passText.getPassword())
            );

            if (role != null) {
                int studentId = AuthService.getStudentId(username);
                frame.setCurrentStudent(studentId);
                frame.showScreen("student");
            } else {
                statusLabel.setText("Invalid login");
            }
        });
        loginButton.addActionListener(e -> {
            AuthResult result = AuthService.login(username.getText(), password.getText());

            if (result == null) {
                status.setText("Invalid login!");
                return;
            }

            frame.setLoggedInUser(result.userId, result.role);

            switch (result.role) {
                case "STUDENT" -> frame.showScreen("student");
                case "INSTRUCTOR" -> JOptionPane.showMessageDialog(frame, "Instructor UI not implemented");
                case "ADMIN" -> JOptionPane.showMessageDialog(frame, "Admin UI not implemented");
            }
        });

    }
}
*/

package ui;

import auth.AuthResult;
import auth.AuthService;

import javax.swing.*;

public class LoginPanel extends JPanel {

    // Make fields accessible inside the action listener
    private JTextField userText;
    private JPasswordField passText;
    private JLabel statusLabel;

    public LoginPanel(MainFrame frame) {

        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        passText = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        statusLabel = new JLabel("");

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);
        add(statusLabel);

        // ✔ FIXED ActionListener
        loginButton.addActionListener(e -> {

            String username = userText.getText();
            String password = new String(passText.getPassword());

            AuthResult result = AuthService.login(username, password);

            if (result == null) {
                statusLabel.setText("Invalid login!");
                return;
            }

            // Store user + role in MainFrame
            frame.setLoggedInUser(result.userId, result.role);

            // Navigate based on role
            switch (result.role) {
                case "STUDENT" -> frame.showScreen("student");
                case "INSTRUCTOR" -> JOptionPane.showMessageDialog(frame, "Instructor UI not implemented");
                case "ADMIN" -> JOptionPane.showMessageDialog(frame, "Admin UI not implemented");
            }
        });
    }
}
