public class DefaultKeyFactory {
    public IKey create(String key) {
        return new DefaultKey(key);
    }
}
