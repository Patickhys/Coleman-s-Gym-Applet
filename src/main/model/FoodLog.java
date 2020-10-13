package model;

import java.util.ArrayList;


// Represents a log of daily food intakes, each entry is one day

public class FoodLog {
    public ArrayList<Food> log;

    public FoodLog() {
        log = new ArrayList<>();
    }

    // EFFECTS: return the total calories in the log
    public int getTotalCalories() {
        int totalCalories = 0;
        for (Food d : log) {
            totalCalories += d.getCalories();
        }
        return totalCalories;
    }

    // EFFECTS: return the number of entries in the log
    public int getNumLogs() {
        int numLogs = log.size();
        return numLogs;
    }

    // EFFECTS: return the entry in the given position, begins at 0
    public Food getEntry(int i) {
        i--;
        Food entry = log.get(i);
        return entry;
    }

    // REQUIRES: a valid Daily Calories
    // MODIFIES: this
    // EFFECTS: add a DailyCalories to the intake log, Update TotalCalories and numLogs

    public void addEntry(Food c) {
        log.add(c);
    }

    // EFFECTS: return the average Calories consumed per day and
    public double findDailyCalories() {
        double dailyCalories = getTotalCalories() / log.size();
        return dailyCalories;
    }

    public String viewPastMeals() {
        String allMeals = "";
        int number = 1;
        for (Food f : log) {
            allMeals = allMeals + number + ". " + f.reportMeal() + "\n";
            number++;
        }
        return allMeals;
    }
}
