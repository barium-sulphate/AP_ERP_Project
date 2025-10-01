package ui;

import auth.AuthService;
import javax.swing.*;

public class LoginUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("University ERP - Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JLabel statusLabel = new JLabel("");

        panel.add(userLabel); panel.add(userText);
        panel.add(passLabel); panel.add(passText);
        panel.add(loginButton); panel.add(statusLabel);

        loginButton.addActionListener(e -> {
            String role = AuthService.login(userText.getText(),
                    new String(passText.getPassword()));
            if (role != null) {
                statusLabel.setText("Logged in as: " + role);
                JOptionPane.showMessageDialog(frame, "Welcome " + role);
            } else {
                statusLabel.setText("Invalid login");
            }
        });

        frame.setVisible(true);
    }
}