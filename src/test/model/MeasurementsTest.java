package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasurementsTest {
    double weight = 50.0;  // weight in grams
    double height = 160.0;     // height in cm
    Measurements mySize;
    @BeforeEach
    void makeMeasurement(){
       mySize = new Measurements(weight,height);
    }
    @Test
    void testFindBMI(){
       double heightInMSquared = Math.pow(height /100,2);
        assertEquals(weight/ heightInMSquared, mySize.findBMI());
    }
}
