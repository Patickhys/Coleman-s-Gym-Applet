package model;

// Represents various measurements provided by the user


import org.json.JSONObject;

import static model.Type.WEIGHT;

public class Weight {
    public double weightInKg;
    public double heightInCm;
    public Type type = WEIGHT;

    // REQUIRES: weight to be in kg and height to be in cm, both > 0
    // EFFECTS: make a new measurement
    public Weight(double weight, double height) {
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
        return json;
    }
}
