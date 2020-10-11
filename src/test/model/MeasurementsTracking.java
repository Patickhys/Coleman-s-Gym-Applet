package model;

import java.util.ArrayList;

// Represents a log of measurements, maximum one per day

public class MeasurementsTracking{
    ArrayList<Measurements> log;

    public MeasurementsTracking(){
        log = new ArrayList<>();
    }

    // REQUIRES: m must be a valid measurement
    // MODIFIES: this
    // EFFECTS: add an entry to the log
    public void addEntry(Measurements m) {
        log.add(m);
    }

    // REQUIRES: assume the log has at least one entry
    // EFFECTS: return an analysis of the measurements logged so far

    public String analyzeTrend(){
        String result = "";
        double firstWeight = log.get(0).weightInKg;
        double lastWeight = log.get(log.size()).weightInKg;
        double progress = lastWeight - firstWeight;
        if (firstWeight < lastWeight){
            result = "You lost " + progress + "kg, Keep up the good work!";
        }
        result = "You gained " + progress + " kg, Don't give up!";
         return result;
    }

    // EFFECTS: return the number of entries in the log
    public int getNumEntries(){
        int num = log.size();
        return num;
    }
}
