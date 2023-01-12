public class SortKey  implements  IKey{
    private String key;
    public SortKey(String key) {
        this.key = key;
    }

    public void execute() {
        System.out.println("Sorting by " + key);
    }
}
