package model.tests;

import model.entries.Food;
import model.logs.FoodLog;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Testing the FoodTracking Class
public class FoodLogTest {
    FoodLog log;
    Food day1;
    Food day2;
    Food day3;
    int rice = 150;
    int chicken = 200;
    int avocado = 100;
    String userName = "Patrick";

    @BeforeEach
    void makeLog(){
        day1 = new Food(2*rice,chicken,avocado);
        day2 = new Food(rice, 2* chicken, avocado);
        day3 = new Food(rice,chicken,2* avocado);
        log = new FoodLog(userName);
    }

    @Test
    void testAddEntry(){
        log.addEntry(day1);
        assertEquals(day1,log.getEntry(1));
        assertTrue(log.getTotalCalories() == day1.getCalories());
        log.addEntry(day2);
        assertTrue(log.getTotalCalories() == day1.getCalories() + day2.getCalories());
        assertEquals(day2,log.getEntry(2));
        log.addEntry(day3);
        assertTrue(log.getTotalCalories() == day1.getCalories() + day2.getCalories() + day3.getCalories());
        assertEquals(day3,log.getEntry(3));
    }
    @Test
    void testFindDailyCalories(){
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
        int totalCal = day1.getCalories() + day2.getCalories() + day3.getCalories();
        assertEquals(totalCal / log.getLogSize()  ,log.findDailyCalories());
    }

    @Test
    void testViewPastMeals(){
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
        String result;
        int cal = log.getTotalCalories();
        result = "1. " + day1.report() + "\n"
                + "2. " + day2.report() + "\n"
                + "3. " + day3.report() + "\n"
                + "A total of " + cal + " calories." ;
        assertEquals(result, log.viewPastMeals());
    }

    @Test
    void testToJson(){
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
        JSONObject json = log.toJson();
        json.put("name", userName);
        json.put("Entries", log.entriesToJson());
        assertTrue(userName==json.get("name"));
        assertEquals( log.entriesToJson().toString(),json.get("Entries").toString());
    }

    @Test
    void testEntriesToJson() {
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
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
