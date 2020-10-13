package model;


// Represents a log tracking calories related entries, ie food and exercise

public abstract class CaloriesLog {

    // EFFECTS: return the total calories in the log

    public abstract int getTotalCalories();

    // EFFECTS: return the number of entries in the log
    public abstract int getLogSize();
}
