package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;
public class FileKV implements KeyValueStorage {
    private final Map<String, String> database;
    String path;

    public FileKV(String path, Map<String, String> database) {
        this.database = new HashMap<>(database);
        this.path = path;
    }

    @Override
    public void set(String key, String value) {
        database.put(key, value);
        Utils.writeFile(path, Utils.serialize(database));
    }

    @Override
    public void unset(String key) {
        database.remove(key);
        Utils.writeFile(path, Utils.serialize(database));
    }

    @Override
    public String get(String key, String defaultValue) {
        return database.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
// END
