package model.tests;

import model.Food;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// Testing the Food Class

public class FoodTest {
    Food myDiet;
    int rice = 150;
    int chicken = 200;
    int avocado = 100;

    @BeforeEach
    void runBefore(){
    myDiet = new Food(0,0,0);
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

    @Test
    void testReportMeal(){
        int cal = myDiet.getCalories();
        String result = "You had 0g of carbs, 0g of protein, and 0g of fat." + "A total of " + cal + " calories.";
        assertEquals(result,myDiet.reportMeal());
    }

    @Test
    void testToJson(){
        assertEquals(0,myDiet.toJson().get("Carbs"));
        assertEquals(0,myDiet.toJson().get("Protein"));
        assertEquals(0,myDiet.toJson().get("Fat"));
    }


}
