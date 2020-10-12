package model;

import java.util.ArrayList;
import java.util.List;

// Represents a log of daily food intakes, each entry is one day

public class FoodLog {
    List<Food> log;

    public FoodLog(){
        log = new ArrayList<>();
    }

    // EFFECTS: return the total calories in the log
    public int getTotalCalories(){
        int TotalCalories = 0;
        for (Food d : log){
            TotalCalories += d.getCalories();
        }
        return TotalCalories;}

    // EFFECTS: return the number of entries in the log
    public int getNumLogs(){
        int numLogs = log.size();
        return numLogs;}

    // EFFECTS: return the entry in the given position, begins at 0
    public Food getEntry(int i){
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
    public double findDailyCalories(){
        double DailyCalories = getTotalCalories() / log.size();
        return DailyCalories;
    }

}
