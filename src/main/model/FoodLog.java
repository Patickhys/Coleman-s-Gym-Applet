package model;

import java.util.ArrayList;


// Represents a log of daily food intakes, each entry is one day

public class FoodLog extends CaloriesLog {
    public ArrayList<Food> log;

    public FoodLog() {
        log = new ArrayList<>();
    }

    // EFFECTS: return the total calories in the log
    @Override
    public int getTotalCalories() {
        int totalCalories = 0;
        for (Food d : log) {
            totalCalories += d.getCalories();
        }
        return totalCalories;
    }

    // EFFECTS: return the number of entries in the log
    @Override
    public int getLogSize() {
        return log.size();
    }

    // EFFECTS: return the entry in the given position, begins at 0
    public Food getEntry(int i) {
        i--;
        return log.get(i);
    }

    // REQUIRES: a valid Daily Calories
    // MODIFIES: this
    // EFFECTS: add a DailyCalories to the intake log, Update TotalCalories and numLogs

    public void addEntry(Food c) {
        log.add(c);
    }

    // EFFECTS: return the average Calories consumed per day and
    public double findDailyCalories() {
        return getTotalCalories() / log.size();
    }

    public String viewPastMeals() {
        String allMeals = "";
        int number = 1;
        for (Food f : log) {
            allMeals = allMeals + number + ". " + f.reportMeal() + "\n";
            number++;
        }
        int cal = getTotalCalories();
        allMeals = allMeals + "A total of " + cal + " calories.";
        return allMeals;
    }
}
