package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage database) {
        Map<String, String> copy = new HashMap<>(database.toMap());
        for (Map.Entry<String, String> entry: copy.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            database.set(value, key);
            database.unset(key);
        }
    }
}
// END
