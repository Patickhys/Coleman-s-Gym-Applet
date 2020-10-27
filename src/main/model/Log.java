package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents a log tracking calories related entries, ie food and exercise

public abstract class Log {

    public abstract JSONObject toJson();

    // EFFECTS: returns things in this workroom as a JSON array
    abstract JSONArray entriesToJson();

    // EFFECTS: add an Entry to the this food log
    public abstract void addEntry(Food food);

    // EFFECTS: add an Entry to the this training log
    public abstract void addEntry(Training training);

    // EFFECTS: add an Entry to the this weight log
    public abstract void addEntry(Weight weight);

    // EFFECTS: get all measurements as string from this
    public abstract String viewAllMeasurements();

    // EFFECTS: get weight trends from this
    public abstract String analyzeTrend();

    // EFFECTS: get past meals from this
    public abstract String viewPastMeals();

    // EFFECTS: get past trainings from this
    public abstract String viewPastTraining();

    // EFFECTS: get Name from this
    public abstract String getName();


}
