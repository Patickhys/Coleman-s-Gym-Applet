// Represents a panel that shows all the meals in the current Foodlog

package ui.panels;

import model.logs.FoodLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PastMealsPanel extends JPanel {
    private JPanel pastMealsPanel;
    private JTextArea textArea;
    private JButton closeButton;


    // MODIFIES: this
    // EFFECTS: make a new pastMealPanel
    public PastMealsPanel() {
        pastMealsPanel = new JPanel();
    }

    // REQUIRES: a valid food log
    // MODIFIES: this
    // EFFECTS: return a pastMeal panel
    public JPanel makeMealLogPanel(FoodLog foodLog) {
        pastMealsPanel.setLayout(new FlowLayout());
        pastMealsPanel.setPreferredSize(new Dimension(100, 100));
        String mealLogText = foodLog.viewPastMeals();
        textArea = new JTextArea(mealLogText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        closeButton = new JButton("Close");
        closeButton.addActionListener(new EnterButtonClickerHandler());
        pastMealsPanel.add(textArea);
        pastMealsPanel.add(closeButton);
        return pastMealsPanel;
    }

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, set the panel to invisible
        public void actionPerformed(ActionEvent e) {
            pastMealsPanel.setVisible(false);
            pastMealsPanel = new JPanel();
        }
    }
}
