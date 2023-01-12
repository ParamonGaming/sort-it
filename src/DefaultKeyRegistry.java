import java.util.HashMap;
import java.util.Map;

public class DefaultKeyRegistry {

    private static DefaultKeyRegistry instance;
    private Map<String, IKeyFactory> factories;

    public static DefaultKeyRegistry getInstance() {
        if (instance == null) {
            instance = new DefaultKeyRegistry();
        }
        return instance;
    }

    private DefaultKeyRegistry() {
        factories = new HashMap<>();
    }
    public void registerFactory(String key, IKeyFactory factory) {
        factories.put(key, factory);
    }
    public IKeyFactory getFactory(String key) {
        return factories.get(key);
    }
}
