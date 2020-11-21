// Represents weight and height measurements provided by the user

package model.entries;

import org.json.JSONObject;
import persistence.Writable;


public class Weight implements Writable, Entry {
    private double weightInKg;
    private double heightInCm;


    // getters
    public double getWeightInKg() {
        return weightInKg;
    }

    public double getHeightInCm() {
        return heightInCm;
    }

    // REQUIRES: weight to be in kg and height to be in cm, both > 0
    // EFFECTS: make a new measurement
    public Weight(double weight, double height) throws NumberFormatException {
        if (weight < 0 || height < 0) {
            throw new NumberFormatException();
        }
        weightInKg = weight;
        heightInCm = height;
    }

    // EFFECTS: return the BMI of this measurement
    public double findBMI() {
        double heightInM = heightInCm / 100;
        double heightSquared = heightInM * heightInM;
        double bmi = weightInKg / heightSquared;
        return bmi;
    }

    // EFFECTS: return a string that reports BMI and weight
    public String report() {
        String report = "Your BMI is " + findBMI() + " at " + weightInKg + " kg.";
        return report;
    }

    // EFFECTS: Make weight into a JSONObject
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Weight", weightInKg);
        json.put("Height", heightInCm);
        return json;
    }
}
