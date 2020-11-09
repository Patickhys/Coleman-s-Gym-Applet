package ui;

import java.util.Scanner;

public class User {
    private String name;
    private  int height;
    public Scanner scanner;


    //EFFECTS: construct a new user
    public User() {}

    //EFFECTS: construct a new user
    public User(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // MODIFIES: this
    // EFFECTS: create a new user profile
    public void initializeUser() {
        System.out.println("Welcome to COLEMAN's");
        System.out.println("Please enter your name!");
        scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Please enter your height in cm!");
        scanner = new Scanner(System.in);
        height = scanner.nextInt();
    }

    // getters
    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }
}
