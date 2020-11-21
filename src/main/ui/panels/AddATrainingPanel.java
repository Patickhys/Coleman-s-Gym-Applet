package ui.panels;

import model.entries.Training;
import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddATrainingPanel extends JPanel {
    private final String question1 = "What exercise did you do?";
    private final String question2 = "How many calories did you burn?";
    private final String question3 = "How long in minutes did you exercise?";
    private final JLabel q1 = new JLabel(question1);
    private final JLabel q2 = new JLabel(question2);
    private final JLabel q3 = new JLabel(question3);
    private JPanel currentPanel;
    private JButton enterButton;
    private JTextField answerField1 = new JTextField("Enter your exercise name", 10);
    private JTextField answerField2 = new JTextField("Enter the calories you burned", 10);
    private JTextField answerField3 = new JTextField("Enter the duration of your exercise in min", 10);
    private FitnessAppGUI fitnessAppGUI;

    public AddATrainingPanel(FitnessAppGUI fitnessAppGUI) {
        currentPanel = new JPanel();
        enterButton = new JButton("Enter");
        this.fitnessAppGUI = fitnessAppGUI;
    }


    // MODIFIES:this
    // EFFECTS: Helper method that makes a panel for the given question
    public JPanel questionPanel() {
        currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
        currentPanel.setPreferredSize(new Dimension(200, 100));
        answerField1.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        answerField2.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        answerField3.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton.addActionListener(new EnterButtonClickerHandler());
        currentPanel.add(q1);
        currentPanel.add(answerField1);
        currentPanel.add(q2);
        currentPanel.add(answerField2);
        currentPanel.add(q3);
        currentPanel.add(answerField3);
        currentPanel.add(enterButton);
        return currentPanel;
    }


    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // MODIFIES: fitnessAppGui
        // EFFECTS: if the button is pressed, make a new training and add it to trainingLog
        public void actionPerformed(ActionEvent e) {
            try {
                Training newTraining = new Training(answerField1.getText(),
                        Integer.parseInt(answerField2.getText()),
                        Integer.parseInt(answerField3.getText()));
                fitnessAppGUI.trainingLog.addEntry(newTraining);
                currentPanel.setVisible(false);
                currentPanel = new JPanel();
            } catch (NumberFormatException exception) {
                fitnessAppGUI.makeNewTraining();
            }
        }
    }

}
