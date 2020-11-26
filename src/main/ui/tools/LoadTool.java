// A tool that prompts the user to load the saved file

package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadTool extends Tool {
    public LoadTool(FitnessAppGUI fitnessApp, JComponent parent) {
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
        button.addActionListener(new LoadToolClickHandler());
    }


    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "Load";
    }


    // Helper class that handles a click
    private class LoadToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the Training tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.loadFile();
        }
    }
}
