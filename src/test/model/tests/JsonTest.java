package model.tests;

import model.Food;
import model.FoodLog;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkFood(int carbs,int protein,int fat,Food f){
        assertEquals(carbs,f.getCarbs());
        assertEquals(protein,f.getProtein());
        assertEquals(fat,f.getFat());
    }
}
