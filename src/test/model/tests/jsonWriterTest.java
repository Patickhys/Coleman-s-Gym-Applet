package model.tests;

import model.Food;
import model.FoodLog;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class jsonWriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            FoodLog foodLog = new FoodLog("Patrick");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            FoodLog foodLog = new FoodLog("Patrick");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(foodLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            foodLog = (FoodLog) reader.readFoodLog();
            assertEquals("Patrick's food log", foodLog.getName());
            assertEquals(0, foodLog.getLogSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            FoodLog foodLog = new FoodLog("Patrick");
            foodLog.addEntry(new Food(10,20,30));
            foodLog.addEntry(new Food(0,50,0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(foodLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            foodLog = (FoodLog) reader.readFoodLog();
            assertEquals("Patrick's food log", foodLog.getName());
            List<Food> foods = foodLog.getFoods();
            assertEquals(2, foods.size());
            checkFood(10, 20,30, foods.get(0));
            checkFood(0, 50,0, foods.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
