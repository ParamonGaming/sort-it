import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        initKeyFactories();
        args = new String[]{"-i", "-a"};
        MergeSort mergeSort = DefaultKeyRegistry.getInstance().execute(args);
        Integer[] a = new Integer[] {3,4};
        mergeSort.sort(a);

    }
    private static void initKeyFactories() {
        DefaultKeyRegistry registry = DefaultKeyRegistry.getInstance();
        registry.registerKey("-s",  key -> key.SetMergeSort(new MergeSort<String>()));
        registry.registerKey("-d", key -> key.SetSortStrategy(new DescendingSortStrategy()));
        registry.registerKey("-i",key -> key.SetMergeSort(new MergeSort<Integer>()));
        registry.registerKey("-a",key -> key.SetSortStrategy(new AscendingSortStrategy()));
        //registry.registerKey("default", new AscendingSortStrategy());
    }
}