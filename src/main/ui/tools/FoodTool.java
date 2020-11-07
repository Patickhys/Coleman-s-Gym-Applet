package ui.tools;
import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodTool extends Tool {
    public FoodTool(FitnessAppGUI fitnessApp, JComponent parent) {
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
        button.addActionListener(new FoodToolClickHandler());
    }



    private class FoodToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the Food tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.setActiveTool(FoodTool.this);
        }
    }


}
