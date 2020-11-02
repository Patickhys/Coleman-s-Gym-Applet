package model.tests;

import model.*;
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

    @Test
    void testWriterFoodLog() {
        try {
            FoodLog foodLog = new FoodLog("Patrick");
            foodLog.addEntry(new Food(10,20,30));
            foodLog.addEntry(new Food(0,50,0));
            JsonWriter writer = new JsonWriter("./data/testWriterFoodLog.json");
            writer.open();
            writer.write(foodLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterFoodLog.json");
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
    @Test
    void testWriterTrainingLog() {
        try {
            TrainingLog trainingLog = new TrainingLog("Patrick");
            trainingLog.addEntry(new Training("Bench Press",150,30));
            trainingLog.addEntry(new Training("Squats",50,10));
            JsonWriter writer = new JsonWriter("./data/testWriterTrainingLog.json");
            writer.open();
            writer.write(trainingLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTrainingLog.json");
            trainingLog =  reader.readTrainingLog();
            assertEquals("Training Log for Patrick", trainingLog.getName());
            List<Training> trainings = trainingLog.getTrainings();
            assertEquals(2, trainings.size());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testWriterWeightLog() {
        try {
            WeightLog weightLog = new WeightLog("Patrick");
            weightLog.addEntry(new Weight(70.0,181));
            weightLog.addEntry(new Weight(72.0,181));
            JsonWriter writer = new JsonWriter("./data/testWriterWeightLog.json");
            writer.open();
            writer.write(weightLog);
            writer.close();
            JsonReader reader = new JsonReader("./data/testWriterWeightLog.json");
            weightLog = reader.readWeightLog();
            assertEquals("Weigh Log for Patrick", weightLog.getName());
            List<Weight> weights = weightLog.getWeights();
            assertEquals(2, weights.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
