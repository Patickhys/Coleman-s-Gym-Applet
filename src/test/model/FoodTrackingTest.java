package model;

import org.junit.jupiter.api.BeforeEach;

public class FoodTrackingTest {
    FoodTracking log;
    DailyCalories day1;
    DailyCalories day2;
    DailyCalories day3;
    int rice = 150;
    int chicken = 200;
    int avocado = 100;
    @BeforeEach
    void makeLog(){
        day1.eatAMeal(2*rice,chicken,avocado);
        day2.eatAMeal(rice, 2* chicken, avocado);
        day3.eatAMeal(rice,chicken,2* avocado);
        log.addEntry(day1);
        log.addEntry(day2);
        log.addEntry(day3);
    }
}
