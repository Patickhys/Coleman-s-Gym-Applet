package ui;

//Represents a new FitnessApp, initials the app

import java.util.Scanner;

import model.*;

public class FitnessApp {
    private String userName;
    private String userSex = "userSex";
    private int userHeight;
    private double userWeight;
    private TrainingLog trainingLog;
    private FoodLog mealLog;
    private WeightLog weightLog;

    public FitnessApp() {
        trainingLog = new TrainingLog();
        initializeUser();
        while (true) {
            mainMenu();
        }
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

    public void mainMenu() {
        while (true) {
            System.out.println("Please select an option!");
            System.out.println("1. Nutrition Record");
            System.out.println("2. Training Record");
            System.out.println("3. Measurement Record");
            System.out.println("0. Exit");
            Scanner option = new Scanner(System.in);
            int choice = option.nextInt();
            if (choice == 1) {
                nutritionMenu();
            } else if (choice == 2) {
                trainingMenu();
            } else if (choice == 3) {
                measurementMenu();
            } else if (choice == 0) {
                System.exit(1);
            }
        }
    }

    // REQUIRES: an option must be valid string that describe an user option
    // EFFECTS: a helpful method for submenus

    public void secondaryMenu(String option1, String option2) {
        System.out.println("Please select an option!");
        System.out.println(option1);
        System.out.println(option2);
    }

    protected void trainingMenu() {
        secondaryMenu("1. Enter a training session", "2. View my training history");
        Scanner option = new Scanner(System.in);
        if (option.nextLine().equals("1")) {
            makeNewTraining();
        } else if (option.nextLine().equals("2")) {
            viewPastTraining();
        }
    }

    public void nutritionMenu() {
        secondaryMenu("1. Enter a meal", "2. View my meals");
        Scanner option = new Scanner(System.in);
        if (option.nextLine().equals("1")) {
            makeNewMeal();
        } else if (option.nextLine().equals("2")) {
            viewPastMeals();
        }
    }

    public void measurementMenu() {
        secondaryMenu("1. Enter a measurement", "2. View my measurements");
        Scanner option = new Scanner(System.in);
        if (option.nextLine().equals("1")) {
            makeMeasurement();
        } else if (option.nextLine().equals("2")) {
            viewPastMeasurements();
        }
    }

    public void viewPastMeasurements() {
        weightLog.viewAllMeasurements();
        weightLog.analyzeTrend();
    }

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

    public void viewPastMeals() {
        System.out.println((mealLog.viewPastMeals()));
    }

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

    public void viewPastTraining() {
        System.out.println(trainingLog.viewPastTraining());
    }
}



