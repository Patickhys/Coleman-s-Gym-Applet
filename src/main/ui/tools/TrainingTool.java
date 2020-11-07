package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TrainingTool extends Tool {

    public TrainingTool(FitnessAppGUI fitnessApp, JComponent parent) {
        super(fitnessApp, parent);
    }

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new TrainingTool.TrainingToolClickHandler());
    }

    @Override
    protected void addToParent(JComponent parent) {

    }

    public class TrainingToolClickHandler implements ActionListener {

    }
}
