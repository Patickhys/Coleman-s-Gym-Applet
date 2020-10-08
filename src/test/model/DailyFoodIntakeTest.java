package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DailyFoodIntakeTest {
    DailyFoodIntake myDiet;
    int rice = 150;
    int chicken = 200;
    int avocado = 100;

    @BeforeEach
    void runBefore(){
    myDiet = new DailyFoodIntake();
    }

    @Test
    void testGetCarb(){
        assertEquals(0,myDiet.getCarbs());
    }

    @Test
    void testGetProtein(){
        assertEquals(0,myDiet.getProtein());
    }
    @Test
    void testGetFat(){
        assertEquals(0,myDiet.getFat());
    }

    @Test
    void testEatAMeal(){
        myDiet.eatAMeal(rice,chicken,avocado);
        assertEquals(rice,myDiet.getCarbs());
        assertEquals(chicken,myDiet.getProtein());
        assertEquals(avocado,myDiet.getFat());
    }

    @Test
    void testGetCalories(){
        myDiet.eatAMeal(rice,chicken,avocado);
        int calories = 4 * rice + 4 * chicken + 9 * avocado;
        assertEquals(calories,myDiet.getCalories());
    }

}
