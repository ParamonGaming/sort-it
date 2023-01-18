class DescendingSortStrategy<T extends Comparable<T>> extends BaseSortStrategy<T> {


    protected boolean compare(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}