package model.entries;

import org.json.JSONObject;
import persistence.Writable;

// Presents an exercise that has a name, calories burnt, and duration in minutes
public class Training implements Writable,Entry {
    public String name;
    public int calories;
    public int duration; // in minutes

    // REQUIRES: calories and duration must be > 0
    // MODIFIES: this
    // EFFECTS: make a new Training with name calories and duration
    public Training(String name, int calories, int duration) {
        this.name = name;
        this.calories = calories;
        this.duration = duration;
    }

    // REQUIRES: the exercise must be valid, ie: calories && duration > 0
    // EFFECTS: return the intensity of the exercise in Cal/30min;
    public double findIntensity() {
        double unitTime = duration / 30.0;
        double intensity = calories / unitTime;
        return intensity;
    }

    // EFFECTS: return a string that describes the exercise
    public String report() {
        String exercise = "You did " + name + " for " + duration + " minutes. It burned " + calories + " calories.";
        return exercise;
    }

    // EFFECTS: make Training into a JsonObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Exercise", name);
        json.put("Calories", calories);
        json.put("Duration", duration);
        return json;
    }
}
