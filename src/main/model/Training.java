package model;

// Presents an exercise that has a name, calories burnt, and duration in minutes
public class Training {
    public String name;
    public int calories;
    public int duration; // in minutes

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

    public String reportExercise() {
        String exercise = "You did " + name + " for " + duration + " minutes. It burned " + calories + " calories.";
        return exercise;
    }
}
