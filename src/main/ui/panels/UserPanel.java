package ui.panels;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {
    private JPanel userPanel;
    private JTextArea textArea;
    private JButton enterButton;


    // MODIFIES: this
    // EFFECTS: make a new userPanel
    public UserPanel() {
        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setPreferredSize(new Dimension(200, 100));
        String welcomeText = "Welcome to COLEMAN's \n Please enter your name!";
        textArea = new JTextArea(welcomeText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        JTextField textField = new JTextField("Enter your name", 10);
        textField.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonClickerHandler());
        userPanel.add(textArea);
        userPanel.add(textField);
        userPanel.add(enterButton);
    }
/*
    // MODIFIES: this
    // EFFECTS: return a user panel
    public JPanel makeUserPanel() {
        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setPreferredSize(new Dimension(200, 100));
        String welcomeText = "Welcome to COLEMAN's \n Please enter your name!";
        textArea = new JTextArea(welcomeText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        JTextField textField = new JTextField("Enter your name", 10);
        textField.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonClickerHandler());
        userPanel.add(textArea);
        userPanel.add(textField);
        userPanel.add(enterButton);
        return userPanel;
    }*/

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, make input text the username
        public void actionPerformed(ActionEvent e) {
            FitnessAppGUI.submitUserName(textArea.getText());
            userPanel.setVisible(false);
        }
    }
}
