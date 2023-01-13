import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        initKeyFactories();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();
        for (String s : args) {
            if (s.startsWith("-")) {
                keys.add(s);
            } else {
                files.add(s);
            }
        }
        MergeSort mergeSort = DefaultKeyRegistry.getInstance().execute(keys);
        String outputFile = files.get(0);
        files.remove(0);
        FileProcessor fileProcessor = new FileProcessor(files,outputFile);
        fileProcessor.writeOutputFile(mergeSort.sort(fileProcessor.getInputData()));
    }
    private static void initKeyFactories() {
        DefaultKeyRegistry registry = DefaultKeyRegistry.getInstance();
        registry.registerKey("-s",  key -> key.SetMergeSort(new MergeSort<String>()));
        registry.registerKey("-d", key -> key.SetSortStrategy(new DescendingSortStrategy()));
        registry.registerKey("-i",key -> key.SetMergeSort(new MergeSort<Integer>()));
        registry.registerKey("-a",key -> key.SetSortStrategy(new AscendingSortStrategy()));
    }
}