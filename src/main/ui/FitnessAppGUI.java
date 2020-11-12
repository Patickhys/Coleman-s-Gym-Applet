package ui;

// Json related code is referred to the JsonSerialization Demo
//Represents a new FitnessApp, initials the app


import model.*;
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
import java.util.Scanner;

public class FitnessAppGUI extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private static final String JSON_STORE_FOOD = "./data/savedFoodLog.json";
    private static final String JSON_STORE_TRAINING = "./data/savedTrainingLog.json";
    private static final String JSON_STORE_WEIGHT = "./data/savedWeightLog.json";
    private static User user;
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

    private BoxLayout boxLayout;

    private JPanel activePanel;
    private JPanel welcomePanel;
    private TrainingPanel trainingPanel;
    private UserPanel userPanel;
    private PastMealsPanel pastMealsPanel;

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
        userPanel = new UserPanel();
        welcomePanel = new WelcomePanel();
        trainingPanel = new TrainingPanel();
        pastMealsPanel = new PastMealsPanel();
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
        boxLayout = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        welcomeScreen();
        makeUserPanel();
        createTools();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: display a welcome image
    private void welcomeScreen() {
        add(welcomePanel, boxLayout);
    }

    // MODIFIES: this
    // EFFECTS: make user panel show up
    private void makeUserPanel() {
        remove(activePanel);
        activePanel = userPanel.makeUserPanel();
        add(activePanel, boxLayout);
        repaint();
    }


    // REQUIRES: the enter button is clicked
    // MODIFIES: this
    // EFFECTS: give the user the input name
    public static void submitUserName(String name) {
        user.giveName(name);
    }

    // MODIFIES: this
    // EFFECTS:  a helper method which declares and instantiates all tools
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

    // REQUIRES: an option must be valid string that describe an user option
    // EFFECTS: a helpful method for submenus
    private void processSecondaryMenu(String option1, String option2) {
        System.out.println("Please select an option!");
        System.out.println(option1);
        System.out.println(option2);
    }

    // EFFECTS: a sub-menu for trainings
    private void trainingMenu() {
        processSecondaryMenu("1. Enter a training session", "2. View my training history");
        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        if (choice == 1) {
            makeNewTraining();
        } else if (choice == 2) {
            viewPastTraining();
        }
    }


    // EFFECTS: a sub-menu for nutrition
    public void nutritionMenu() {
        processSecondaryMenu("1. Enter a meal", "2. View my meals");
        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        if (choice == 1) {
            makeNewMeal();
        } else if (choice == 2) {
            viewPastMeals();
        }
    }

    // EFFECTS: a sub-menu for measurements
    private void measurementMenu() {
        processSecondaryMenu("1. Enter a measurement", "2. View my measurements");
        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        if (choice == 1) {
            makeMeasurement();
        } else if (choice == 2) {
            viewPastMeasurements();
        }
    }

    // REQUIRES: weightLog has at least one entry
    // EFFECTS: help method that prints out Measurement analysis
    private void viewPastMeasurements() {
        System.out.println((weightLog.viewAllMeasurements()));
        System.out.println(weightLog.analyzeTrend());
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Weight();
    private void makeMeasurement() {
        Scanner answer = new Scanner(System.in);
        System.out.println("How much do you weight in kg");
        double userWeight = answer.nextInt();
        Weight newEntry = new Weight(userWeight, user.getHeight());
        weightLog.addEntry(newEntry);
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Food();
    public void makeNewMeal() {
        JTextArea prompt = new JTextArea(5, 20);
        add(prompt, boxLayout);

        Scanner answer = new Scanner(System.in);
        System.out.println("How much carbs in grams did you eat?");
        int carbs = answer.nextInt();
        answer = new Scanner(System.in);
        System.out.println("How much protein in grams did you eat?");
        int protein = answer.nextInt();
        answer = new Scanner(System.in);
        System.out.println("How much fat in grams did you eat?");
        int fat = answer.nextInt();
        Food newMeal = new Food(carbs, protein, fat);
        foodLog.addEntry(newMeal);
    }

    // REQUIRES: mealLog has at least one entry
    // EFFECTS: print out all meals in mealLog;
    public void viewPastMeals() {
        remove(boxLayout.getTarget());
        activePanel = pastMealsPanel.makeMealPanel(foodLog);
        add(activePanel,boxLayout);
        repaint();
    }


    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Training();
    public void makeNewTraining() {
        remove(activePanel);
        repaint();
        add(trainingPanel.firstQuestion(),boxLayout);
/*        add(trainingPanel.secondQuestion(),BorderLayout.CENTER);
        add(trainingPanel.thirdQuestion(),BorderLayout.CENTER);*/
    }

    // REQUIRES: trainingLog has at least one entry
    // EFFECTS: print out all trainings in mealLog;
    private void viewPastTraining() {
        System.out.println(trainingLog.viewPastTraining());
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
            System.out.println("Saved " + trainingLog.getName() + " to " + JSON_STORE_TRAINING);
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
            System.out.println("Saved " + weightLog.getName() + " to " + JSON_STORE_WEIGHT);
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

