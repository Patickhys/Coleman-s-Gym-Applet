// Represents a log of daily food intakes

package model.logs;

import model.entries.Food;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FoodLog implements Log, Writable {

    public ArrayList<Food> log;
    private String userName;

    // REQUIRES: a valid userName from FitnessApp
    // MODIFIES: this
    // EFFECTS: make a new FoodLog with the user's name
    public FoodLog(String userName) {
        log = new ArrayList<>();
        this.userName = userName;
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
        return userName;
    }

    // EFFECTS: return the entry in the given position, begins at 0
    public Food getEntry(int i) {
        i--;
        return log.get(i);
    }

    // REQUIRES: a valid Daily Calories
    // MODIFIES: this
    // EFFECTS: add a DailyCalories to the intake log
    public void addEntry(Food c) {
        log.add(c);
    }

    // Requires: a string that is an userName
    // MODIFIES: this
    // EFFECTS: set this.userName = userName
    public void setUserName(String userName) {
        this.userName = userName;
    }


    // EFFECTS: return the average Calories consumed per day and
    public double findDailyCalories() {
        return getTotalCalories() / log.size();
    }

    // EFFECTSl: returns a string of a meal report of all past meals
    public String viewPastMeals() {
        String allMeals = "";
        int number = 1;
        for (Food f : log) {
            allMeals = allMeals + number + ". " + f.report() + "\n";
            number++;
        }
        int cal = getTotalCalories();
        allMeals = allMeals + "A total of " + cal + " calories.";
        return allMeals;
    }

    // EFFECTS: returns an unmodifiable list of foods in this log
    public List<Food> getFoods() {
        return Collections.unmodifiableList(log);
    }


    // EFFECTS: returns this as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "Food Log for " + userName);
        json.put("Entries", entriesToJson());
        return json;
    }

    // EFFECTS: returns entries in this log as a JSON array
    @Override
    public JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food f : log) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }
}