package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// Represents a log of measurements, maximum one per day

public class WeightLog extends  Log {
    public ArrayList<Weight> log;
    String userName;
    Type type;


    public WeightLog() {
        log = new ArrayList<>();
    }

    public WeightLog(String userName) {
        log = new ArrayList<>();
        this.userName = userName + "'s weight log";
        type = Type.TRAINING;
    }

    // REQUIRES: m must be a valid measurement
    // MODIFIES: this
    // EFFECTS: add an entry to the log
    public void addEntry(Weight m) {
        log.add(m);
    }

    @Override
    public void addEntry(Food food) {}

    @Override
    public void addEntry(Training training) {}

    // REQUIRES: assume the log has at least one entry
    // EFFECTS: return an analysis of the measurements logged so far

    public String analyzeTrend() {
        String result = "";
        int lastPos = log.size() - 1;
        double firstWeight = log.get(0).weightInKg;
        double lastWeight = log.get(lastPos).weightInKg;
        double progress = firstWeight - lastWeight;
        if (progress > 0) {
            result = "You lost " + progress + "kg, Keep up the good work!";
        } else if (progress < 0) {
            result = "You gained " + -progress + "kg, Don't give up!";
        } else {
            result = "Looks like your weight has not changed.";
        }

        return result;
    }

    @Override
    public String viewPastMeals() {
        return null;
    }

    @Override
    public String viewPastTraining() {
        return null;
    }

    @Override
    public String getName() {
        return userName;
    }

    // EFFECTS: return the number of entries in the log
    public int getNumEntries() {
        int num = log.size();
        return num;
    }

    // REQUIRES: log has at least one entry
    // EFFECTS: return a string made up of all weight reports from the log
    public String viewAllMeasurements() {
        String allMeasurements = "";
        int number = 1;
        for (Weight w : log) {
            allMeasurements = allMeasurements + number + ". "  + w.report() + "\n";
            number++;
        }
        return allMeasurements;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "Food Log for " + userName);
        json.put("Entries", entriesToJson());
        return json;
    }

    @Override
    JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Weight weight : log) {
            jsonArray.put(weight.toJson());
        }

        return jsonArray;
    }

}
