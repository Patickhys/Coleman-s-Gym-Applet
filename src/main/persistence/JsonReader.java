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
    private static final String JSON_STORE_FOOD = "./data/savedFoodLog.json";
    private static final String JSON_STORE_TRAINING = "./data/savedTrainingLog.json";
    private static final String JSON_STORE_WEIGHT = "./data/savedWeightLog.json";

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads FoodLog from file and returns it;
    // throws IOException if an error occurs reading data from file
    public FoodLog readFoodLog() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFoodLog(jsonObject);
    }

/*
    // EFFECTS: reads TrainingLog from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Log readTrainingLog() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTrainingLog(jsonObject);
    }

    // EFFECTS: reads WeightLog from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Log readWeightLog() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWeightLog(jsonObject);
    }
*/




    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses FoodLog from JSON object and returns it
    private FoodLog parseFoodLog(JSONObject jsonObject) {
        FoodLog log = new FoodLog(jsonObject.getString("name"));
        addFoodEntries(log, jsonObject);
        return log;
    }

 /*   // EFFECTS: parses TrainingLog from JSON object and returns it
    private Log parseTrainingLog(JSONObject jsonObject) {
        Log log = new TrainingLog();
        addTrainingEntries(log, jsonObject);
        return log;
    }

    // EFFECTS: parses FoodLog from JSON object and returns it
    private Log parseWeightLog(JSONObject jsonObject) {
        Log log = new WeightLog();
        addWeightEntries(log, jsonObject);
        return log;
    }*/

    // MODIFIES: FoodLog
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addFoodEntries(FoodLog log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Entries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addFoodEntry(log, nextEntry);
        }
    }
/*

    // MODIFIES: TrainingLog
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addTrainingEntries(Log log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Entries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addTrainingEntry(log, nextEntry);
        }
    }

    // MODIFIES: WeightLog
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addWeightEntries(Log log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Entries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addWeightEntry(log, nextEntry);
        }
    }
*/

    // MODIFIES: FoodLog
    // EFFECTS: parses food from JSON object and adds it to FoodLog
    private void addFoodEntry(FoodLog log, JSONObject jsonObject) {
        int carbs = jsonObject.getInt("Carbs");
        int protein = jsonObject.getInt("Protein");
        int fat = jsonObject.getInt("Fat");
        Food food = new Food(carbs, protein,fat);
        log.addEntry(food);
    }

  /*  // MODIFIES: TrainingLog
    // EFFECTS: parses training from JSON object and adds it to TrainingLog
    private void addTrainingEntry(Log log, JSONObject jsonObject) {
        String name = jsonObject.getString("Exercise");
        int calories = jsonObject.getInt("Calories");
        int duration = jsonObject.getInt("Duration");
        Training training = new Training(name,calories,duration);
        log.addEntry(training);
    }

    // MODIFIES: WeightLog
    // EFFECTS: parses food from JSON object and adds it to FoodLog
    private void addWeightEntry(Log log, JSONObject jsonObject) {
        double weight = jsonObject.getDouble("Weight");
        double height = jsonObject.getDouble("Height");
        Weight w = new Weight(weight,height);
        log.addEntry(w);
    }*/
}
