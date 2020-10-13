package model.tests;

import model.Weight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// Testing the WeightAndHeightClass

public class WeightTest {
    double weight = 50.0;  // weight in grams
    double height = 160.0;     // height in cm
    Weight mySize;

    @BeforeEach
    void makeMeasurement(){
       mySize = new Weight(weight,height);
    }

    @Test
    void testFindBMI(){
       double heightInMSquared = Math.pow(height /100,2);
        assertEquals( weight/ heightInMSquared, mySize.findBMI());
    }
    @Test
    void testReport(){
        String report = "Your BMI is " + mySize.findBMI() + " at " + mySize.weightInKg + " kg.";
        assertEquals(report,mySize.report());
    }
}
