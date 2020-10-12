package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TraingLogTest {
    TrainingLog log;
    Exercise BenchPress = new Exercise("BenchPress",50, 10);
    Exercise Rowing = new Exercise("Rowing", 360, 30);
    Exercise Yoga = new Exercise("Yoga", 120,60);
    int totalCal = BenchPress.Calories + Rowing.Calories + Yoga.Calories;
    int totalDuration = BenchPress.Duration + Rowing.Duration + Yoga.Duration;
    double halfhour = 30.0;

    @BeforeEach
    void makeNewLog(){
        log = new TrainingLog();
        log.addEntry(BenchPress);
        log.addEntry(Rowing);
        log.addEntry(Yoga);
    }
    @Test
    void testGetSize(){
        assertEquals(3,log.getSize());
        log = new TrainingLog();
        assertEquals(0,log.getSize());
    }
    @Test
    void testGetExerciseAtPos(){
        assertEquals(BenchPress,log.getExerciseAtPos(1));
        assertEquals(Rowing,log.getExerciseAtPos(2));
        assertEquals(Yoga,log.getExerciseAtPos(3));
    }
    @Test
    void testGetTotalCalories(){
        assertEquals(totalCal,log.getTotalCalories());
        log = new TrainingLog();
        assertEquals(0,log.getTotalCalories());
    }
    @Test
    void testGetAvgIntensity(){
        double benchPressIntensity = BenchPress.findIntensity();
        double rowingIntensity = Rowing.findIntensity();
        double yogaIntensity = Yoga.findIntensity();
        double result = (benchPressIntensity + rowingIntensity + yogaIntensity) / 3;
        assertEquals(result,log.getAvgIntensity());
    }

}
