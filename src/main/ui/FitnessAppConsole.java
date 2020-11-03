package ui;

// Json related code is referred to the JsonSerialization Demo
//Represents a new FitnessApp, initials the app


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

import model.*;
import ui.tools.*;
import persistence.JsonReader;
import persistence.JsonWriter;

public class FitnessAppConsole {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private int userHeight;
    private double userWeight;
    public TrainingLog trainingLog;
    public FoodLog foodLog;
    public WeightLog weightLog;
    private Scanner input;
    private static final String JSON_STORE_FOOD = "./data/savedFoodLog.json";
    private static final String JSON_STORE_TRAINING = "./data/savedTrainingLog.json";
    private static final String JSON_STORE_WEIGHT = "./data/savedWeightLog.json";
    private JsonWriter jsonWriterFood;
    private JsonReader jsonReaderFood;
    private JsonWriter jsonWriterTraining;
    private JsonReader jsonReaderTraining;
    private JsonWriter jsonWriterWeight;
    private JsonReader jsonReaderWeight;
    private User user;
    private List<Tool> tools;

    public FitnessAppConsole() {
        initializeFields();
        mainMenu();
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
        user = new User();
        user.initializeUser();
        userHeight = user.getHeight();
        trainingLog = new TrainingLog(user.getName());
        foodLog = new FoodLog(user.getName());
        weightLog = new WeightLog(user.getName());
    }


    // EFFECTS: provides a main menu to all the sub-menus
    private void mainMenu() {
        boolean run = true;
        int choice = 0;
        input = new Scanner(System.in);
        while (run) {
            printMainMenu();
            choice = input.nextInt();
            if (choice == 0) {
                run = false;
            } else {
                processMainMenuChoice(choice);
            }
        }
        System.out.println("See you next time!");
    }

    // REQUIRES: a valid user input
    // EFFECTS: process the input by the user

    private void processMainMenuChoice(int choice) {
        if (choice == 1) {
            nutritionMenu();
        } else if (choice == 2) {
            trainingMenu();
        } else if (choice == 3) {
            measurementMenu();
        } else if (choice == 4) {
            saveFiles();
        } else if (choice == 5) {
            loadFile();
        }
    }

    // EFFECTS: prints out the main menu
    private void printMainMenu() {
        System.out.println("Please select an option!");
        System.out.println("1. Nutrition Record");
        System.out.println("2. Training Record");
        System.out.println("3. Measurement Record");
        System.out.println("4. Save File");
        System.out.println("5. Load File");
        System.out.println("0. Exit");
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
    private void nutritionMenu() {
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
        userWeight = answer.nextInt();
        Weight newEntry = new Weight(userWeight, userHeight);
        weightLog.addEntry(newEntry);
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Food();
    private void makeNewMeal() {
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
    private void viewPastMeals() {
        System.out.println((foodLog.viewPastMeals()));
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Training();
    private void makeNewTraining() {
        Scanner answer = new Scanner(System.in);
        System.out.println("What exercise did you do?");
        String name = answer.nextLine();
        answer = new Scanner(System.in);
        System.out.println("How many calories did you burn?");
        int calories = answer.nextInt();
        answer = new Scanner(System.in);
        System.out.println("How long in minutes did you exercise?");
        int duration = answer.nextInt();
        Training newTraining = new Training(name, calories, duration);
        trainingLog.addEntry(newTraining);
    }

    // REQUIRES: trainingLog has at least one entry
    // EFFECTS: print out all trainings in mealLog;
    private void viewPastTraining() {
        System.out.println(trainingLog.viewPastTraining());
    }

    // MODIFIES: this
    // EFFECTS: load logs from file
    private void loadFile() {
        loadFoodLog();
        loadTrainingLog();
        loadWeightLog();
    }

    // MODIFIES: this
    // EFFECTS: save logs to file
    private void saveFiles() {
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
            System.out.println("Saved FoodLog"); //+ foodLog.getName() + " to " + JSON_STORE_FOOD);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE_FOOD);
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
            System.out.println("Unable to write to file: " + JSON_STORE_TRAINING);
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
            System.out.println("Unable to write to file: " + JSON_STORE_WEIGHT);
        }
    }


    // MODIFIES: this
    // EFFECTS: loads foodLog from file
    private void loadFoodLog() {
        try {
            foodLog = jsonReaderFood.readFoodLog();
            System.out.println("Loaded " + foodLog.getName() + " from " + JSON_STORE_FOOD);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE_FOOD);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads TrainingLog from file
    private void loadTrainingLog() {
        try {
            trainingLog = jsonReaderTraining.readTrainingLog();
            System.out.println("Loaded " + trainingLog.getName() + " from " + JSON_STORE_TRAINING);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE_TRAINING);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads WeightLog from file
    private void loadWeightLog() {
        try {
            weightLog = jsonReaderWeight.readWeightLog();
            System.out.println("Loaded " + weightLog.getName() + " from " + JSON_STORE_WEIGHT);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE_WEIGHT);
        }
    }
}



