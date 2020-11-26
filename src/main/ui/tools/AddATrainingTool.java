// A tool that prompts the user to add a training

package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddATrainingTool extends Tool {

    public AddATrainingTool(FitnessAppGUI fitnessApp, JComponent parent) {
        super(fitnessApp, parent);
    }



    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add a training");
        button = customizeButton(button);
    }

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new TrainingToolClickHandler());
    }

    // Helper class that handles a click
    private class TrainingToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the Training tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.makeNewTraining();
        }
    }
}
