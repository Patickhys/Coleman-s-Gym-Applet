package ui;

//Represents a new FitnessApp, initials the app

import java.util.Scanner;

import model.*;

public class FitnessApp {
    protected String userName;
    protected String userSex;
    private int userHeight;
    private double userWeight;
    public TrainingLog trainingLog;
    public FoodLog mealLog;
    public WeightLog weightLog;
    private Scanner input;

    public FitnessApp() {
        trainingLog = new TrainingLog();
        mealLog = new FoodLog();
        weightLog = new WeightLog();
        initializeUser();
        mainMenu();
    }

    // MODIFIES: this
    // EFFECTS: create a new user profile
    public void initializeUser() {
        System.out.println("Welcome to COLEMAN's");
        System.out.println("Please enter your name!");
        Scanner name = new Scanner(System.in);
        userName = name.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Please indicate your sex!");
        Scanner sex = new Scanner(System.in);
        userSex = sex.nextLine();
        System.out.println("Please enter your height in cm!");
        Scanner height = new Scanner(System.in);
        String heightStr = height.nextLine();
        userHeight = Integer.parseInt(heightStr);
        System.out.println("Please enter your weight in kg!");
        Scanner weight = new Scanner(System.in);
        String weightStr = weight.nextLine();
        userWeight = Double.parseDouble(weightStr);
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
    public void processSecondaryMenu(String option1, String option2) {
        System.out.println("Please select an option!");
        System.out.println(option1);
        System.out.println(option2);
    }

    // EFFECTS: a sub-menu for trainings
    public void trainingMenu() {
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
    public void measurementMenu() {
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
    public void viewPastMeasurements() {
        System.out.println((weightLog.viewAllMeasurements()));
        System.out.println(weightLog.analyzeTrend());
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Weight();
    public void makeMeasurement() {
        Scanner answer = new Scanner(System.in);
        System.out.println("How much do you weight in kg");
        userWeight = answer.nextInt();
        answer = new Scanner(System.in);
        System.out.println("How tall are you in cm?");
        userHeight = answer.nextInt();
        Weight newEntry = new Weight(userWeight, userHeight);
        weightLog.addEntry(newEntry);
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Food();
    public void makeNewMeal() {
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
        mealLog.addEntry(newMeal);
    }

    // REQUIRES: mealLog has at least one entry
    // EFFECTS: print out all meals in mealLog;
    public void viewPastMeals() {
        System.out.println((mealLog.viewPastMeals()));
    }

    // REQUIRES: user answers the question nicely
    // MODIFIES: this
    // EFFECTS: make a new Training();
    public void makeNewTraining() {
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
    public void viewPastTraining() {
        System.out.println(trainingLog.viewPastTraining());
    }
}



