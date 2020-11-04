package ui.tools;

import ui.FitnessAppConsole;
import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodTool extends Tool {
    public FoodTool(FitnessAppConsole fitnessApp, JComponent parent) {
        super(fitnessApp, parent);
    }


    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "Food and Nutrition";
    }

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new ShapeToolClickHandler());
    }

    // EFFECTS: adds a listener for this tool
    private void addListener(){
        button.addActionListener(new FoodToolClickHandler());
    }


    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    @Override
    protected void addToParent(JComponent parent) {

    }

    private class ShapeToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the shape tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            FitnessAppGUI.setActiveTool(FoodTool.this);
        }
    }
}
