package ui;

//Represents a new FitnessApp, initials the app

import java.util.Scanner;

public class FitnessApp {
    private String userName;
    private String userSex;
    private int userHeight;
    private double userWeight;

    // MODIFIES: this
    // EFFECTS: create a new user profile
    public void initializeUser() {
        System.out.println("Welcome to COLEMAN's");
        System.out.println("Please enter your name!");
        Scanner name = new Scanner(System.in);
        userName = name.nextLine();
        System.out.println("Hello, " + userName + " !");
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
        System.out.println("Please select an option!");
        System.out.println("1.Nutrition Record");
        System.out.println("2. Training Record");
        System.out.println("3. Measurement Record");
        System.out.println("4. Create a new Workout Program");
        System.out.printf("5. Exit");
        while (true) {
            Scanner option = new Scanner(System.in);
            if (option.nextLine().equals("1")) {
                nutritionMenu();
            } else if (option.nextLine().equals("2")) {
                trainingMenu();
            } else if (option.nextLine().equals("3")) {
                measurementMenu();
            } else if (option.nextLine().equals("4")) {
                workoutMenu();
            } else if (option.nextLine().equals("5")) {
                System.exit(1);
            }
            System.out.printf("Please entry an valid option!");
        }
    }


    protected void workoutMenu() {
    }

    protected void trainingMenu() {
        System.out.println("Please select an option!");
        System.out.println("1. Enter a training session");
        System.out.println("2. View my training history");
        while (true) {
            Scanner option = new Scanner(System.in);
            if (option.nextLine().equals("1")) {
                makeNewTraining();
            } else if (option.nextLine().equals("2")) {
                viewPastTraining();
            }
        }
    }

    public void nutritionMenu() {
    }

    public void measurementMenu() {
    }

    public void makeNewTraining() {
    }

    public void viewPastTraining() {
    }
}
