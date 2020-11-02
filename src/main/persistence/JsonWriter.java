// REFERENCE: code in this package refers to JsonSerializationDemo

package persistence;

import model.FoodLog;
import model.Log;
import model.TrainingLog;
import model.WeightLog;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes JSON representation of workroom to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;
    private static final String JSON_STORE_FOOD = "./data/savedFoodLog.json";
    private static final String JSON_STORE_TRAINING = "./data/savedTrainingLog.json";
    private static final String JSON_STORE_WEIGHT = "./data/savedWeightLog.json";

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of FoodLog to file
    public void write(FoodLog log) {
        JSONObject json = log.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of TrainingLog to file
    public void write(TrainingLog log) {
        JSONObject json = log.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of WeightLog to file
    public void write(WeightLog log) {
        JSONObject json = log.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}