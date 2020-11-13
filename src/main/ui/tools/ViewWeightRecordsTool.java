package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewWeightRecordsTool extends Tool {
    public ViewWeightRecordsTool(FitnessAppGUI fitnessApp, JComponent parent) {
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
        button.addActionListener(new ViewWeightLogClickHandler());
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "View weight record";
    }


    public class ViewWeightLogClickHandler implements ActionListener {

        // EFFECTS:
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.viewPastMeasurements();
        }
    }
}
