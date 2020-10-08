package model;

public class Training {
    String Exercise;
    Integer Calories;

    // REQUIRES: exercise must be valid, calories > 0
    // EFFECTS: make a new Training
    public Training(String exercise, int calories){
        Exercise = exercise;
        Calories = calories;
    }
    //getters
    public String getExercise(){ return Exercise;}
    public Integer getCalories(){ return Calories;}



}
