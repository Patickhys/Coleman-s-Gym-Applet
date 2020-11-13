package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a log of measurements, maximum one per day

public class WeightLog extends  Log {
    public ArrayList<Weight> log;
    private String userName;

    public WeightLog() {
        log = new ArrayList<>();
    }

    public WeightLog(String userName) {
        log = new ArrayList<>();
        this.userName = userName;
    }

    // REQUIRES: m must be a valid measurement
    // MODIFIES: this
    // EFFECTS: add an entry to the log
    public void addEntry(Weight m) {
        log.add(m);
    }


    // MODIFIES: this
    // EFFECTS: set this.userName = userName

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    // EFFECTS: returns an unmodifiable list of foods in this log
    public List<Weight> getWeights() {
        return Collections.unmodifiableList(log);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "Weight Log for " + userName);
        json.put("Entries", entriesToJson());
        return json;
    }

    @Override
    public JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Weight weight : log) {
            jsonArray.put(weight.toJson());
        }

        return jsonArray;
    }

}
