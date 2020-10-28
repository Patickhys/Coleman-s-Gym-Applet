package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


// Represents a log of daily food intakes, each entry is one day

public class FoodLog extends Log {
    public ArrayList<Food> log;
    String name;

    // MODIFIES: this
    // EFFECTS: make a new FoodLog

    public FoodLog() {
        log = new ArrayList<>();
    }

    // REQUIRES: a valid userName from FitnessApp
    // MODIFIES: this
    // EFFECTS: make a new FoodLog with the user's name

    public FoodLog(String name) {
        log = new ArrayList<>();
        this.name = name + "'s food log";
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
    public int getLogSize() {
        return log.size();
    }

    // EFFECTS: return the name of this log
    public String getName() {
        return name;
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

    @Override
    public void addEntry(Training training) {}

    @Override
    public void addEntry(Weight weight) {}

    @Override
    public String viewAllMeasurements() {
        return null;
    }

    @Override
    public String analyzeTrend() {
        return null;
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

    @Override
    public String viewPastTraining() {
        return null;
    }

    // setter
    public void setName(String name) {
        this.name = name + "'s food log.";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Entries", entriesToJson());
        return json;
    }

    @Override
    public JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food f : log) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }
}