package model.entries;

import org.json.JSONObject;
import persistence.Writable;

// Presents an exercise that has a name, calories burnt, and duration in minutes
public class Training implements Writable,Entry {
    public String name;
    private int calories;
    private int duration; // in minutes

    // MODIFIES: this
    // EFFECTS: make a new Training with name calories and duration
    // throws NumberFormatException if the param contains negative numbers
    public Training(String name, int calories, int duration) throws NumberFormatException {
        if (calories < 0 || duration < 0) {
            throw new NumberFormatException();
        }
        this.name = name;
        this.calories = calories;
        this.duration = duration;
    }

    // getters

    public int getCalories() {
        return calories;
    }

    public int getDuration() {
        return duration;
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
