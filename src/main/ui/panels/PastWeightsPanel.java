package ui.panels;

import model.FoodLog;
import model.WeightLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PastWeightsPanel extends JPanel {
    private JPanel pastWeightsPanel;
    private JTextArea textArea;
    private JButton closeButton;


    // MODIFIES: this
    // EFFECTS: make a new pastMealPanel
    public PastWeightsPanel() {
        pastWeightsPanel = new JPanel();
    }

    // REQUIRES: a valid food log
    // MODIFIES: this
    // EFFECTS: return a pastMeal panel
    public JPanel makeWeightsLogPanel(WeightLog weightLog) {
        pastWeightsPanel.setLayout(new FlowLayout());
        pastWeightsPanel.setPreferredSize(new Dimension(100, 100));
        String mealLogText = weightLog.viewAllMeasurements();
        textArea = new JTextArea(mealLogText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        closeButton = new JButton("Close");
        closeButton.addActionListener(new EnterButtonClickerHandler());
        pastWeightsPanel.add(textArea);
        pastWeightsPanel.add(closeButton);
        return pastWeightsPanel;
    }

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, set the panel to invisible
        public void actionPerformed(ActionEvent e) {
            pastWeightsPanel.setVisible(false);
            pastWeightsPanel = new JPanel();
        }
    }
}
