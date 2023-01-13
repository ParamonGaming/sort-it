public class Main {
    public static void main(String[] args) {

        initKeyFactories();
        String key = "-f";
        Key keyObject = DefaultKeyRegistry.getInstance().getKey(key);
        keyObject.execute();
    }
    private static void initKeyFactories() {
        DefaultKeyRegistry registry = DefaultKeyRegistry.getInstance();
        registry.registerKey("-s", new DataTypeKey(String.class));
        registry.registerKey("-d", new SortKey(false));
        registry.registerKey("-i", new DataTypeKey(int.class));
        registry.registerKey("-a", new SortKey(true));
        registry.registerKey("default", new DefaultKey());
    }
}