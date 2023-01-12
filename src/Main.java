public class Main {
    public static void main(String[] args) {

        initKeyFactories();
        String key = "-s";
        IKeyFactory factory = DefaultKeyRegistry.getInstance().getFactory(key);
        IKey keyObject = factory.create(key);
        keyObject.execute();
    }
    private static void initKeyFactories() {
        DefaultKeyRegistry registry = DefaultKeyRegistry.getInstance();
        registry.registerFactory("-s", new DataTypeKeyFactory());
        registry.registerFactory("-d", new SortKeyFactory());
        registry.registerFactory("-i", new DataTypeKeyFactory());
        registry.registerFactory("-a", new SortKeyFactory());
    }
}