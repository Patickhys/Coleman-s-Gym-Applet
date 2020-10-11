package model;

import java.util.ArrayList;
import java.util.List;
// Represents a log of daily food intakes, each entry is one day

public class FoodTracking {
    List<DailyFood> log;
    int TotalCalories = 0;
    int numLogs = 0;

    public FoodTracking(){
        log = new ArrayList<>();
    }

    // getters
    public int getTotalCalories(){return TotalCalories;}
    public int getNumLogs(){return numLogs;}

    // EFFECTS: return the entry in the given position, begins at 0
    public DailyFood getEntry(int i){
        DailyFood entry = log.get(i);
        return entry;
    }

    // REQUIRES: a valid Daily Calories
    // MODIFIES: this
    // EFFECTS: add a DailyCalories to the intake log, Update TotalCalories and numLogs

    public void addEntry(DailyFood c) {
        TotalCalories += c.getCalories();
        numLogs ++;
        log.add(c);
    }

    // EFFECTS: Find the average Calories consumed per day and return it
    public double findDailyCalories(){
        double DailyCalories = TotalCalories / numLogs;
        return DailyCalories;
    }

}
