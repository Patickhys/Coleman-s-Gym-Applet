// REFERENCE: code in this package refers to JsonSerializationDemo

package presistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS returns this as JSON object
    JSONObject toJson();
}
