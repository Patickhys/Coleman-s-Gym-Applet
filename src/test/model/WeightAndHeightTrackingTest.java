package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightAndHeightTrackingTest {
    WeightAndHeightTracking log;
    WeightAndHeight day1 = new WeightAndHeight(50,160);
    WeightAndHeight day2 = new WeightAndHeight(49,160);
    WeightAndHeight day3 = new WeightAndHeight(48,160);
    WeightAndHeight day4 = new WeightAndHeight(51,160);

    @BeforeEach
    void makeALog(){
        log = new WeightAndHeightTracking();
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
    }

    @Test
    void testAnalyzeTrendNoChange(){
        log.addEntry(day1);
        String result = "Looks like your weight has not changed.";
        assertEquals(result, log.analyzeTrend());
    }

    @Test
    void testAnalyzeTrendLosingWeight(){
        double lostWeight = day1.weightInKg - day3.weightInKg;
        String result =  "You lost " + lostWeight + "kg, Keep up the good work!";
        assertEquals(result, log.analyzeTrend());
    }
    @Test
    void testAnalyzeTrendGainingWeight(){
        log.addEntry(day4);
        double gainWeight = day4.weightInKg - day1.weightInKg;
        String result = "You gained " + gainWeight + "kg, Don't give up!";
        assertEquals(result, log.analyzeTrend());
    }
}
