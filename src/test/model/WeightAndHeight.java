package model;

// Represents various measurements provided by the user


import java.math.RoundingMode;

import static java.math.RoundingMode.CEILING;

public class WeightAndHeight {
    public double weightInKg;
    public final double heightInCm;

    // REQUIRES: weight to be in kg and height to be in cm
    // EFFECTS: make a new measurement
    public WeightAndHeight(double weight, double height){
    weightInKg = weight;
    heightInCm = height;
    }

    // EFFECTS: return the BMI of this measurement
    public double findBMI(){
        double heightInM = heightInCm / 100;
        double heightSquared = heightInM * heightInM;
        double BMI = weightInKg / heightSquared;
        String.format("%.1g%n",BMI);
        return BMI;

    }
}
