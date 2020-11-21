package ui.panels;

import model.entries.Weight;
import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAWeightPanel extends JPanel {
    private final String question1 = "How much do you weight in kg";
    private final JLabel q1 = new JLabel(question1);
    private JPanel currentPanel;
    private JButton enterButton;
    private JTextField answerField1 = new JTextField("Enter your weight in kg", 10);
    private FitnessAppGUI fitnessAppGUI;

    public AddAWeightPanel(FitnessAppGUI fitnessAppGUI) {
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
        enterButton.addActionListener(new EnterButtonClickerHandler());
        currentPanel.add(q1);
        currentPanel.add(answerField1);
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
                Weight weight = new Weight(Double.parseDouble(answerField1.getText()),fitnessAppGUI.getUserHeight());
                fitnessAppGUI.weightLog.addEntry(weight);
                currentPanel.setVisible(false);
                currentPanel = new JPanel();
            } catch (NumberFormatException exception) {
                fitnessAppGUI.makeNewWeight();
            }
        }
    }
}
