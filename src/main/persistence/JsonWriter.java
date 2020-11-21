// REFERENCE: code in this package refers to JsonSerializationDemo
// Represents a writer that writes JSON representation of workroom to file

package persistence;

import model.logs.FoodLog;
import model.logs.TrainingLog;
import model.logs.WeightLog;
import org.json.JSONObject;

import java.io.*;


public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;


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