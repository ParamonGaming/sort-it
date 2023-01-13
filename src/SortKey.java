public class SortKey  implements Key {
    private Boolean isAscending;
    public SortKey(boolean isAscending) {
        this.isAscending = isAscending;
    }

    public void execute() {
        System.out.println("Sorting by " + (isAscending? "Ascending" : "descending"));
    }
}
