// Code in this class refers to SimpleDrawingPlayer by CPSC210 Course Team

package ui.tools;


import ui.FitnessAppConsole;

import javax.swing.*;

public abstract class Tool {
    protected JButton button;
    protected FitnessAppConsole fitnessApp;
    private boolean active;

    public Tool(FitnessAppConsole fitnessApp, JComponent parent) {
        this.fitnessApp = fitnessApp;
        createButton(parent);
        addToParent(parent);
        active = false;
       /* addListener();*/
    }

    // MODIFIES: this
    // EFFECTS:  customizes the button used for this tool
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        return button;
    }

    // getters
    public JButton getButton() {
        return button;
    }

    public FitnessAppConsole getFitnessApp() {
        return fitnessApp;
    }

    public boolean isActive() {
        return active;
    }

    // EFFECTS: creates button to activate tool
    protected void createButton(JComponent parent) {
        parent.add(button);
    }

/*
    // EFFECTS: adds a listener for this tool
    protected abstract void addListener();
*/

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    protected abstract void addToParent(JComponent parent);

    // EFFECTS: sets this Tool's active field to true
    public void activate() {
        active = true;
    }

    // EFFECTS: sets this Tool's active field to false
    public void deactivate() {
        active = false;
    }
}
