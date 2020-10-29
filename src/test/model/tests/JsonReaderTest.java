package model.tests;

import model.FoodLog;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            FoodLog foodLog = new FoodLog("My Log");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLog() {
        try {
            FoodLog foodLog = new FoodLog("Patrick");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLog.json");
            writer.open();
            writer.write(foodLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLog.json");
            foodLog = (FoodLog) reader.readFoodLog();
            assertEquals("Patrick's food log", foodLog.getName());
            assertEquals(0, foodLog.getLogSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
