package model;

import java.util.ArrayList;

// Represents a log of measurements, maximum one per day

public class WeightLog {
    public ArrayList<Weight> log;

    public WeightLog() {
        log = new ArrayList<>();
    }

    // REQUIRES: m must be a valid measurement
    // MODIFIES: this
    // EFFECTS: add an entry to the log
    public void addEntry(Weight m) {
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
        } else {
            result = "Looks like your weight has not changed.";
        }

        return result;
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

}
