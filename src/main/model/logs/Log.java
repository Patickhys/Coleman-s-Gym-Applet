package model.logs;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents a log with entries, ie food, exercise and weight

public interface Log {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();

    // EFFECTS: returns entries in this log as a JSON array
    JSONArray entriesToJson();

}
