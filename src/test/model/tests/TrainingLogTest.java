package model.tests;

import model.entries.Training;
import model.logs.TrainingLog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        result = "1. " + BenchPress.report() + "\n"
                + "2. " + Rowing.report() + "\n"
                + "3. " + Yoga.report() + "\n"
                + "A total of " + log.getTotalCalories() + " calories.";
        assertEquals(result, log.viewPastTraining());
    }

    @Test
    void testToJson(){
        TrainingLog sample = new TrainingLog();
        sample.addEntry(BenchPress);
        sample.addEntry(Rowing);
        sample.addEntry(Yoga);
        JSONObject json = log.toJson();
        json.put("name", userName);
        json.put("Entries", log.entriesToJson());
        assertTrue(userName==json.get("name"));
        assertEquals( log.entriesToJson().toString(),json.get("Entries").toString());
    }

    @Test
    void testEntriesToJson() {
        TrainingLog sample = new TrainingLog();
        sample.addEntry(BenchPress);
        sample.addEntry(Rowing);
        sample.addEntry(Yoga);
        JSONArray jsonArray = log.entriesToJson();
        assertTrue(3 == jsonArray.length());
        assertEquals(BenchPress.toJson().toString(),jsonArray.get(0).toString());
    }

    @Test
    void testUserName() {
        log.setUserName("Pat");
        assertEquals(log.getName(),"Pat");
    }
}
