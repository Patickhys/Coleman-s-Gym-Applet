package model.tests;

import model.TrainingLog;
import model.Weight;
import model.WeightLog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeightLogTest {
    WeightLog log;
    String userName = "Patrick";
    Weight day1 = new Weight(50,160);
    Weight day2 = new Weight(49,160);
    Weight day3 = new Weight(48,160);
    Weight day4 = new Weight(51,160);

    @BeforeEach
    void makeALog(){
        log = new WeightLog(userName);
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
    @Test
    void testGetNumEntries(){
        assertEquals(3,log.getNumEntries());
        log.addEntry(day4);
        assertEquals(4,log.getNumEntries());
    }
    @Test
    void testViewAllMeasurements(){
        String report = "1. " + day1.report() + "\n"
                + "2. " + day2.report() + "\n"
                + "3. " +  day3.report() + "\n";
        assertEquals(report,log.viewAllMeasurements());
    }

    @Test
    void testToJson(){
        WeightLog sample = new WeightLog();
        sample.addEntry(day1);
        sample.addEntry(day2);
        sample.addEntry(day3);
        JSONObject json = log.toJson();
        json.put("name", userName);
        json.put("Entries", log.entriesToJson());
        assertTrue(userName==json.get("name"));
        assertEquals( log.entriesToJson().toString(),json.get("Entries").toString());
    }

    @Test
    void testEntriesToJson() {
        WeightLog sample = new WeightLog();
        sample.addEntry(day1);
        sample.addEntry(day2);
        sample.addEntry(day3);
        JSONArray jsonArray = log.entriesToJson();
        assertTrue(3 == jsonArray.length());
        assertEquals(day1.toJson().toString(),jsonArray.get(0).toString());
    }

    @Test
    void testUserName() {
        log.setUserName("Pat");
        assertEquals(log.getName(),"Pat");
    }
}
