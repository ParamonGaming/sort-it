import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DefaultKeyRegistry {
    private static DefaultKeyRegistry instance;
    private Map<String, Consumer<DefaultKeyRegistry>>keys;
    private MergeSort mergeSort;
    private SortStrategy strategy;

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
    }
    public void registerKey(String key, Consumer<DefaultKeyRegistry> consumer) {
        keys.put(key, consumer);
    }
    public Object getKey(String key) {
        return keys.getOrDefault(key,keys.get("default"));
    }
    public MergeSort execute(String[] args){
        for(String arg : args){
            keys.get(arg).accept(this);
    }
        mergeSort.setStrategy(strategy);
        return mergeSort;
}}
