// A tool that calls PastTrainingPanel

package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPastTrainingTool extends Tool {
    public ViewPastTrainingTool(FitnessAppGUI fitnessApp, JComponent parent) {
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
        button.addActionListener(new ViewTrainingLogClickHandler());
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "View past trainings";
    }


    // Helper class that handles a click
    private class ViewTrainingLogClickHandler implements ActionListener {

        // EFFECTS: call viewPastTraining()
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.viewPastTraining();
        }
    }
}
