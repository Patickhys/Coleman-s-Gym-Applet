package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FoodTrackingTest {
    FoodTracking log;
    DailyFood day1;
    DailyFood day2;
    DailyFood day3;
    int rice = 150;
    int chicken = 200;
    int avocado = 100;
    @BeforeEach
    void makeLog(){
        day1 = new DailyFood();
        day2 = new DailyFood();
        day3 = new DailyFood();
        day1.eatAMeal(2*rice,chicken,avocado);
        day2.eatAMeal(rice, 2* chicken, avocado);
        day3.eatAMeal(rice,chicken,2* avocado);
        log = new FoodTracking();
    }

    @Test
    void testAddEntry(){
        log.addEntry(day1);
        assertEquals(day1,log.getEntry(0));
        assertTrue(log.TotalCalories == day1.getCalories());
        log.addEntry(day2);
        assertTrue(log.TotalCalories == day1.getCalories() + day2.getCalories());
        assertEquals(day2,log.getEntry(1));
        log.addEntry(day3);
        assertTrue(log.TotalCalories == day1.getCalories() + day2.getCalories() + day3.getCalories());
        assertEquals(day3,log.getEntry(2));
    }
    @Test
    void testFindDailyCalories(){
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
        int totalCal = day1.getCalories() + day2.getCalories() + day3.getCalories();
        assertEquals(totalCal / log.numLogs ,log.findDailyCalories());
    }
}
