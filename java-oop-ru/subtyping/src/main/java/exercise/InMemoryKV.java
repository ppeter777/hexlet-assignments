package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> database;
    public InMemoryKV(Map<String, String> database) {
        this.database = new HashMap<>(database);
    }
    public InMemoryKV() {
        this.database = new HashMap<>();
    }

    public void set(String key, String value) {
        this.database.put(key, value);
    }

    public void unset(String key) {
        this.database.remove(key);
    }

    public String get(String key, String defaultValue) {
        return database.getOrDefault(key, defaultValue);
    }
    public Map<String, String> toMap() {
        return new HashMap<>(database);
    }
}
// END
