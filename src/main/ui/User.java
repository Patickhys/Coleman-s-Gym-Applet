package ui;


import java.util.Scanner;

public class User {
    public Scanner scanner;
    private String name;
    private int height;


    // EFFECTS: construct a new user
    public User() {
    }


    // MODIFIES:this
    // EFFECTS: construct a new user with a name and a height
    public User(String name, int height) {
        this.name = name;
        this.height = height;
    }


    // MODIFIES: this
    // EFFECTS: create a new user profile
    public void initializeUser() {
        scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Please enter your height in cm!");
        scanner = new Scanner(System.in);
        height = scanner.nextInt();

    }

    // REQUIRES: a string param
    // MODIFIES: this
    // EFFECTS: set the input as this.name

    public void giveName(String name) {
        this.name = name;
    }

    // getters
    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }


}
