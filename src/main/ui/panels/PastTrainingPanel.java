package ui.panels;


import model.TrainingLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PastTrainingPanel extends JPanel {
    private JPanel pastTrainingPanel;
    private JTextArea textArea;
    private JButton closeButton;

    // MODIFIES: this
    // EFFECTS: make a new pastMealPanel
    public PastTrainingPanel() {
        pastTrainingPanel = new JPanel();
    }

    // REQUIRES: a valid training log
    // MODIFIES: this
    // EFFECTS: return a past Training panel
    public JPanel makeTrainingPanel(TrainingLog trainingLog) {
        pastTrainingPanel.setLayout(new FlowLayout());
        pastTrainingPanel.setPreferredSize(new Dimension(100, 100));
        String trainingLogText = trainingLog.viewPastTraining();
        textArea = new JTextArea(trainingLogText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        closeButton = new JButton("Close");
        closeButton.addActionListener(new EnterButtonClickerHandler());
        pastTrainingPanel.add(textArea);
        pastTrainingPanel.add(closeButton);
        return pastTrainingPanel;
    }

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, set the panel to invisible
        public void actionPerformed(ActionEvent e) {
            pastTrainingPanel.setVisible(false);
            pastTrainingPanel = new JPanel();
        }
    }
}
