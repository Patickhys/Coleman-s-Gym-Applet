package model;

import java.util.ArrayList;

public class TrainingLog {
    ArrayList<Training> log;

    // MODIFIES: this
    // EFFECTS: make a new TrainingLog
    public TrainingLog() {
        log = new ArrayList<>();
    }

    // REQUIRES: e must be a valid exercise
    // MODIFIES: this
    // EFFECTS: add an entry to log
    public void addEntry(Training e) {
        log.add(e);
    }

    // REQUIRES: pos must be 1 <= pos <= log.size()
    // EFFECTS: return the exercise at position given

    public Training getExerciseAtPos(int pos) {
        pos--;
        Training result = log.get(pos);
        return result;
    }

    // EFFECTS: Return the size of this log
    public Integer getSize() {
        int size = log.size();
        return size;
    }

    // EFFECTS: Return the total calories from all the entries of this log
    public int getTotalCalories() {
        int totalCalories = 0;
        for (Training e : log) {
            totalCalories += e.calories;
        }
        return totalCalories;
    }

    // EFFECTS: Return the total calories from all the entries of this log
    public double getAvgIntensity() {
        double totalCal = 0;
        double avgIntensity = 0;
        for (Training e : log) {
            totalCal += e.findIntensity();
        }
        avgIntensity = totalCal / getSize();
        return avgIntensity;
    }

    // EFFECTS: return a string that is a numbered report of all the trainings in the log
    public String viewPastTraining() {
        String allTrainings = "";
        int number = 1;
        for (Training e : log) {
            allTrainings = allTrainings + number + ". " + e.reportExercise() + "\n";
            number++;
        }
        allTrainings = allTrainings + "A total of " + getTotalCalories() + " calories.";
        return allTrainings;
    }
}
