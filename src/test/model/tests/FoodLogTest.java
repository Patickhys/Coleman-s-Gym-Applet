package model.tests;

import model.Food;
import model.FoodLog;
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
    @BeforeEach
    void makeLog(){
        day1 = new Food();
        day2 = new Food();
        day3 = new Food();
        day1.eatAMeal(2*rice,chicken,avocado);
        day2.eatAMeal(rice, 2* chicken, avocado);
        day3.eatAMeal(rice,chicken,2* avocado);
        log = new FoodLog();
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
        assertEquals(totalCal / log.getNumLogs()  ,log.findDailyCalories());
    }
}
