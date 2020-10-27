// REFERENCE: code in this package refers to JsonSerializationDemo

package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Log read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFoodLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses FoodLog from JSON object and returns it
    private Log parseFoodLog(JSONObject jsonObject) {
        Log log = new FoodLog();
        addFoodEntry(log, jsonObject);
        return log;
    }

    // MODIFIES: FoodLog
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addFoodEntries(Log log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("logs");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addFoodEntry(log, nextEntry);
        }
    }

    // MODIFIES: FoodLog
    // EFFECTS: parses food from JSON object and adds it to FoodLog
    private void addFoodEntry(Log log, JSONObject jsonObject) {
        int carbs = jsonObject.getInt("carbs");
        int protein = jsonObject.getInt("protein");
        int fat = jsonObject.getInt("fat");
        Food food = new Food(carbs, protein,fat);
        log.addEntry(food);
    }

    // MODIFIES: TrainingLog
    // EFFECTS: parses training from JSON object and adds it to TrainingLog
    private void addTrainingEntry(TrainingLog log, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int calories = jsonObject.getInt("calories");
        int duration = jsonObject.getInt("duration");
        Training training = new Training(name,calories,duration);
        log.addEntry(training);
    }

    // MODIFIES: WeightLog
    // EFFECTS: parses food from JSON object and adds it to FoodLog
    private void addWeightEntry(WeightLog log, JSONObject jsonObject) {
        double weight = jsonObject.getDouble("weight");
        double height = jsonObject.getDouble("height");
        Weight w = new Weight(weight,height);
        log.addEntry(w);
    }
}
