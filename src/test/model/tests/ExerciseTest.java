package model.tests;

import model.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {
    Exercise BenchPress;
    Exercise Rowing;
    Exercise Yoga;
    Double HalfHour = 30.0;
    @BeforeEach
    void makeNewExercises(){
        BenchPress = new Exercise("BenchPress",50, 10);
        Rowing = new Exercise("Rowing", 360, 30);
        Yoga = new Exercise("Yoga", 120,60);
    }
    @Test
    void testFindIntensity(){
        double BPIntensity = BenchPress.Calories / BenchPress.Duration * HalfHour;
        double rowingIntensity = Rowing.Calories / Rowing.Duration * HalfHour;
        double yogaIntensity = Yoga.Calories / Yoga.Duration * HalfHour;
        assertEquals(BPIntensity,BenchPress.findIntensity());
        assertEquals(rowingIntensity,Rowing.findIntensity());
        assertEquals(yogaIntensity,Yoga.findIntensity());
    }

}
