package model;

import java.util.ArrayList;
import java.util.List;
// Represents a log of daily food intakes, each entry is one day

public class FoodTracking {
    List<DailyCalories> log;
    int TotalCalories = 0;
    int numLogs = 0;

    public FoodTracking(){
        log = new ArrayList<>();
    }
    // getters
    public int getTotalCalories(){return TotalCalories;}
    public int getNumLogs(){return numLogs;}

    // REQUIRES: a valid Daily Calories
    // MODIFIES: this
    // EFFECTS: add a DailyCalories to the intake log, Update TotalCalories and numLogs

    public void addEntry(DailyCalories c) {
        log.add(c);
        TotalCalories+= c.getCalories();
        numLogs ++;
    }

    // EFFECTS: Find the average Calories consumed per day and return it
    public int findDailyCalories(){
        int DailyCalories = TotalCalories / numLogs;
        return DailyCalories;
    }

}
