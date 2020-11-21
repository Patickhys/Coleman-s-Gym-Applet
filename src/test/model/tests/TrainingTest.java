package model.tests;

import model.entries.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TrainingTest {
    Training BenchPress;
    Training Rowing;
    Training Yoga;
    Double HalfHour = 30.0;
    @BeforeEach
    void makeNewExercises(){
        BenchPress = new Training("BenchPress",50, 10);
        Rowing = new Training("Rowing", 360, 30);
        Yoga = new Training("Yoga", 120,60);
    }

    @Test
    void testConstructorNegativeParam(){
        try {
            BenchPress = new Training("BP", -50,10);
            fail();
        } catch (NumberFormatException e){
            // expected
        }
        try {
            BenchPress = new Training("BP", 50,-10);
            fail();
        } catch (NumberFormatException e) {
            // expected
        }
    }

    @Test
    void testFindIntensity(){
        double BPIntensity = BenchPress.calories / BenchPress.duration * HalfHour;
        double rowingIntensity = Rowing.calories / Rowing.duration * HalfHour;
        double yogaIntensity = Yoga.calories / Yoga.duration * HalfHour;
        assertEquals(BPIntensity,BenchPress.findIntensity());
        assertEquals(rowingIntensity,Rowing.findIntensity());
        assertEquals(yogaIntensity,Yoga.findIntensity());
    }
    @Test
    void testReportExercise(){
        String result = "You did " + BenchPress.name + " for " + BenchPress.duration + " minutes. It burned "
                + BenchPress.calories + " calories.";
        assertEquals(result, BenchPress.report());
    }

    @Test
    void testToJson(){
        assertEquals("BenchPress",BenchPress.toJson().get("Exercise"));
        assertEquals(50,BenchPress.toJson().get("Calories"));
        assertEquals(10,BenchPress.toJson().get("Duration"));
    }

}
