package model;

// Represents various measurements provided by the user


public class Weight {
    public double weightInKg;
    public final double heightInCm;

    // REQUIRES: weight to be in kg and height to be in cm
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
        String.format("%.1g%n", bmi);
        return bmi;
    }

    // EFFECTS: return a string that reports BMI and weight
    public String report() {
        String report = "Your BMI is " + findBMI() + " at " + weightInKg + " kg.";
        return report;
    }
}
