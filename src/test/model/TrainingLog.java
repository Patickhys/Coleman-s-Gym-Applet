package model;

import java.util.ArrayList;
import java.util.List;

public class TrainingLog {
   List<Exercise> log;

    // EFFECTS: make a new TrainingLog
    public TrainingLog(){
        log = new ArrayList<>();
    }
    public void addEntry(Exercise e){
        log.add(e);
    }
    //getters
    public Exercise getExerciseAtPos(int pos){
        pos--;
        Exercise result = log.get(pos);
        return result;
    }

    // EFFECTS: Return the size of this log
    public Integer getSize(){
        int size = log.size();
        return size;
    }
    public int getTotalCalories(){
        int TotalCalories = 0;
        for (Exercise e : log){
            TotalCalories += e.Calories;
        }
        return TotalCalories;
    }
    public double getAvgIntensity(){
        double totalCal = 0;
        double AvgIntensity = 0;
        for (Exercise e: log){
            totalCal += e.findIntensity();
        }
        AvgIntensity = totalCal / getSize();
        return AvgIntensity;
    }
}
