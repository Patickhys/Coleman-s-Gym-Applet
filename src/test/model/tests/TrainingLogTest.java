package model.tests;

import model.Training;
import model.TrainingLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainingLogTest {
    TrainingLog log;
    Training BenchPress = new Training("BenchPress",50, 10);
    Training Rowing = new Training("Rowing", 360, 30);
    Training Yoga = new Training("Yoga", 120,60);
    int totalCal = BenchPress.calories + Rowing.calories + Yoga.calories;
    int totalDuration = BenchPress.duration + Rowing.duration + Yoga.duration;
    String userName = "Patrick";

    @BeforeEach
    void makeNewLog(){
        log = new TrainingLog(userName);
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
    @Test
    void testViewPastTraining(){
        String result = "";
        result = "1. " + BenchPress.reportExercise() + "\n"
                + "2. " + Rowing.reportExercise() + "\n"
                + "3. " + Yoga.reportExercise() + "\n"
                + "A total of " + log.getTotalCalories() + " calories.";
        assertEquals(result, log.viewPastTraining());
    }

}
