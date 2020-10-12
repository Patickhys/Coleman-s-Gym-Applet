package model;

import java.util.ArrayList;

// Represents a log of measurements, maximum one per day

public class WeightAndHeightLog {
    ArrayList<WeightAndHeight> log;

    public WeightAndHeightLog() {
        log = new ArrayList<>();
    }

    // REQUIRES: m must be a valid measurement
    // MODIFIES: this
    // EFFECTS: add an entry to the log
    public void addEntry(WeightAndHeight m) {
        log.add(m);
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
        } else
            result = "Looks like your weight has not changed.";

        return result;
    }

    // EFFECTS: return the number of entries in the log
    public int getNumEntries() {
        int num = log.size();
        return num;
    }
}
