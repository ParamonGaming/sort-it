public class SortKeyFactory implements IKeyFactory {
    public IKey create(String key) {
        return new SortKey(key);
    }
}
