import java.util.*;
import java.util.function.Consumer;

public class DefaultKeyRegistry {
    private static DefaultKeyRegistry instance;
    private Map<String, Consumer<DefaultKeyRegistry>>keys;
    private MergeSort mergeSort;
    private SortStrategy strategy = new AscendingSortStrategy();

    public static DefaultKeyRegistry getInstance() {
        if (instance == null) {
            instance = new DefaultKeyRegistry();
        }
        return instance;
    }
    public void  SetMergeSort(MergeSort merge) {
        mergeSort= merge;
    }
    public void  SetSortStrategy(SortStrategy strategy) {
        this.strategy= strategy;
    }

    private DefaultKeyRegistry() {
        keys = new HashMap<>();
        keys.put("default", (keyRegistry) -> {
            throw new IllegalArgumentException("Unknown key");
        });
    }
    public void registerKey(String key, Consumer<DefaultKeyRegistry> consumer) {
        try {
            keys.put(key, consumer);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid key or consumer");
        }

    }
    public Consumer<DefaultKeyRegistry> getKey(String key) {
        keys.put("default", (keyRegistry) -> {
            throw new IllegalArgumentException("Unknown key");
        });
        try {
            return keys.getOrDefault(key,keys.get("default"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Unknown key");
            return null;
        }
    }
    public MergeSort execute(List<String> args){
        for(String arg : args){
            try {
            keys.getOrDefault(arg,keys.get("default")).accept(this);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Unknown key");
            }
    }
        mergeSort.setStrategy(strategy);
        return mergeSort;
}
}
