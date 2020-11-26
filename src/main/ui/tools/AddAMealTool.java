// A tool that prompts the user to add a meal

package ui.tools;

import ui.FitnessAppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAMealTool extends Tool {
    public AddAMealTool(FitnessAppGUI fitnessApp, JComponent parent) {
        super(fitnessApp, parent);
    }


    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add a meal");
        addToParent(parent);
    }


    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
    @Override
    protected void addListener() {
        button.addActionListener(new FoodToolClickHandler());
    }



    // Helper class that handles a click
    private class FoodToolClickHandler implements ActionListener {

        // EFFECTS: sets active tool to the Food tool
        //          called by the framework when the tool is clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            fitnessApp.makeNewMeal();
        }
    }


}
