package ui;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatLaf;

public class Main {
    public static void main(String[] args) {

        // Increase global font BEFORE creating MainFrame
        UIManager.put("defaultFont", new Font("SansSerif", Font.PLAIN, 25));

        // If using FlatLaf - MUST be after UIManager.put()
        FlatLightLaf.setup();

        // Create UI on EDT
        SwingUtilities.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
        });
    }
}
