package ui;

// Json related code is referred to the JsonSerialization Demo
//Represents a new FitnessApp, initials the app


import model.logs.FoodLog;
import model.logs.TrainingLog;
import model.logs.WeightLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panels.*;
import ui.tools.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FitnessAppGUI extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private static final String JSON_STORE_FOOD = "./data/savedFoodLog.json";
    private static final String JSON_STORE_TRAINING = "./data/savedTrainingLog.json";
    private static final String JSON_STORE_WEIGHT = "./data/savedWeightLog.json";

    private User user;
    public TrainingLog trainingLog;
    public FoodLog foodLog;
    public WeightLog weightLog;

    private JsonWriter jsonWriterFood;
    private JsonReader jsonReaderFood;
    private JsonWriter jsonWriterTraining;
    private JsonReader jsonReaderTraining;
    private JsonWriter jsonWriterWeight;
    private JsonReader jsonReaderWeight;
    private List<Tool> tools;

    private BoxLayout layOut;

    private JPanel activePanel;
    private JPanel welcomePanel;

    private AddAMealPanel addAMealPanel;
    private AddATrainingPanel addATrainingPanel;
    private AddAWeightPanel addAWeightPanel;
    private UserPanel userPanel;

    private PastMealsPanel pastMealsPanel;
    private PastTrainingPanel pastTrainingPanel;
    private PastWeightsPanel pastWeightsPanel;

    // EFFECTS: make a new App GUI
    public FitnessAppGUI() {
        initializeFields();
        initializeGraphics();
        initializeLogs();
    }

    // MODIFIES: this
    // EFFECTS:  initialize all fields

    private void initializeFields() {
        jsonWriterFood = new JsonWriter(JSON_STORE_FOOD);
        jsonReaderFood = new JsonReader(JSON_STORE_FOOD);
        jsonWriterTraining = new JsonWriter(JSON_STORE_TRAINING);
        jsonReaderTraining = new JsonReader(JSON_STORE_TRAINING);
        jsonWriterWeight = new JsonWriter(JSON_STORE_WEIGHT);
        jsonReaderWeight = new JsonReader(JSON_STORE_WEIGHT);
        tools = new ArrayList<>();
        user = new User();
        userPanel = new UserPanel(this);
        welcomePanel = new WelcomePanel();
        addAMealPanel = new AddAMealPanel(this);
        addATrainingPanel = new AddATrainingPanel(this);
        addAWeightPanel = new AddAWeightPanel(this);
        pastMealsPanel = new PastMealsPanel();
        pastTrainingPanel = new PastTrainingPanel();
        pastWeightsPanel = new PastWeightsPanel();
        activePanel = new JPanel();
    }

    // MODIFIES: this
    // EFFECTS:  initialize the user

    private void initializeLogs() {
        trainingLog = new TrainingLog(user.getName());
        foodLog = new FoodLog(user.getName());
        weightLog = new WeightLog(user.getName());
    }



    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this FitnessApp will operate
    private void initializeGraphics() {
        layOut = new BoxLayout(getContentPane(),1);
        setLayout(layOut);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        welcomeScreen();
        activePanel.setVisible(true);
        activePanel.setPreferredSize(new Dimension(0,0));
        createTools();
        makeUserPanel();
        add(activePanel,layOut);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: display a welcome image
    private void welcomeScreen() {
        add(welcomePanel, layOut);
    }

    // MODIFIES: this
    // EFFECTS: make user panel show up
    public void makeUserPanel() {
        activePanel = userPanel.makeUserPanel();
        refreshActivePanel();
    }

    // MODIFIES: this
    // EFFECTS: set user to the given user
    public void setUser(String name, int height) {
        user.setNameAndHeight(name,height);
        setNamesForLogs();
    }

    // EFFECTS: getter for the user height
    public double getUserHeight() {
        return user.getHeight();
    }

    // MODIFIES: this
    // EFFECTS: give each log a username
    private void setNamesForLogs() {
        foodLog.setUserName(user.getName());
        trainingLog.setUserName(user.getName());
        weightLog.setUserName(user.getName());
    }

     // MODIFIES: this
     // EFFECTS: revalidate and repaint the active panel
    private void refreshActivePanel() {
        activePanel.setVisible(true);
        add(activePanel,layOut);
        activePanel.revalidate();
        activePanel.repaint();
    }


    // MODIFIES: this
    // EFFECTS: a helper method which declares and instantiates all tools
    private void createTools() {
        JPanel toolArea = new JPanel();
        toolArea.setLayout(new GridLayout(4, 2));
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.EAST);
        addTools(toolArea);
    }

    // MODIFIES: this
    // EFFECTS: A helper method to add the tools
    private void addTools(JPanel toolArea) {
        AddAMealTool addAMealTool = new AddAMealTool(this, toolArea);
        ViewPastMealsTool mealsTool = new ViewPastMealsTool(this, toolArea);
        AddATrainingTool addATrainingTool = new AddATrainingTool(this, toolArea);
        ViewPastTrainingTool viewPastTrainingTool = new ViewPastTrainingTool(this, toolArea);
        AddAWeightTool addAWeightTool = new AddAWeightTool(this, toolArea);
        ViewWeightRecordsTool viewWeightRecordsTool = new ViewWeightRecordsTool(this, toolArea);
        SaveTool saveTool = new SaveTool(this, toolArea);
        LoadTool loadTool = new LoadTool(this, toolArea);

        tools.add(addAMealTool);
        tools.add(mealsTool);
        tools.add(addATrainingTool);
        tools.add(viewPastTrainingTool);
        tools.add(addAWeightTool);
        tools.add(viewWeightRecordsTool);
        tools.add(saveTool);
        tools.add(loadTool);
    }


    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Food and add it to food log
    public void makeNewMeal() {
        activePanel = addAMealPanel.questionPanel();
        refreshActivePanel();
    }


    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Training and add it to Training log
    public void makeNewTraining() {
        activePanel = addATrainingPanel.questionPanel();
        refreshActivePanel();
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new weight and add it to weight log
    public void makeNewWeight() {
        activePanel = addAWeightPanel.questionPanel();
        refreshActivePanel();
    }


    // REQUIRES: mealLog is not null
    // MODIFIES: this
    // EFFECTS: print out all meals in mealLog in the activePanel;
    public void viewPastMeals() {
        activePanel = pastMealsPanel.makeMealLogPanel(foodLog);
        refreshActivePanel();
    }

    // REQUIRES: trainingLog is not null
    // MODIFIES: this
    // EFFECTS: print out all trainings in mealLog;
    public void viewPastTraining() {
        activePanel = pastTrainingPanel.makeTrainingPanel(trainingLog);
        refreshActivePanel();
    }

    // REQUIRES: weightLog is not null
    // MODIFIES: this
    // EFFECTS: help method that prints out Measurement analysis
    public void viewPastMeasurements() {
        activePanel = pastWeightsPanel.makeWeightsLogPanel(weightLog);
        refreshActivePanel();
    }

    // MODIFIES: this
    // EFFECTS: load logs from file
    public void loadFile() {
        loadFoodLog();
        loadTrainingLog();
        loadWeightLog();
    }

    // EFFECTS: save logs to file
    public void saveFiles() {
        saveFoodLog();
        saveTrainingLog();
        saveWeightLog();
    }


    // EFFECTS: saves the foodLog to file
    private void saveFoodLog() {
        try {
            jsonWriterFood.open();
            jsonWriterFood.write(foodLog);
            jsonWriterFood.close();
            System.out.println("Saved FoodLog");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    // EFFECTS: saves the TrainingLog to file
    private void saveTrainingLog() {
        try {
            jsonWriterTraining.open();
            jsonWriterTraining.write(trainingLog);
            jsonWriterTraining.close();
            System.out.println("Saved TrainingLog");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    // EFFECTS: saves the WeightLog to file
    private void saveWeightLog() {
        try {
            jsonWriterWeight.open();
            jsonWriterWeight.write(weightLog);
            jsonWriterWeight.close();
            System.out.println("Saved WeightLog");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads foodLog from file
    private void loadFoodLog() {
        try {
            foodLog = jsonReaderFood.readFoodLog();
            System.out.println("Loaded " + foodLog.getName() + " from " + JSON_STORE_FOOD);
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads TrainingLog from file
    private void loadTrainingLog() {
        try {
            trainingLog = jsonReaderTraining.readTrainingLog();
            System.out.println("Loaded " + trainingLog.getName() + " from " + JSON_STORE_TRAINING);
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads WeightLog from file
    private void loadWeightLog() {
        try {
            weightLog = jsonReaderWeight.readWeightLog();
            System.out.println("Loaded " + weightLog.getName() + " from " + JSON_STORE_WEIGHT);
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

}

