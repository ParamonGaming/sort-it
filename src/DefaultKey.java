public class DefaultKey implements IKey{
    private String key;
    public DefaultKey(String key) {
        this.key = key;
    }

    public void execute() {
        System.out.println("Unknown key " + key);
    }
}
