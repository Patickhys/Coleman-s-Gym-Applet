// Represents a panel that prompts the user to make a new User

package ui.panels;

import ui.FitnessAppGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {
    private JPanel userPanel;
    private JTextField answer1;
    private JTextField answer2;
    private JButton enterButton;
    private FitnessAppGUI fitnessAppGUI;
    private final Font font = new Font("TimesRoman", Font.PLAIN, 22);


    // MODIFIES: this
    // EFFECTS: make a new userPanel
    public UserPanel(FitnessAppGUI fitnessAppGUI) {
        userPanel = new JPanel();
        this.fitnessAppGUI = fitnessAppGUI;
    }

    // MODIFIES: this
    // EFFECTS: return a user panel
    public JPanel makeUserPanel() {
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setPreferredSize(new Dimension(200, 100));
        String welcomeText = "Welcome to COLEMAN's \n Please enter your name and height in cm!";
        JLabel welcomeLabel = new JLabel(welcomeText);
        welcomeLabel.setFont(font);
        answer1 = new JTextField("Enter your name", 10);
        answer1.setFont(font);
        answer2 = new JTextField("Enter your Height in cm", 10);
        answer2.setFont(font);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonClickerHandler());
        userPanel.add(welcomeLabel);
        userPanel.add(answer1);
        userPanel.add(answer2);
        userPanel.add(enterButton);
        return userPanel;
    }


    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {

        @Override
        // if the button is pressed, make input text the username
        public void actionPerformed(ActionEvent e) {
            try {
                fitnessAppGUI.setUser(answer1.getText(), Integer.parseInt(answer2.getText()));
                userPanel.setVisible(false);
            } catch (NumberFormatException exception) {
                fitnessAppGUI.makeUserPanel();
            }
        }
    }
}
