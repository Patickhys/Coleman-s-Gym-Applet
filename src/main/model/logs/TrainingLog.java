// Represents a log of training entries

package model.logs;

import model.entries.Training;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainingLog implements Log {
    private ArrayList<Training> log;
    private String userName;

    // MODIFIES: this
    // EFFECTS: make a new TrainingLog
    public TrainingLog() {
        log = new ArrayList<>();
    }

    // REQUIRES: a valid string for username
    // MODIFIES: this
    // EFFECTS: make a new TrainingLog with the User's name
    public TrainingLog(String userName) {
        log = new ArrayList<>();
        this.userName = userName;
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
        return log.get(pos);
    }

    // EFFECTS: Return the size of this log
    public Integer getSize() {
        return log.size();
    }

    // EFFECTS: Return the total calories from all the entries of this log
    public int getTotalCalories() {
        int totalCalories = 0;
        for (Training e : log) {
            totalCalories += e.getCalories();
        }
        return totalCalories;
    }

    // EFFECTS: Return the total calories from all the entries of this log
    public double getAvgIntensity() {
        double totalCal = 0;
        double avgIntensity;
        for (Training e : log) {
            totalCal += e.findIntensity();
        }
        avgIntensity = totalCal / getSize();
        return avgIntensity;
    }

    // EFFECTS: return a string that is a numbered report of all the trainings in the log
    public String viewPastTraining() {
        StringBuilder allTrainings = new StringBuilder();
        int number = 1;
        for (Training e : log) {
            allTrainings.append(number).append(". ").append(e.report()).append("\n");
            number++;
        }
        allTrainings.append("A total of ").append(getTotalCalories()).append(" calories.");
        return allTrainings.toString();
    }

    // MODIFIES: this
    // EFFECTS: set this.userName = userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // EFFECTS: returns an unmodifiable list of foods in this log
    public List<Training> getTrainings() {
        return Collections.unmodifiableList(log);
    }

    public String getName() {
        return userName;
    }

    // EFFECTS: returns this as a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", "Training Log for " + userName);
        json.put("Entries", entriesToJson());
        return json;
    }

    // EFFECTS: returns entries in this log as a JSON array
    @Override
    public JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Training t : log) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }


}
