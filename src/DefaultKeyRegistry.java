import java.util.HashMap;
import java.util.Map;

public class DefaultKeyRegistry {

    private static DefaultKeyRegistry instance;
    private Map<String, Key> keys;

    public static DefaultKeyRegistry getInstance() {
        if (instance == null) {
            instance = new DefaultKeyRegistry();
        }
        return instance;
    }

    private DefaultKeyRegistry() {
        keys = new HashMap<>();
    }
    public void registerKey(String key, Key factory) {
        keys.put(key, factory);
    }
    public Key getKey(String key) {
        return keys.getOrDefault(key,keys.get("default"));
    }
}
