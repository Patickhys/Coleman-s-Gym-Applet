package model;

// Presents an exercise that has a name, calories burnt, and duration in minutes
public class Exercise {
    String Name;
    public int Calories;
    public int Duration; // in minutes

    public Exercise(String name, int calories, int duration){
        Name = name;
        Calories = calories;
        Duration = duration;
    }

    // REQUIRES: the exercise must be valid, ie: calories && duration > 0
    // EFFECTS: return the intensity of the exercise in Cal/30min;
    public double findIntensity(){
        double UnitTime = Duration / 30.0;
        double intensity = Calories / UnitTime;
        return intensity;
    }
}
