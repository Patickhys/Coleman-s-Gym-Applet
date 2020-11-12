package ui.panels;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

    private static final String WELCOME_IMG = "./data/LightWeightBaby.jpg";
    private JPanel welcomePanel;

    // EFFECTS: make a new WelcomePanel that displays Ronnie Coleman
    public WelcomePanel() {
        welcomePanel = new JPanel();
        ImageIcon lightWeightImg = new ImageIcon(WELCOME_IMG);
        JLabel lightWeightLabel = new JLabel("", lightWeightImg, JLabel.CENTER);
        welcomePanel.add(lightWeightLabel);
        welcomePanel.setLayout(new FlowLayout());
        welcomePanel.setPreferredSize(new Dimension(400, 300));
        add(welcomePanel, BorderLayout.WEST);
    }
}
