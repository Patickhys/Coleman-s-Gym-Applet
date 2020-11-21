package model.tests;

import model.entries.Weight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// Testing the WeightAndHeightClass

public class WeightTest {
    double weight = 50.0;  // weight in grams
    double height = 160.0;     // height in cm
    Weight myWeight;

    @BeforeEach
    void makeMeasurement(){
       myWeight = new Weight(weight,height);
    }

    @Test
    void testFindBMI(){
       double heightInMSquared = Math.pow(height /100,2);
        assertEquals( weight/ heightInMSquared, myWeight.findBMI());
    }
    @Test
    void testReport(){
        String report = "Your BMI is " + myWeight.findBMI() + " at " + myWeight.weightInKg + " kg.";
        assertEquals(report, myWeight.report());
    }
    @Test
    void testToJson(){
        assertEquals(50.0,myWeight.toJson().get("Weight"));
        assertEquals(160.0,myWeight.toJson().get("Height"));
    }
}
