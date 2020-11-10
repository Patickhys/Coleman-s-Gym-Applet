package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPastMealsTool extends Tool {
    public ViewPastMealsTool(FitnessAppGUI fitnessApp, JComponent parent) {
        super(fitnessApp, parent);
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new MealLogClickHandler());
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "View past meals";
    }


    public class MealLogClickHandler implements ActionListener {

        // EFFECTS:
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
