package ui.tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel {
    private Image image;
    private static final String WELCOME_IMG = "./data/LightWeightBaby.jpg";

    public WelcomePanel() {
        try {
            image = ImageIO.read(new File(WELCOME_IMG));
        } catch (IOException ex) {
            image = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}
