package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents a log tracking calories related entries, ie food and exercise

public abstract class Log {

    abstract JSONObject toJson();

    // EFFECTS: returns things in this workroom as a JSON array
    abstract JSONArray entriesToJson();
}
