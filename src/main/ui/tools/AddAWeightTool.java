// A tool that prompts the user to add a weight

package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAWeightTool extends Tool {
    public AddAWeightTool(FitnessAppGUI fitnessApp, JComponent parent) {
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
        button.addActionListener(new WeightToolClickHandler());
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "Add a weight";
    }


    // Helper class that handles a click
    private class WeightToolClickHandler implements ActionListener {

        // EFFECTS:
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.makeNewWeight();
        }
    }
}
